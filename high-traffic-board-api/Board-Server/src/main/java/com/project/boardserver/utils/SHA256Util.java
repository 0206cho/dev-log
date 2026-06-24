package com.project.boardserver.utils;

import lombok.extern.log4j.Log4j2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * description    : SHA-256 알고리즘을 이용한 비밀번호 암호화
 * packageName    : com.project.boardserver.utils
 * fileName        : SHA256Util
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Log4j2
public class SHA256Util {
    // 암호화 알고리즘의 이름 (SHA-256 단방향 해시 함수)
    public static final String ENCRYPTION_KEY = "SHA-256";

    /**
     * 문자열을 SHA-256 알고리즘으로 해싱(암호화)
     * @param str 암호화할 원본 문자열
     * @return 암호화가 완료된 64글자의 16진수 문자열
     */
    public static String encryptSHA256(String str) {
        String SHA = null; // 암호화된 결과

        MessageDigest sh;
        try {
            sh = MessageDigest.getInstance(ENCRYPTION_KEY);
            sh.update(str.getBytes());
            byte[] byteData = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (byte byteDatum : byteData) {
                sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        } catch (Exception e) {
            log.error("encryptSHA256: {}", e.getMessage());
            SHA = null;
        }
        return SHA;
    }
}
