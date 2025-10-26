/*
 * Position.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;

/**
 * Position 객체는 자동차의 현재 위치를 표현하는 도메인 객체이고,
 * 0 이상이고 TryCount 이하의 값을 가지는 정수로,
 * moveForward 메서드를 이용해 값을 증가시키고 value 메서드로 값을 반환한다.
 *
 * @version 1.0
 * @author 정하람
 */
public class Position {

	private int value;

	/**
	 * 생성자에서는 위치 값을 0으로 초기화한다.
	 */
	public Position() {
		this(0);
	}

	/**
	 * 주어진 값으로 Position 객체를 생성한다.
	 *
	 * @param value 초기 위치 설정값
	 */
	public Position(int value) {
		this.value = value;
	}

	/**
	 * 자동차를 전진(위치가 한 칸 증가)시키는 메서드
	 */
	public void moveForward() {
		this.value += 1;
	}

	/**
	 * 현재 위치 값을 반환히는 메서드
	 *
	 * @return 현재 위치 값(Integer)을 반환
	 */
	public int value() {
		return value;
	}
}
