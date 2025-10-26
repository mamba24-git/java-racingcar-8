/*
 * MovePolicy.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;

/**
 * MovePolicy 인터페이스는 boolean 값을 반환하는 moveable 함수를 호출하여
 * 해당 값을 통해 자동차의 전진 여부를 결정
 * 이번 과제에서는 RandomMovePolicy 클래스가 이를 상속받아 오버라이딩하여 세부 구현을 진행
 * 어차피 이동 정책이 하나밖에 없긴 하지만 테스트 용이성을 위해 인터페이스를 이용해 작성함
 *
 * @version 1.0
 * @author 정하람
 */
public interface MovePolicy {
	boolean movable();
}
