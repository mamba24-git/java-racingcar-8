/*
 * RaceService.java
 *
 * ver 1.0
 *
 * 2025/10/27
 */
package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MovePolicy;
import racingcar.domain.TryCount;
import racingcar.dto.RaceResult;
import racingcar.dto.RoundSnapshot;

/**
 * RaceService 클래스는 실제로 각 라운드마다 전진 시도를 실행하고 경주를 한 턴 진행
 *
 * @version 1.0 2025/10/27
 * @author  정하람
 */
public class RaceService {

	/**
	 * 각 라운드마다 스냅샷을 받아와 경주를 한 턴 진행
	 *
	 * @param cars 스냅샷의 자동차 콜렉션
	 * @param tryCount 스냅샷의 시도 횟수
	 * @param policy 스냅샷의 전진 시도 정책
	 * @return 라운드 진행 결과를 담은 스냅샷 반환
	 */
	public List<RoundSnapshot> runRound(Cars cars, TryCount tryCount, MovePolicy policy) {
		if (cars == null) {
			throw new IllegalArgumentException("Cars가 null입니다.");
		}
		if (tryCount == null) {
			throw new IllegalArgumentException("TryCount가 null입니다.");
		}
		if (policy== null) {
			throw new IllegalArgumentException("MovePolicy가 null입니다.");
		}
		List<RoundSnapshot> snapshots = new ArrayList<>();
		int times = tryCount.value();
		for (int t=0; t<times; t++) {
			for (Car c : cars.asList()) {
				c.tryMove(policy);
			}
			RoundSnapshot snap = new RoundSnapshot();
			for (Car c : cars.asList()) {
				snap.add(c.name(), c.position());
			}
			snapshots.add(snap);
		}
		return snapshots;
	}

	/**
	 * @param cars Cars 콜렉션 입력
	 * @return 경주 진행 결과 반환
	 */
	public RaceResult result(Cars cars) {
		if (cars == null) {
			throw new IllegalArgumentException("Cars가 null입니다.");
		}
		return new RaceResult(cars.winnerNames());
	}
}
