package com.project.boardserver.service.impl;

import com.project.boardserver.dto.UserDTO;
import com.project.boardserver.exception.DuplicateIdException;
import com.project.boardserver.mapper.UserProfileMapper;
import com.project.boardserver.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.project.boardserver.utils.SHA256Util.encryptSHA256;

/**
 * description    :
 * packageName    : com.project.boardserver.service.impl
 * fileName        : UserServiceImpl
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    public UserServiceImpl(UserProfileMapper userProfileMapper) {
        this.userProfileMapper = userProfileMapper;
    }

    /**
     * 회원가입
     * @param userProfile
     */
    @Override
    public void register(UserDTO userProfile) {
        // id 중복 확인
        boolean dupleIdResult = isDuplicatedId(userProfile.getUserId());

        if(dupleIdResult) {
            throw new DuplicateIdException("중복된 아이디입니다.");
        }
        // 등록/갱신시간
        userProfile.setCreateTime(new Date());
        userProfile.setUpdateTime(new Date());

        // 비밀번호 암호화
        userProfile.setPassword(encryptSHA256(userProfile.getPassword()));
        int insertCount = userProfileMapper.register(userProfile);

        if(insertCount != 1) {
            log.error("insertMember ERROR! {}", userProfile);
            throw new RuntimeException(
                    "insertUser ERROR! 회원가입 메서드를 확인해주세요\n" + "Params : " + userProfile);
        }
    }

    /**
     * 로그인
     * @param id
     * @param password
     * @return
     */
    @Override
    public UserDTO login(String id, String password) {
        // 복호화하여 실제 암호화된 비밀번호 찾기
        String cryptopassword = encryptSHA256(password);
        UserDTO user = userProfileMapper.findByIdAndPassword(id, cryptopassword);
        return user;
    }

    /**
     * id 중복확인
     * @param id
     * @return
     */
    @Override
    public boolean isDuplicatedId(String id) {
        return userProfileMapper.idCheck(id) == 1;
    }

    /**
     * 사용자 정보 조회
     * @param userId
     * @return
     */
    @Override
    public UserDTO getUserInfo(String userId) {
        return userProfileMapper.getUserProfile(userId);
    }

    /**
     * 비밀번호 변경
     * @param id
     * @param beforePassword
     * @param afterPassword
     */
    @Override
    public void updatePassword(String id, String beforePassword, String afterPassword) {
        String cryptopassword = encryptSHA256(beforePassword);
        UserDTO userInfo = userProfileMapper.findByIdAndPassword(id, cryptopassword);

        if(userInfo != null) {
            userInfo.setPassword(encryptSHA256(afterPassword));
            int insertCount = userProfileMapper.updatePassword(userInfo);
        } else {
            log.error("updatePassword ERROR! {}", userInfo);
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }

    /**
     * 사용자 삭제
     * @param id
     * @param password
     */
    @Override
    public void deleteId(String id, String password) {
        String cryptopassword = encryptSHA256(password);
        UserDTO userInfo = userProfileMapper.findByIdAndPassword(id, cryptopassword);

        if(userInfo != null) {
            int deleteCount = userProfileMapper.deleteUserProfile(id);
        } else {
            log.error("deleteId ERROR! {}", userInfo);
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }
}
