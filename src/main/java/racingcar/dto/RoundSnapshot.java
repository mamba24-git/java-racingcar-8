/*
 * RoundSnapshot.java
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
 * RoundSnapshot 클래스는 경주 진행 상황 출력 상황에서
 * 실제 경주 진행 상황 데이터에 불변성을 주기 위해
 * 특정 시점의 스냅샷을 만들고, 이 스냅샷은 이후 컨트롤러를 통해 출력부에서 사용된다.
 *
 * @version 1.0 2025/10/27
 * @author  정하람
 */
public class RoundSnapshot {
	private final List<RoundEntry> entries = new ArrayList<>();

	/**
	 * 해당 함수를 통해 스냅샷의 엔트리에 특정 자동차 엔티티의 현재 상태를 추가
	 *
	 * @param name 특정 시점에서 어떤 자동차의 이름
	 * @param position 특정 시점에서 어떤 자동차의 현재 위치 정보
	 */
	public void add(String name, int position) {
		entries.add(new RoundEntry(name, position));
	}

	/**
	 * @return 데이터 불변성을 위해 unmodifiableList() 로 반환
	 */
	public List<RoundEntry> entries() {
		return Collections.unmodifiableList(entries);
	}
}
