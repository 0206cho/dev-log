package com.project.boardserver.mapper;

import com.project.boardserver.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.mapper
 * fileName        : PostMapper
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Mapper
public interface PostMapper {
    public int register(PostDTO postDTO);
    public List<PostDTO> selectMyPosts(int accountId);
    public void update(PostDTO postDTO);
    public void delete(int postId);
}
