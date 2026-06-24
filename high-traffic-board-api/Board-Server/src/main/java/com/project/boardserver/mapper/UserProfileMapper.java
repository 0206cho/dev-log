package com.project.boardserver.mapper;

import com.project.boardserver.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description    :
 * packageName    : com.project.boardserver.mapper
 * fileName        : UserProfileMapper
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Mapper
public interface UserProfileMapper {
    /**
     * 사용자 정보 조회
     * @param id
     * @return
     */
    public UserDTO getUserProfile(@Param("id") String id);

    /**
     * 사용자 삭제
     * @param id
     * @return
     */
    int deleteUserProfile(@Param("id") String id);

    /**
     * 로그인 - 사용자 정보 id, pw로 확인
     * @param id
     * @param password
     * @return
     */
    public UserDTO findByIdAndPassword(@Param("id") String id, @Param("password") String password);

    /**
     * id 중복확인
     * @param id
     * @return
     */
    int idCheck(@Param("id") String id);

    /**
     * 비밀번호 변경
     * @param user
     * @return
     */
    public int updatePassword(UserDTO user);

    /**
     * 회원가입
     * @param userProfile
     * @return
     */
    int register(UserDTO userProfile);
}