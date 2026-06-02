package com.project.boardserver.aop;

import com.project.boardserver.utils.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * description    : @LoginCheck 어노테이션이 붙은 메서드의 로그인 여부를 공통으로 검사하는 AOP 클래스
 * packageName    : com.project.boardserver.aop
 * fileName        : LoginCheckAspect
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@Log4j2
public class LoginCheckAspect {
    /**
     * @Around: 대상 메서드가 실행되기 '전'과 '후' 모두에 개입하여 로직을 수행
     * 표현식 설명: com.project.boardserver.aop.LoginCheck 어노테이션이 붙은 메서드를 타겟으로 삼고,
     * 그 어노테이션의 설정 값(ADMIN인지 USER인지)을 `loginCheck` 변수로 받아옴
     */
    @Around("@annotation(com.project.boardserver.aop.LoginCheck) && @annotation(loginCheck)")
    public Object adminLoginCheck(ProceedingJoinPoint proceedingJoinPoint, LoginCheck loginCheck) throws Throwable {

        // 1. 현재 요청(Request)의 HTTP 세션(HttpSession) 객체를 톰캣 컨텍스트로부터 강제로 스레드 로컬에서 찾아 꺼내옴
        // 컨트롤러가 아니기 때문에 RequestContextHolder를 사용해 우회해서 가져오는 방식
        HttpSession session = (HttpSession) ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();

        String id = null; // 세션에서 꺼낸 사용자 ID를 저장할 변수
        int idIndex = 0;  // 컨트롤러 메서드의 파라미터 중 ID를 꽂아줄 위치(인덱스) 번호 기본값


        // 2. 어노테이션에 설정된 유저 타입(예: @LoginCheck(type = UserType.ADMIN))이 무엇인지 문자열로 가져옴
        String userType = loginCheck.type().toString();

        // 3. 등급(ADMIN 또는 USER)에 맞게 세션에서 로그인된 ID를 꺼내옴
        switch (userType) {
            case "ADMIN": {
                id = SessionUtil.getLoginAdminId(session); // 관리자용 세션 Key로 ID 조회
                break;
            }
            case "USER": {
                id = SessionUtil.getLoginMemberId(session); // 일반 회원용 세션 Key로 ID 조회
                break;
            }
        }

        // 4. 만약 세션에서 꺼낸 ID가 null이라면? -> 로그인이 안 되어 있거나 권한이 없는 상태
        if (id == null) {
            log.debug(proceedingJoinPoint.toString() + " accountName :" + id);
            // 401 Unauthorized 에러와 함께 예외를 던져서 메서드 실행을 강제로 막아버림
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "로그인한 id값을 확인해주세요.") {};
        }

        // 5. 로그인이 확인되었다면 원래 실행하려던 컨트롤러 메서드의 매개변수(Arguments) 배열을 가져옴
        Object[] modifiedArgs = proceedingJoinPoint.getArgs();

        // 6. 메서드의 인자값들이 존재한다면, 0번째 인자(idIndex = 0) 자리에 세션에서 알아낸 로그인 ID를 강제로 주입
        // 이를 통해 컨트롤러 메서드에서는 세션 조회 없이 첫 번째 파라미터로 유저 ID를 편하게 받아 쓸 수 있게 됨
        if(proceedingJoinPoint.getArgs() != null)
            modifiedArgs[idIndex] = id;

        // 7. 로그인 체크가 완료되고 인자값까지 세팅했으니, 원래 실행하려던 진짜 메서드(컨트롤러의 API 기능)를 실행하고 그 결과를 반환
        return proceedingJoinPoint.proceed(modifiedArgs);
    }
}
