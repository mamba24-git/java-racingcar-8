/*
 * Parser.java
 *
 * ver 1.0
 *
 * 2025/10/26
 */
package racingcar.util;

import java.util.ArrayList;
import java.util.List;
/**
 * Parser 클래스는 이름 입력을 받아 쉼표를 구분자로 하여 각 이름을 나누고
 * 각 이름을 담아 List 로 반환한다.
 *
 * @version 1.0 2025/10/26
 * @author  정하람
 */
public class Parser {

	private Parser() {};

	/**
	 * parseNames()는 입력받은 String 을 쉽표를 구분자로 하여 각 이름을 나누고
	 * 각 이름을 담아 List 로 반환한다.
	 * @return 들어온 입력을 List 로 반환
	 * @exception IllegalArgumentException 들어온 입력에서
	 * 구분자로 나눈 항목 중 빈 항목이 있는 경우 예외 발생 후 프로그램 종료
	 */
	public static List<String> parseNames(String line) {
		if (line == null) {
			throw new IllegalArgumentException("입력값이 비어있습니다.");
		}

		String[] tokens = line.split(",");
		List<String> names = new ArrayList<>();
		for (String name : tokens) {
			if (name.isEmpty()) {
				throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
			}
			names.add(name);
		}
		return names;
	}
}
