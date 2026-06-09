package com.project.boardserver.service;

import com.project.boardserver.config.AWSConfig;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

/**
 * description    : AWS SNS(Simple Notification Service) 클라이언트 생성 및 인증 관리
 * packageName    : com.project.boardserver.service
 * fileName        : SnsService
 * author         : kimminsol
 * date           : 2026. 6. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 5.        kimminsol       최초 생성
 */


@Service
public class SnsService {

    AWSConfig awsConfig;

    public SnsService(AWSConfig awsConfig) {
        this.awsConfig = awsConfig;
    }

    /**
     * AWS 서비스들에 접근할 수 있는 '신분증(자격 증명 공급자)'을 발급하는 메서드
     * @param accessKeyID
     * @param secretAccessKey
     * @return
     */
    public AwsCredentialsProvider getAwsCredentials(String accessKeyID, String secretAccessKey) {
        // 전달받은 Access Key와 Secret Key쌍을 조합하여 기본 자격 증명 객체 생성
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKeyID, secretAccessKey);

        // AwsCredentialsProvider 인터페이스의 요구 메서드를 구현해 반환
        // () -> awsBasicCredentials : "인증서 필요할 때 방금 만든 이 키 세트를 넘겨줘"
        return () -> awsBasicCredentials;
    }

    /**
     * 실제 알림(SMS, 푸시 등)을 요청할 때 사용하는 AWS SNS 통신용 클라이언트 객체를 빌드
     * @return
     */
    public SnsClient getSnsClient() {
        // AWS SDK의 SnsClient 빌더 패턴을 사용하여 클라이언트를 조립
        return SnsClient.builder()
                // getAwsCredentials 메서드를 호출하여 AWSConfig에 들어있는 키 정보로 인증을 설정
                .credentialsProvider(
                        getAwsCredentials(awsConfig.getAwsAccessKey(), awsConfig.getAwsSecretKey())
                )
                // AWSConfig에 설정된 리전 정보를 기반으로 서비스 지역을 지정
                .region(Region.of(awsConfig.getAwsRegion()))
                // 설정을 마친 최종 SnsClient 인스턴스를 생성(build)하여 반환
                .build();
    }
}