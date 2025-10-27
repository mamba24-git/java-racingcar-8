/*
 * InputView.java
 *
 * ver 0.1
 *
 * 2025/10/26
 */
package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * InputView 클래스는 각종 입력(자동차 이름, 시도 횟수)을 받아 String 으로 반환한다.
 *
 * @version 0.1 2025/10/27
 * @author  정하람
 */
public final class InputView {

	private static final String NAMES_PROMPT =
			"경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)";
	private static final String TRY_COUNT_PROMPT = "시도할 횟수";

	private InputView() {}

	/**
	 * readNamesLine()은 자동차 이름을 입력받고 이를 String 으로 반환한다.
	 * @return 들어온 입력을 String 으로 반환
	 * @exception IllegalArgumentException 들어온 입력이 비어있을 경우 예외 발생 후 프로그램 종료
	 */
	public static String readNamesLine() {
		System.out.println(NAMES_PROMPT);
		String line = Console.readLine();
		if (line == null) {
			throw new IllegalArgumentException("입력이 비어있습니다");
		}
		if (line.trim().isEmpty()) {
			throw new IllegalArgumentException("입력이 비어있습니다");
		}
		return line;
	}
	/**
	 * readTryCountLine()은 자동차 이름을 입력받고 이를 String 으로 반환한다.
	 * @return 들어온 입력을 String 으로 반환
	 * @exception IllegalArgumentException 들어온 입력이 비어있을 경우 예외 발생 후 프로그램 종료
	 */
	public static String readTryCountLine() {
		System.out.println(TRY_COUNT_PROMPT);
		String line = Console.readLine();
		if (line == null) {
			throw new IllegalArgumentException("입력이 비어있습니다");
		}
		if (line.trim().isEmpty()) {
			throw new IllegalArgumentException("입력이 비어있습니다");
		}
		return line;
	}
}


