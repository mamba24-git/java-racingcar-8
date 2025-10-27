package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	@DisplayName("쉼표 분리 + 각 토큰 trim")
	void parseNames_ok() {
		List<String> names = Parser.parseNames("  pobi , woni,  jun  ");
		assertThat(names).containsExactly("pobi", "woni", "jun");
	}

	@Test
	@DisplayName("빈 입력 예외")
	void parseNames_empty_throws() {
		assertThatThrownBy(() -> Parser.parseNames("pobi,,woni"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("공백 토큰(, ,) 예외")
	void parseNames_blank_token_throws() {
		assertThatThrownBy(() -> Parser.parseNames("pobi, ,woni"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
