package com.project.boardserver.service;

import com.project.boardserver.dto.UserDTO;

/**
 * description    :
 * packageName    : com.project.boardserver.service
 * fileName        : UserService
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
public interface UserService {
    // 회원가입
    void register(UserDTO userProfile);

    // 로그인
    UserDTO login(String id, String password);

    // 아이디 중복 확인
    boolean isDuplicatedId(String id);

    // 사용자 정보 조회
    UserDTO getUserInfo(String userId);

    // 비밀번호 변경
    void updatePassword(String id, String beforePassword, String afterPassword);

    // 사용자 삭제
    void deleteId(String id, String password);
}
