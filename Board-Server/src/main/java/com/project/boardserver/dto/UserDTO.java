package com.project.boardserver.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * description    :
 * packageName    : com.project.boardserver.dto
 * fileName        : UserDTO
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Getter
@Setter
@ToString
public class UserDTO {

    /**
     * 회원가입 유효성
     * @param userDTO
     * @return
     */
    public boolean hasNullDataBeforeRegister(UserDTO userDTO) {
        return userDTO.getUserId() == null || userDTO.getPassword() == null || userDTO.getNickName() == null;
    }

    public enum Status {
        DEFAULT, ADMIN, DELETED
    }
    private int id;
    private String userId;
    private String password;
    private String nickName;
    private boolean admin;
    private Date createTime;
    private boolean isWithDraw;
    private Status status; // 사용자 상태
    private Date updateTime;
}
