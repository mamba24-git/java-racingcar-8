package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

	@Test
	@DisplayName("문자열에서 생성: 정상")
	void from_ok() {
		TryCount tc = TryCount.from(" 5 ");
		assertThat(tc.value()).isEqualTo(5);
	}

	@Test
	@DisplayName("null/빈 입력/공백")
	void from_null_or_empty_throws() {
		assertThatThrownBy(() -> TryCount.from(null))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> TryCount.from("   "))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> TryCount.from(""))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자가 아닌 입력")
	void from_non_digit_throws() {
		assertThatThrownBy(() -> TryCount.from("3a"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("1 미만 예외")
	void from_lt_one_throws() {
		assertThatThrownBy(() -> TryCount.from("0"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
