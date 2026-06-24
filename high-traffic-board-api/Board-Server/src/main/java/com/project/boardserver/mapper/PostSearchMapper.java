package com.project.boardserver.mapper;

import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.mapper
 * fileName        : PostSearchMapper
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Mapper
public interface PostSearchMapper {
    public List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);

    List<PostDTO> getPostByTag(String tagName);
}
