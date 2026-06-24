package com.project.boardserver.dto.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * description    :
 * packageName    : com.project.boardserver.dto.request
 * fileName        : UserUpdatePasswordRequest
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Setter
@Getter
public class UserUpdatePasswordRequest {
    @NonNull
    private String beforePassword;
    @NonNull
    private String afterPassword;
}
