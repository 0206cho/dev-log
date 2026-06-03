package com.project.boardserver.dto;

import lombok.*;

/**
 * description    :
 * packageName    : com.project.boardserver.dto
 * fileName        : TagDTO
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
public class TagDTO {
    private int id;
    private String name;
    private String url;
    private int postId;
}
