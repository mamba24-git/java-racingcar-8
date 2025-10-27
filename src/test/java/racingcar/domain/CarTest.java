package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	static class FixedMovePolicy implements MovePolicy {
		private final boolean movable;
		FixedMovePolicy(boolean movable) { this.movable = movable; }
		@Override public boolean movable() { return movable; }
	}

	@Test
	@DisplayName("정책이 true면 전진")
	void tryMove_moves() {
		Car car = new Car(new Name("ver"));
		car.tryMove(new FixedMovePolicy(true));
		assertThat(car.position()).isEqualTo(1);
	}

	@Test
	@DisplayName("정책이 false면 정지")
	void tryMove_stops() {
		Car car = new Car(new Name("ver"));
		car.tryMove(new FixedMovePolicy(false));
		assertThat(car.position()).isEqualTo(0);
	}
}
