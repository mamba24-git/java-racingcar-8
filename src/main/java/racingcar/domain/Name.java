/*
 * Name.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;
/**
 * Name 객체는 자동차의 이름을 표현하는 객체로
 * 생성자에서 입력 형식을 준수하였는지 검증한다.
 *
 * @version 1.0 2025/10/26
 * @author  정하람
 */
public final class Name {

	private static final int MAX_LEN = 5;

	private final String value;

	/**
	 * Name 객체 생성자에서 자동차 이름이 형식을 준수하는지 검증
	 * @param value 실제 사용자 입력에서 파싱되어 들어올 자동차 이름
	 * @throws IllegalArgumentException value가 null 이거나, 길이가 5보다 큰 경우
	 */
	public Name(String value) {
		if ((value == null) || (value.isEmpty())) {
			throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
		}
		if (value.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
		}
		if (value.length() > MAX_LEN) {
			throw new IllegalArgumentException("이름은 5자 이하만 사용 가능합니다.");
		}
		this.value = value;
	}

	/**
	 * 검증을 통과한 자동차 이름 반환
	 * @return 자동차 이름 문자열
	 */
	public String value() {
		return value;
	}
}
