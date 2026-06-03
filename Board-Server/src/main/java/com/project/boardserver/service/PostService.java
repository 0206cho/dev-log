package com.project.boardserver.service;

import com.project.boardserver.dto.PostDTO;

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
    void register(String id, PostDTO postDTO);
    List<PostDTO> getMyPosts(int accountId);
    void updatePosts(PostDTO postDTO);
    void deletePosts(int userId, int postId);
}
