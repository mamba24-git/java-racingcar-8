/*
 * RandomMovePolicy.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * RandomMovePolicy 클래스는 MovePolicy 인터페이스를 상속받아
 * movable() 함수를 오버라이드하여 상세 구현
 *
 * @version 1.0
 * @author 정하람
 */
public final class RandomMovePolicy implements MovePolicy {

	private static final int LOWER_BOUND = 0;
	private static final int UPPER_BOUND = 9;
	private static final int THRESHOLD = 4;

	/**
	 * 난수를 뽑고 기준값 이상이면 true, 작으면 false
	 *
	 * @return 전진 여부를 반영하는 boolean 값 반환
	 */
	@Override
	public boolean movable() {
		int n = Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
		if (n >= THRESHOLD) {
			return true;
		}
		return false;
	}
}
