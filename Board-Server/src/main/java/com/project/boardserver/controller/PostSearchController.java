package com.project.boardserver.controller;

import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.request.PostSearchRequest;
import com.project.boardserver.service.impl.PostSearchServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description    : 게시글 검색 요청을 처리
 * packageName    : com.project.boardserver.controller
 * fileName        : PostSearchController
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@RestController
@RequestMapping("/search")
@Log4j2
@RequiredArgsConstructor
public class PostSearchController {

    private final PostSearchServiceImpl postSearchService;

    /**
     * 게시글 통합 검색
     * @param postSearchRequest
     * @return
     */
    @PostMapping
    public PostSearchResponse search(@RequestBody PostSearchRequest postSearchRequest) {
        List<PostDTO> postDTOList = postSearchService.getPosts(postSearchRequest);
        return new PostSearchResponse(postDTOList);
    }

    // -- response 객체 --
    @Getter
    @AllArgsConstructor
    private static class PostSearchResponse {
        private List<PostDTO> postDTOList;
    }
}
