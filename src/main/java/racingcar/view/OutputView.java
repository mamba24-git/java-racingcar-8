/*
 * OutputView.java
 *
 * ver 1.0
 *
 * 2025/10/27
 */
package racingcar.view;

import java.util.List;
import racingcar.dto.RaceResult;
import racingcar.dto.RoundEntry;
import racingcar.dto.RoundSnapshot;

/**
 * OutputView 클래스는 실제 출력을 담당한다
 *
 * @version 1.0 2025/10/27
 * @author  정하람
 */
public class OutputView {

	private OutputView() {}

	/**
	 * 스냅샷의 자동차들이 라운드를 진행하였을 때의 결과를 출력
	 *
	 * @param snapshot 출력해야 하는 시점의 자동차 엔티티 콜렉션의 스냅샷
	 */
	public static void printRound(RoundSnapshot snapshot) {
		for (RoundEntry e : snapshot.entries()) {
			String line = renderRoundLine(e.name(), e.position());
			System.out.println(line);
		}
		System.out.println();
	}

	/**
	 * 경주 진행 결과를 구분자를 넣고 문자열로 만들어 출력
	 *
	 * @param result 경주 진행 결과 입력
	 */
	public static void printWinners(RaceResult result) {
		List<String> winners = result.winners();
		String winnersJoined = String.join(", ", winners);
		System.out.println("최종 우승자 : " + winnersJoined);
	}

	/**
	 * 전진 시도 결과를 자동차 이름과 위치를 합쳐 문자열로 만듦
	 *
	 * @param name 자동차 이름 입력
	 * @param position 자동차 현재 위치 입력
	 * @return 전진 시도 결과를 해당 자동차와 함께 묶어 규격에 맞는 문자열로 반환
	 */
	public static String renderRoundLine(String name, int position) {
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" : ");
		for (int i=0; i<position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
}
