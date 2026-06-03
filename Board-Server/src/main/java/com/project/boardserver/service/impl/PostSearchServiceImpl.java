package com.project.boardserver.service.impl;

import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.request.PostSearchRequest;
import com.project.boardserver.mapper.PostSearchMapper;
import com.project.boardserver.service.PostSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.service.impl
 * fileName        : PostSearchServiceImpl
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Service
@Log4j2
public class PostSearchServiceImpl implements PostSearchService {

    @Autowired
    private PostSearchMapper postSearchMapper;

    /**
     * 게시글 통합 검색
     * @param postSearchRequest
     * @return
     */
    @Cacheable(value = "getPosts", key = "'getPosts' + #postSearchRequest.getName() + #postSearchRequest.getCategoryId()")
    @Override
    public List<PostDTO> getPosts(PostSearchRequest postSearchRequest) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.selectPosts(postSearchRequest);
        } catch (RuntimeException e) {
            log.error("selectPosts 메서드 실패" , e.getMessage());
        }
        return postDTOList;
    }
}
