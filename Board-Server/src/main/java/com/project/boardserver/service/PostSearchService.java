package com.project.boardserver.service;

import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.request.PostSearchRequest;

import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.service
 * fileName        : PostSearchService
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
public interface PostSearchService {
    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);
}
