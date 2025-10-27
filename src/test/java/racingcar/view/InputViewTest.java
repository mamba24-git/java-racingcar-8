package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

	private InputStream originalIn;

	private void setIn(String content) {
		if (originalIn == null) originalIn = System.in;
		System.setIn(new ByteArrayInputStream(content.getBytes()));
	}

	@AfterEach
	void restoreIn() {
		if (originalIn != null) System.setIn(originalIn);
	}

	@Test
	@DisplayName("이름 입력: 앞뒤 공백 제거 없이 원문 반환(현재 구현 기준)")
	void readNamesLine_raw() {
		setIn("lec,nor,ver\n");
		String line = InputView.readNamesLine();
		assertThat(line).isEqualTo("lec,nor,ver");
	}

	@Test
	@DisplayName("시도 횟수 입력: 원문 반환(현재 구현 기준)")
	void readTryCountLine_raw() {
		setIn("5\n");
		String line = InputView.readTryCountLine();
		assertThat(line).isEqualTo("5");
	}

	@Test
	@DisplayName("EOF(빈 입력)이면 IllegalArgumentException")
	void readNamesLine_eof_throws() {
		setIn("");
		assertThatThrownBy(InputView::readNamesLine)
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력 값이 빈 칸이면 IllegalArgumentException")
	void readNamesLine_blank_throws() {
		setIn(" ");
		assertThatThrownBy(InputView::readNamesLine)
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("입력이 너무 길면 IllegalArgumentException")
	void readNamesLine_longName_throws() {
		setIn("convolutionNeuralNetwork");
		assertThatThrownBy(InputView::readNamesLine)
				.isInstanceOf(IllegalArgumentException.class);
	}
}
