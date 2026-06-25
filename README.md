# 🚀 Dev-Log: 개발 기록 저장소

학습한 알고리즘, 프레임워크, 그리고 실무적인 기술 활용법을 정리하는 공간입니다.  

---
<br/>

## 📂 Repository Structure

| 카테고리 | 설명 | 주요 내용 |
| :--- | :--- | :--- |
| **[Algorithm](./Algorithm/baekjoon)** | 알고리즘 문제 풀이 | Java 풀이 및 상세 이론 정리 (`.java`, `.md`) |
| **[React](./React)** | 프런트엔드 라이브러리 학습 | React Hook, 컴포넌트 설계, 상태 관리 등 |
| **[Crypto](./Crypto)** | 전자정부프레임워크 보안 설정 | `globals.properties` DB 정보 암호화 도구 |
| **[Go-AI-Xmas](./go-ai-xmas-card)** | Go 기반 AI 크리스마스 카드 생성 서비스 | Go 언어 활용, AI API 연동 및 카드 생성 로직|
| **[High-Traffic](./high-traffic-board-api)** | 대용량 트래픽 처리 게시판 API 구축 | 고성능 아키텍처 설계, 대용량 트래픽 분산 및 데이터베이스 최적화 |

---
<br/>

## 📝 상세 기록 가이드

### 💡 Algorithm (Baekjoon)
<table border="0" style="border-collapse: collapse; border-style: hidden;">
  <tr>
    <td width="60%" style="border: none;">
      문제 풀이와 함께 해당 알고리즘의 핵심 이론을 병행 기록합니다.
      <ul>
        <li><code>ex_날짜.java</code>: 문제 해결을 위한 소스 코드</li>
        <li><code>ex_날짜.md</code>: 문제 접근 방식 및 시간 복잡도 분석</li>
      </ul>
      <br/>
     <a href="https://0206cho.tistory.com/category/Algorithms%20%26%20Education/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98"><img src="https://img.shields.io/badge/Blog-알고리즘 분석 및 풀이 노트-blue?style=flat-square&logo=tistory"/></a>
    </td>
    <td width="40%" align="center" style="border: none;">
      <a href="https://solved.ac/0206cho/">
        <img src="http://mazassumnida.wtf/api/v2/generate_badge?boj=0206cho" alt="Solved.ac Profile">
      </a>
    </td>
  </tr>
</table>
<br/>
  

### 💡 React
* 컴포넌트 생명주기와 성능 최적화 학습
* 실습 프로젝트 및 라이브러리(Redux, Axios 등) 연동 기록
* <a href="https://0206cho.tistory.com/category/Web%20Development/React"><img src="https://img.shields.io/badge/Blog-React 핵심 개념 및 실습 기록-61DAFB?style=flat-square&logo=tistory"/></a>
<br/>

### 💡 Crypto (eGovFrame)
전자정부프레임워크 환경에서 보안성을 높이기 위한 유틸리티
* `globals.properties` 내 DB 접속 정보(ID/PW) 암호화
* 환경 설정 및 즉시 적용 가능한 프로젝트 파일 포함
* <a href="https://0206cho.tistory.com/305"><img src="https://img.shields.io/badge/Blog-전자정부프레임워크 보안 설정 가이드-green?style=flat-square&logo=tistory"/></a>
<br/>

### 💡 Go-AI-Xmas-Card
* Go 언어를 활용하여 AI 기반의 크리스마스 카드를 생성하는 Web Application
* main.go / card.go: Go 기반의 백엔드 비즈니스 로직 및 AI API 연동 코드
* README.md: 프롬프트 엔지니어링, 생성형 AI API 연동 가이드 및 실행 방법 안내
<br/>

### 💡 High-Traffic-Board-API
* 대용량 트래픽 환경을 가정하여 성능 최적화와 안정적인 데이터 처리를 목표로 설계한 게시판 API 프로젝트
* 데이터베이스(RDBMS) 인덱스 최적화 및 쿼리 튜닝 기록
* 대규모 동시 요청(High-Traffic)을 처리하기 위한 서버 아키텍처 및 캐시 전략 실습
<br/>
