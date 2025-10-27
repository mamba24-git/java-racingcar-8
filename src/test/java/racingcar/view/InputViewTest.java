package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewNsTest extends NsTest {

	@Test
	@DisplayName("정상 입력이면 그대로 반환(하네스에서 한 줄 출력)")
	void names_ok() {
		assertSimpleTest(() -> {
			run("lec,nor,ver\n");
			assertThat(output()).contains("lec,nor,ver");
		});
	}

	@Test
	@DisplayName("EOF(빈 입력)")
	void names_eof_throws() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException(""))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("공백 입력")
	void names_blank_throws() {
		assertSimpleTest(() ->
				assertThatThrownBy(() -> runException(" \n"))
						.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		String line = InputView.readNamesLine();
		System.out.println(line.trim());
	}
}
