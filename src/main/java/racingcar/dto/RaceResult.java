/*
 * RaceResult.java
 *
 * ver 1.0
 *
 * 2025/10/27
 */
package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * RaceResult 클래스는 경주가 tryCount 만큼 모두 진행되면 최종 결과를 담는다.
 *
 * @version 1.0 2025/10/27
 * @author  정하람
 */
public class RaceResult {
	private final List<String> winners;

	/**
	 * 우승자 List를 입력받아 경주 결과를 저장
	 *
	 * @param winners 우승한 자동차 이름을 요소로 하는 List
	 */
	public RaceResult(List<String> winners) {
		this.winners = new ArrayList<>(winners);
	}

	/**
	 * 우승자 List를 불러오는 메서드
	 *
	 * @return 출력에서 사용할 때 실제 엔티티의 정보가 수정되지 않도록
	 * unmodifiableList 사용
	 */
	public List<String> winners() {
		return Collections.unmodifiableList(winners);
	}
}
