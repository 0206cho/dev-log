package com.project.boardserver.mapper;

import com.project.boardserver.dto.CategoryDTO;

/**
 * description    :
 * packageName    : com.project.boardserver.mapper
 * fileName        : CategoryMapper
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */

public interface CategoryMapper {
    public int register(CategoryDTO categoryDTO);
    public void update(CategoryDTO categoryDTO);
    public void delete(int categoryId);
}
