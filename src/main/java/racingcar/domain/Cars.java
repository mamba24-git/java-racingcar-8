/*
 * Cars.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cars 는 Car 객체를 요소로 가지는 List 를 멤버로 가짐
 *
 * @version 1.0
 * @author 정하람
 */
public class Cars {

	private final List<Car> cars;

	/**
	 * @param cars Car 를 요소로 가지는 ArrayList 를 생성
	 */
	public Cars(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			throw new RuntimeException("경주할 자동차는 1대 이상이어야 합니다.");
		}
		this.cars = new ArrayList<>(cars);
	}

	/**
	 * ArrayList 를 리스트 콜렉션으로 변환
	 *
	 * @return Cars 내에서 요소의 변화가 없도록 unmodifiableList() 함수 이용
	 */
	public List<Car> asList() {
		return Collections.unmodifiableList(cars);
	}

	/**
	 * cars의 요소인 Car 들의 위치를 불러와 비교하며 위치 최대값을 갱신
	 *
	 * @return 위치 최대값을 Integer의 형태로 반환
	 */
	public int maxPosition() {
		int max = 0;
		for (Car c : cars) {
			int p = c.position();
			if (p > max) {
				max = p;
			}
		}
		return max;
	}
}
