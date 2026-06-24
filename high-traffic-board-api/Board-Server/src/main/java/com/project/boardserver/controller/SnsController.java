package com.project.boardserver.controller;

import com.project.boardserver.config.AWSConfig;
import com.project.boardserver.service.SlackService;
import com.project.boardserver.service.SnsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.*;

import java.util.Map;

/**
 * description    :
 * packageName    : com.project.boardserver.controller
 * fileName        : SnsController
 * author         : kimminsol
 * date           : 2026. 6. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 5.        kimminsol       최초 생성
 */
@Log4j2
@RestController
public class SnsController {

    private final AWSConfig awsConfig;
    private final SnsService snsService;
    private final SlackService slackService;

    public SnsController(AWSConfig awsConfig, SnsService snsService, SlackService slackService) {
        this.awsConfig = awsConfig;
        this.snsService = snsService;
        this.slackService = slackService;
    }

    /**
     * AWS SNS 토픽 생성 API
     * /create-topic?topicName=이름
     * @param topicName
     * @return
     */
    @PostMapping("/create-topic")
    public ResponseEntity<String> createTopic(@RequestParam final String topicName) {
        // AWS SDK 빌더를 이용해 지정한 이름으로 토픽 생성 요청 객체 빌드
        final CreateTopicRequest createTopicRequest = CreateTopicRequest.builder()
                .name(topicName)
                .build();

        // AWS 통신용 SnsClient를 얻어옴
        SnsClient snsClient = snsService.getSnsClient();

        // AWS 실제 서버에 토픽 생성을 요청하고 결과 응답을 받음
        final CreateTopicResponse createTopicResponse = snsClient.createTopic(createTopicRequest);

        // AWS 통신 결과가 성공이 아니라면 에러 응답 예외를 발생
        if (!createTopicResponse.sdkHttpResponse().isSuccessful()) {
            throw getResponseStatusException(createTopicResponse);
        }

        // 로그에 생성된 토픽의 고유 주소(ARN)와 전체 토픽 목록을 출력
        log.info("topic name = " + createTopicResponse.topicArn());
        log.info("topic list = " + snsClient.listTopics());

        snsClient.close();

        return new ResponseEntity<>("TOPIC CREATING SUCCESS", HttpStatus.OK);
    }

    /**
     * AWS SNS 토픽 구독 등록 API
     * 특정 토픽에 알림을 받아볼 수신처를 연결하는 기능
     * /subscribe?endpoint=주소&topicArn=토픽고유주소
     * @param endpoint  알림을 받아볼 목적지 주소 (이메일 주소, HTTP URL 등)
     * @param topicArn  구독할 대상 AWS SNS 토픽의 고유 주소
     */
    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestParam final String endpoint, @RequestParam final String topicArn) {
        // 구독 요청 객체를 빌드
        final SubscribeRequest subscribeRequest = SubscribeRequest.builder()
                .protocol("https")
                .topicArn(topicArn)
                .endpoint(endpoint)
                .build();

        SnsClient snsClient = snsService.getSnsClient();

        // AWS SNS에 구독 처리 요청
        final SubscribeResponse subscribeResponse = snsClient.subscribe(subscribeRequest);

        // HTTP 응답 코드가 성공이 아니면 예외를 발생
        if (!subscribeResponse.sdkHttpResponse().isSuccessful()) {
            throw getResponseStatusException(subscribeResponse);
        }

        // 로그에 생성된 구독 고유 번호(Subscription ARN)와 전체 구독 리스트를 출력
        log.info("topicARN to subscribe = " + subscribeResponse.subscriptionArn());
        log.info("subscription list = " + snsClient.listSubscriptions());

        snsClient.close(); // 자원 해제
        return new ResponseEntity<>("TOPIC SUBSCRIBE SUCCESS", HttpStatus.OK);
    }

    /**
     * AWS SNS 메시지 발행(전송) API
     * 특정 토픽을 구독하고 있는 모든 수신처(HTTPS Endpoint, 이메일 등)에 메시지를 일괄 뿌리는 기능\
     * /publish?topicArn=토픽고유주소
     * @param topicArn  메시지를 보낼 타겟 토픽 고유 주소
     * @param message   보낼 내용 (JSON 바디 맵 구조)
     */
    @PostMapping("/publish")
    public String publish(@RequestParam String topicArn, @RequestBody Map<String, Object> message) {
        SnsClient snsClient = snsService.getSnsClient();

        // 발송할 제목과 본문(Map을 문자열로 변환)을 담아 발행 요청 객체 빌드
        final PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(topicArn)
                .subject("HTTP ENDPOINT TEST MESSAGE") // 알림 메일/푸시의 제목 영역
                .message(message.toString())           // 알림 본문 영역
                .build();

        // AWS SNS 서버를 통해 메시지를 전송
        PublishResponse publishResponse = snsClient.publish(publishRequest);

        // 전송 결과의 HTTP 상태 코드를 로그에 남김
        log.info("message status:" + publishResponse.sdkHttpResponse().statusCode());

        snsClient.close(); // 자원 해제

        // 발송 성공 시 AWS가 부여한 고유 메시지 ID를 반환
        return "sent MSG ID = " + publishResponse.messageId();
    }

    /**
     * AWS 통신 실패 시 내부 HTTP 에러(500 Internal Server Error) 예외 객체를 조립
     */
    private ResponseStatusException getResponseStatusException(SnsResponse response) {
        return new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, response.sdkHttpResponse().statusText().get()
        );
    }

    /**
     * 슬랙 모니터링 에러 알림 테스트 API
     * /slack/error
     */
    @GetMapping("/slack/error")
    public void error(){
        log.info("슬랙 error 채널 테스트");

        // slackService를 활용해 지정된 워크스페이스의 'error' 전용 채널로 즉시 알림 테스트 메시지를 보냅니다.
        slackService.sendSlackMessage("슬랙 에러 테스트", "error");
    }
}
