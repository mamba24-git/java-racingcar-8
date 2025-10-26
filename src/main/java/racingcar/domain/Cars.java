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
 * Cars 는
 *
 * @version 1.0
 * @author 정하람
 */
public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			throw new RuntimeException("경주할 자동차는 1대 이상이어야 합니다.");
		}
		this.cars = new ArrayList<>(cars);
	}

	public List<Car> asList() {
		return Collections.unmodifiableList(cars);
	}
}
