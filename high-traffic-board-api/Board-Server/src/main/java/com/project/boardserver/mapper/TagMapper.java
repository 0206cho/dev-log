package com.project.boardserver.mapper;

import com.project.boardserver.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * description    :
 * packageName    : com.project.boardserver.mapper
 * fileName        : TagMapper
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Mapper
public interface TagMapper {
    public int register(TagDTO tagDTO);
    public void update(TagDTO tagDTO);
    public void delete(int tagId);
    public void createPostTag(Integer tagId, Integer postId); // 태그 - 게시글 매핑
}
