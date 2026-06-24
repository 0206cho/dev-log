package com.project.boardserver.controller;

import com.project.boardserver.aop.LoginCheck;
import com.project.boardserver.dto.CommentDTO;
import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.TagDTO;
import com.project.boardserver.dto.UserDTO;
import com.project.boardserver.dto.response.CommonResponse;
import com.project.boardserver.service.impl.PostServiceImpl;
import com.project.boardserver.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.util.Tuple;

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

    /**
     * 댓글 등록
     * @param accountId
     * @param commentDTO
     * @return
     */
    @PostMapping("comments")
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<CommentDTO>> registerPostComments(String accountId, @RequestBody CommentDTO commentDTO) {
        postService.registerComment(commentDTO);
        CommonResponse<CommentDTO> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "registerPostComments", commentDTO);
        return ResponseEntity.ok(commonResponse);
    }

    /**
     * 댓글 수정
     * @param accountId
     * @param commentId
     * @param commentDTO
     * @return
     */
    @PatchMapping("comments/{commentId}")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<CommentDTO>> updateComments(String accountId,
                                                                     @PathVariable(name="commentId") int commentId,
                                                                     @RequestBody CommentDTO commentDTO) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        if(userInfo!=null){
            postService.updateComment(commentDTO);
        }
        CommonResponse<CommentDTO> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "updateComments", commentDTO);
        return ResponseEntity.ok(commonResponse);
    }

    @DeleteMapping("comments/{commentId}")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<String>> deleteComments(String accountId, @PathVariable(name="commentId") int commentId) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        if(userInfo!=null){
            postService.deleteComment(userInfo.getId(), commentId);
        }
        CommonResponse<String> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "deleteComments", "댓글 삭제 완료");
        return ResponseEntity.ok(commonResponse);
    }

    /**
     * 태그 등록
     * @param accountId
     * @param tagDTO
     * @return
     */
    @PostMapping("tags")
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<TagDTO>> registerPostTag(String accountId, @RequestBody TagDTO tagDTO) {
        postService.registerTag(tagDTO);
        CommonResponse<TagDTO> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "registerPostTag", tagDTO);
        return ResponseEntity.ok(commonResponse);
    }

    /**
     * 태그 수정
     * @param accountId
     * @param tagId
     * @param tagDTO
     * @return
     */
    @PatchMapping("tags/{tagId}")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<TagDTO>> updatePostTag(String accountId,
                                                                @PathVariable(name="tagId") int tagId,
                                                                @RequestBody TagDTO tagDTO) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        if(userInfo != null) {
            postService.updateTag(tagDTO);
        }
        CommonResponse<TagDTO> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "updatePostTag", tagDTO);
        return ResponseEntity.ok(commonResponse);
    }

    /**
     * 태그 삭제
     * @param accountId
     * @param tagId
     * @return
     */
    @DeleteMapping("tags/{tagId}")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<String>> deletePostTag(String accountId,
                                                                @PathVariable(name="tagId") int tagId) {
        UserDTO userInfo = userService.getUserInfo(accountId);
        if(userInfo != null) {
            postService.deleteTag(userInfo.getId(), tagId);
        }
        CommonResponse<String> commonResponse = new CommonResponse<>(HttpStatus.OK, "SUCCESS", "deletePostTag", "태그 삭제 완료");
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
