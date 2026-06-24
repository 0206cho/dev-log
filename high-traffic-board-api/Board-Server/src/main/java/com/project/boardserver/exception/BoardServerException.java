package com.project.boardserver.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * description    :
 * packageName    : com.project.boardserver.exception
 * fileName        : BoardServerException
 * author         : kimminsol
 * date           : 2026. 6. 4.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 4.        kimminsol       최초 생성
 */
@AllArgsConstructor
@Getter
@Setter
public class BoardServerException extends RuntimeException{
    HttpStatus code;
    String msg;
}
