package com.project.boardserver.exception.handler;

import com.project.boardserver.dto.response.CommonResponse;
import com.project.boardserver.exception.BoardServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * description    : 애플리케이션 전역의 예외를 감지하여 공통 레이아웃으로 응답
 * packageName    : com.project.boardserver.exception.handler
 * fileName        : CustomExceptionHandler
 * author         : kimminsol
 * date           : 2026. 6. 4.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 4.        kimminsol       최초 생성
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    // RuntimeException 예외 처리 전용
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e) {
        CommonResponse commonResponse = new CommonResponse(HttpStatus.OK, "RuntimeException", e.getMessage(), e.getMessage());
        return new ResponseEntity<>(commonResponse, new HttpHeaders(), commonResponse.getStatus());
    }

    // 커스텀 - BoardServerException 처리 전용
    @ExceptionHandler({BoardServerException.class})
    public ResponseEntity<Object> BoardServerException(BoardServerException e) {
        CommonResponse commonResponse = new CommonResponse(HttpStatus.OK, "BoardServerException", e.getMessage(), e.getMessage());
        return new ResponseEntity<>(commonResponse, new HttpHeaders(), commonResponse.getStatus());
    }

    // 최상위 예외(Exception) 처리 전용
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> Exception(Exception e) {
        CommonResponse commonResponse = new CommonResponse(HttpStatus.OK, "Exception", e.getMessage(), e.getMessage());
        return new ResponseEntity<>(commonResponse, new HttpHeaders(), commonResponse.getStatus());
    }
}