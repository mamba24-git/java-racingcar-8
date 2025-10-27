/*
 * Car.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;

/**
 * Car 엔티티는 자동차 이름인 Name 객체 name, 현재 위치인 Position 객체 position을 멤버로 가짐
 * tryMove() 함수를 통해
 *
 * @version 1.0
 * @author 정하람
 */
public final class Car {

	private final Name name;
	private final Position position;

	/**
	 * Car는 name 을 통해 생성 및 초기화됨
	 *
	 * @param name 자동차 이름
	 */
	public Car(Name name) {
		if (name == null) {
			throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
		}
		this.name = name;
		this.position = new Position();
	}

	/**
	 * MoveablePolicy의 movable() 함수를 호출하여
	 * boolean 값을 받아 전진을 시도하고 해당 값이 true 이면 position 1 증가
	 *
	 * @param policy 전진 가능 결정 함수인 moveable() 함수 호출
	 */
	public void tryMove(MovePolicy policy) {
		if (policy == null) {
			throw new IllegalArgumentException("전진 방법 미지정");
		}
		if (policy.movable()) {
			position.moveForward();
		}
	}

	/**
	 * Name 클래스의 value 메서드를 호출해 해당 자동차의 이름 반환
	 *
	 * @return 자동차 이름 문자열 반환
	 */
	public String name() {
		return name.value();
	}

	/**
	 * Position 클래스의 value 메서드를 호출해 해당 자동차의 위치 반환
	 *
	 * @return 자동차 위치 Integer 반환
	 */
	public int position() {
		return position.value();
	}
}
