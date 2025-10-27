# java-racingcar-precourse

## 구현 기능 목록
1. 입력 및 검증
   - [x] 이름 문자열을 입력받음
   - [x] 쉼표로 구분하여 각 이름을 나눔
   - [x] 쉼표로 구분된 각 공간이 빈 칸이 아닌지, 5자 이하인지 검증
   - [x] 시도 횟수 입력받음
   - [x] 시도 횟수가 `Integer` 이고 1 이상인지 검증
2. 도메인 동작
   - [x] 이름과 위치를 가지는 자동차 객체 정의
   - [x] 자동차 객체를 가지는 리스트 생성
   - [x] 전진 시도 수행_0~9의 무작위 정수를 뽑아 4이상이면 전진
   - [x] 라운드마다 각 자동차가 전진 시도를 1회 수행
   - [x] 전진 시도 성공시 자동차의 위치값을 +1 함
   - [x] 지정된 시도 횟수만큼 전체 라운드 진행
   - [x] 자동차들의 최대 전진 위치를 뽑음
   - [x] 최대 전진 위치에 있는 자동차들을 우승자 List 에 저장
3. 출력
   - [x] 각 라운드가 끝날 때마다 차수별 실행 결과 출력
   - [x] 모든 라운드 종료후 최종 우승자(들) 출력
   - [x] 특정 시점에서 특정 차의 현재 상태를 규격에 맞는 문자열로 변환
4. 예외 및 종료
   - [x] 오입력 시 `IllegalArgumentException` 을 발생시키고 애플리케이션 종료
## 테스트
1. 입력/파싱 검증
   - [x] `InputView` 이름 입력: null/빈 문자열/공백만 입력 시 `IllegalArgumentException`
   - [ ] `InputView` 이름 입력: 쉼표(,) 기준 분리 후 각 토큰 trim, 빈 토큰(공백)/긴 토큰(5글자 이상)이 있으면 `IllegalArgumentException`
   - [x] `InputView` 시도 횟수 입력: null/빈 문자열 입력 시 `IllegalArgumentException`
   - [x] `Parser.parseNames` 결과: 토큰 파싱이 제대로 되었는지 확인
   - [x] `Name` 값 객체: 공백/빈값/6자 이상 `IllegalArgumentException`
   - [x] `TryCount` 값 객체: 문자열 입력에서 자연수만 허용, 아니면 `IllegalArgumentException`
2. 도메인 동작
   - [ ] `RandomMovePolicy`: 경계값 검증(3 → 정지, 4 → 전진)
   - [ ] `Car.tryMove(policy)`: 전진/정지에 따른 위치 변화 검증
   - [ ] `Cars`: `maxPosition()` 및 `winners()`
3. 출력 포맷 확인
   - [ ] 최종 우승자 출력