package com.project.boardserver.dto.response;

import com.project.boardserver.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description    :
 * packageName    : com.project.boardserver.dto.response
 * fileName        : UserInfoResponse
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private UserDTO userDTO;
}