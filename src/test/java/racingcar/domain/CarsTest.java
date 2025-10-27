package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	static class AlwaysMove implements MovePolicy { @Override public boolean movable(){ return true; } }
	static class NeverMove implements MovePolicy { @Override public boolean movable(){ return false; } }

	@Test
	@DisplayName("maxPosition과 winners (단독/공동)")
	void winners_cases() {
		Cars cars = new Cars(List.of(new Car(new Name("a")),
				new Car(new Name("b")),
				new Car(new Name("c"))));
		// a:2
		cars.asList().get(0).tryMove(new AlwaysMove());
		cars.asList().get(0).tryMove(new AlwaysMove());
		// b:1
		cars.asList().get(1).tryMove(new AlwaysMove());
		// c:2
		cars.asList().get(2).tryMove(new AlwaysMove());
		cars.asList().get(2).tryMove(new NeverMove()); // stay

		assertThat(cars.maxPosition()).isEqualTo(2);
		assertThat(cars.winnerNames().toString()).isEqualTo("[a]");

		cars.asList().get(1).tryMove(new AlwaysMove());
		assertThat(cars.winnerNames().toString()).isEqualTo("[a, b]");
	}
}
