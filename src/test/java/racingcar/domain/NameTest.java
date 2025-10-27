package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("정상 이름 생성")
	void valid_name() {
		Name n = new Name("ver");
		assertThat(n.value()).isEqualTo("ver");
	}

	@Test
	@DisplayName("빈 이름 예외")
	void eof_throws() {
		assertThatThrownBy(() -> new Name(""))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("공백 예외")
	void blank_throws() {
		assertThatThrownBy(() -> new Name("   "))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("6자 초과 예외")
	void too_long_throws() {
		assertThatThrownBy(() -> new Name("junior")) // 6글자
				.isInstanceOf(IllegalArgumentException.class);
	}
}
