/*
 * RoundEntry.java
 *
 * ver 1.0
 *
 * 2025/10/27
 */
package racingcar.dto;

/**
 * RoundEntry 클래스는 RoundSnapshot 클래스에서 스냅샷으로 저장될 특정 자동차 엔티티의
 * 현재 상태를 저장함
 *
 * @version 1.0 2025/10/27
 * @author  정하람
 */
public class RoundEntry {
	private final String name;
	private final int position;

	/**
	 * @param name 스냅샷으로 들어갈 자동차 이름
	 * @param position 스냅샷으로 들어갈 자동차 현재 위치 정보
	 */
	public RoundEntry(String name, int position) {
		this.name = name;
		this.position = position;
	}

	/**
	 * 해당 메서드를 통해 이름 반환
	 *
	 * @return 특정 시점에 어떤 자동차의 이름
	 */
	public String name() {
		return name;
	}

	/**
	 * 해당 메서드를 통해 위치 반환
	 *
	 * @return 특정 시점에 어떤 자동차의 위치 정보
	 */
	public int position() {
		return position;
	}
}
