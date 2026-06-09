package com.project.boardserver.service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * description    : 시스템 로그 및 예외 상황을 슬랙(Slack) 채널로 전송
 * packageName    : com.project.boardserver.service
 * fileName        : SlackService
 * author         : kimminsol
 * date           : 2026. 6. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 5.        kimminsol       최초 생성
 */
@Service
@Log4j2
public class SlackService {
    @Value(value = "${slack.token}")
     String slackToken;

    /**
     * 지정한 슬랙 채널 유형에 맞춰 메시지를 발송하는 메서드
     * * @param message  슬랙 채널에 띄울 본문 텍스트 (에러 내용 등)
     * @param channel  보낼 채널 종류 식별값 ("error" 또는 "warnning")
     */
    public void sendSlackMessage(String message, String channel){

        String channelAddress = ""; // 실제 슬랙 채널의 ID(예: C01234567)를 담을 변수

        // 매개변수로 들어온 문자열 조건에 따라 실제 전송할 슬랙 채널 ID를 매핑
        if(channel.equals("error")){
            // 에러 상황일 때 상수로 정의된 모니터링 채널 ID 주입
            channelAddress = "C0B942TNFRR";
            //channelAddress = "C0B8N0FBLJD";
        }

        try {
            // Slack 라이브러리 싱글톤 인스턴스로부터 주입받은 토큰을 사용해 슬랙 API 통신용 클라이언트 생성
            MethodsClient methods = Slack.getInstance().methods(slackToken);

            // 슬랙 API 요구 규격에 맞춰 전송할 채널 주소와 텍스트 본문을 빌더 패턴으로 조립
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(channelAddress) // 위에서 구한 채널 ID (ex. #error-log 채널 고유값)
                    .text(message)           // 발송할 문자열
                    .build();

            // 슬랙 서버로 최종 메시지 포스팅(발송) 요청
            methods.chatPostMessage(request);

            // 성공 시 스프링 서버 콘솔에 정보 로그를 남김
            log.info("Slack " + channel + " 에 메시지 보냄");

        } catch (SlackApiException | IOException e) {
            log.error("슬랙 메시지 전송 실패: {}", e.getMessage());
        }
    }
}
