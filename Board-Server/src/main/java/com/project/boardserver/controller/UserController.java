package com.project.boardserver.controller;

import com.project.boardserver.dto.UserDTO;
import com.project.boardserver.dto.request.UserDeleteId;
import com.project.boardserver.dto.request.UserLoginRequest;
import com.project.boardserver.dto.request.UserUpdatePasswordRequest;
import com.project.boardserver.dto.response.LoginResponse;
import com.project.boardserver.dto.response.UserInfoResponse;
import com.project.boardserver.service.impl.UserServiceImpl;
import com.project.boardserver.utils.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * description    :
 * packageName    : com.project.boardserver.controller
 * fileName        : UserController
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */

@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {
    private final UserServiceImpl userService;
    private static LoginResponse loginResponse;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * 회원가입
     * @param userDTO
     */
    @PostMapping("sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void singUp(@RequestBody UserDTO userDTO) {
        if(userDTO.hasNullDataBeforeRegister(userDTO)) {
            throw new RuntimeException("회원가입 정보를 확인해주세요.");
        }
        userService.register(userDTO);
    }

    /**
     * 로그인
     * @param userLoginRequest
     * @param session
     * @return
     */
    @PostMapping("sign-in")
    public HttpStatus login(@RequestBody UserLoginRequest userLoginRequest,
                            HttpSession session){
        String id = userLoginRequest.getUserId();
        String password = userLoginRequest.getPassword();

        UserDTO userInfo = userService.login(id, password);

        if (userInfo == null) {
            return HttpStatus.NOT_FOUND;
        } else {
            loginResponse = LoginResponse.success(userInfo);
            if (userInfo.getStatus() == (UserDTO.Status.ADMIN))
                SessionUtil.setLoginAdminId(session, id);
            else
                SessionUtil.setLoginMemberId(session, id);
        }

        return HttpStatus.OK;
    }

    /**
     * 사용자 정보 조회
     * @param session
     * @return
     */
    @GetMapping("my-info")
    public UserInfoResponse memberInfo(HttpSession session) {
        String id = SessionUtil.getLoginMemberId(session);

        if(id == null) {
            id = SessionUtil.getLoginAdminId(session);
        }
        UserDTO userInfo = userService.getUserInfo(id);
        return new UserInfoResponse(userInfo);
    }

    /**
     * 로그아웃
     * @param session
     */
    @PutMapping("logout")
    public void logout(HttpSession session) {
        SessionUtil.clear(session);
    }

    /**
     * 비밀번호 변경
     * @param userUpdatePasswordRequest
     * @param session
     * @return
     */
    @PatchMapping("password")
    public ResponseEntity<LoginResponse> updateUserPassword(@RequestBody UserUpdatePasswordRequest userUpdatePasswordRequest,
                                                            HttpSession session) {
        ResponseEntity<LoginResponse> responseEntity = null;

        String id = SessionUtil.getLoginMemberId(session);
        String beforePassword = userUpdatePasswordRequest.getBeforePassword();
        String afterPassword = userUpdatePasswordRequest.getAfterPassword();

        try {
            userService.updatePassword(id, beforePassword, afterPassword);
            ResponseEntity.ok(new ResponseEntity<LoginResponse>(HttpStatus.OK));
        } catch (IllegalArgumentException e) {
            log.error("updateUserPassword 실패", e);
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    /**
     * 사용자 삭제
     * @param userDeleteId
     * @param session
     * @return
     */
    @DeleteMapping
    public ResponseEntity<LoginResponse> deleteId(@RequestBody UserDeleteId userDeleteId, HttpSession session) {
        ResponseEntity<LoginResponse> responseEntity = null;
        String id = SessionUtil.getLoginMemberId(session);

        try {
            userService.deleteId(id, userDeleteId.getPassword());
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("deleteId 실패");
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
