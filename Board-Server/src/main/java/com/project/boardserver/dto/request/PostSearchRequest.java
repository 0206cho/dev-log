package com.project.boardserver.dto.request;

import com.project.boardserver.dto.CategoryDTO;
import lombok.*;

/**
 * description    :
 * packageName    : com.project.boardserver.dto.request
 * fileName        : PostSearchRequest
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {
    private int id;
    private String name;
    private String contents;
    private int views;
    private int categoryId;
    private int userId;
    private CategoryDTO.SortStatus sortStatus;
}
