package com.project.boardserver.mapper;

import com.project.boardserver.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * description    :
 * packageName    : com.project.boardserver.mapper
 * fileName        : CommentMapper
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Mapper
public interface CommentMapper {
    public int register(CommentDTO commentDTO);
    public void update(CommentDTO commentDTO);
    public void delete(int commentId);
}
