package com.project.boardserver.service;

import com.project.boardserver.dto.CommentDTO;
import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.TagDTO;

import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.service
 * fileName        : PostService
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
public interface PostService {
    // 게시글
    void register(String id, PostDTO postDTO);
    List<PostDTO> getMyPosts(int accountId);
    void updatePosts(PostDTO postDTO);
    void deletePosts(int userId, int postId);

    // 댓글
    void registerComment(CommentDTO commentDTO);
    void updateComment(CommentDTO commentDTO);
    void deleteComment(int userId, int commentId);

    // 태그
    void registerTag(TagDTO tagDTO);
    void updateTag(TagDTO tagDTO);
    void deleteTag(int userId, int tagId);
}
