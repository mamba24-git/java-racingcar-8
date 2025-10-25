/*
 * TryCount.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;

/**
 * TryCount 는 시도 횟수 값 객체로
 * 생성자에서 입력 형식을 준수하였는지 검증한다.
 *
 * @version 1.0 2025/10/26
 * @author  정하람
 */
public class TryCount {

	private final int value;

	/**
	 * int value 를 받아 TryCount를 생성한다.
	 *
	 * @param value 입력된 시도 횟수
	 * @throws IllegalArgumentException 입력된 정수가 1보다 작은 경우
	 */
	public TryCount(int value) {
		if (value < 1) {
			throw new IllegalArgumentException("시도 횟수는 0일 수 없습니다.");
		}
		this.value = value;
	}

	/**
	 * 입력받은 문자열로 부터 TryCount 를 생성한다.
	 * 혹시 모를 앞뒤 공백을 제거한 뒤,
	 * 문자열이 비어있거나
	 * 남은 문자열 내에 숫자가 아닌 문자가 있는지 검증 수행
	 *
	 * @param line 입력받은 문자열
	 * @return 검증을 무사히 통과한 TryCount
	 * @throws IllegalArgumentException 빈 문자열, 숫자가 아닌 문자가 포함되어 있을 때
	 */
	public static TryCount from(String line) {
		if (line == null) {
			throw new IllegalArgumentException("시도 횟수 입력이 비어있습니다.");
		}
		String lineTrimmed = line.trim();
		if (lineTrimmed.isEmpty()) {
			throw new IllegalArgumentException("시도 횟수 입력이 비어있습니다.");
		}
		for (int i=0; i<lineTrimmed.length(); i++) {
			char c = lineTrimmed.charAt(i);
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
			}
		}
		int n = Integer.parseInt(lineTrimmed);
		return new TryCount(n);
	}

	/** 내부 정수 값 반환 */
	public int value() {
		return value;
	}
}
