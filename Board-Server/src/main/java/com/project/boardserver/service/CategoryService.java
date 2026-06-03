package com.project.boardserver.service;

import com.project.boardserver.dto.CategoryDTO;

/**
 * description    :
 * packageName    : com.project.boardserver.service
 * fileName        : CategoryService
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
public interface CategoryService {
    void register(String accountId, CategoryDTO categoryDTO);
    void update(CategoryDTO categoryDTO);
    void delete(int categoryId);
}
