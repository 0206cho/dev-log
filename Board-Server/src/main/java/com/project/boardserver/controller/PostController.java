package com.project.boardserver.controller;

import com.project.boardserver.aop.LoginCheck;
import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.UserDTO;
import com.project.boardserver.dto.response.CommonResponse;
import com.project.boardserver.service.impl.PostServiceImpl;
import com.project.boardserver.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.controller
 * fileName        : PostController
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@RestController
@RequestMapping("/posts")
@Log4j2
public class PostController {
    private final UserServiceImpl userService;
    private final PostServiceImpl postService;

    public PostController(UserServiceImpl userService, PostServiceImpl postService) {
        this.userService = userService;
        this.postService = postService;
    }

    /**
     * 게시글 등록
     * @param accountId
     * @param postDTO
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<PostDTO>> registerPost(String accountId, @RequestBody PostDTO postDTO) {
        postService.register(accountId, postDTO);
        CommonResponse<PostDTO> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "registerPost", postDTO);
        return ResponseEntity.ok(commonResponse);
    }

    /**
     * 게시글 조회 - 본인 작성글
     * @param accountId
     * @return
     */
    @GetMapping("my-posts")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<List<PostDTO>>> myPostInfo(String accountId) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        List<PostDTO> postList = postService.getMyPosts(userInfo.getId());
        CommonResponse<List<PostDTO>> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "myPostInfo", postList);
        return ResponseEntity.ok(commonResponse);
    }

    /**
     * 게시글 수정
     * @param accountId
     * @param postId
     * @param postRequest
     * @return
     */
    @PatchMapping("{postId}")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<PostDTO>> updatePosts(String accountId, @PathVariable(name="postId") int postId, @RequestBody PostRequest postRequest) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        PostDTO postDTO = PostDTO.builder()
                        .id(postId)
                        .name(postRequest.getName())
                        .contents(postRequest.getContents())
                        .views(postRequest.getViews())
                        .categoryId(postRequest.getCategoryId())
                        .userId(postRequest.getUserId())
                        .fileId(postRequest.getFileId())
                        .updateTime(new Date())
                        .build();

        postService.updatePosts(postDTO);
        CommonResponse<PostDTO> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "updatePosts", postDTO);
        return ResponseEntity.ok(commonResponse);

    }

    /**
     * 게시글 삭제
     * @param accountId
     * @param postId
     * @param postDeleteRequest
     * @return
     */
    @DeleteMapping("{postId}")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<PostDeleteRequest>> deletePosts(String accountId,
                                                                         @PathVariable(name="postId") int postId,
                                                                         @RequestBody PostDeleteRequest postDeleteRequest) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        postService.deletePosts(userInfo.getId(), postId);
        CommonResponse<PostDeleteRequest> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "deletePosts", postDeleteRequest);
        return ResponseEntity.ok(commonResponse);
    }

    // -- response 객체 --
    @Getter
    @AllArgsConstructor
    private static class PostResponse {
        private List<PostDTO> postDTOs;
    }

    // -- request 객체 --
    @Getter
    @Setter
    private static class PostRequest {
        private String name;
        private String contents;
        private int views;
        private int categoryId;
        private int userId;
        private int fileId;
        private Date updateTime;
    }

    @Setter
    @Getter
    private static class PostDeleteRequest {
        private int id;
        private int accountId;
    }

}
