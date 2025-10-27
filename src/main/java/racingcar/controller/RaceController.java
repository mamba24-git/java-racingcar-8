/*
 * RaceController.java
 *
 * ver 1.0
 *
 * 2025/10/27
 */
package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MovePolicy;
import racingcar.domain.Name;
import racingcar.domain.RandomMovePolicy;
import racingcar.domain.TryCount;
import racingcar.dto.RaceResult;
import racingcar.dto.RoundSnapshot;
import racingcar.service.RaceService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * raceController 클래스는 다른 클래스의 다양한 메서드를 활용하여
 * 경주 전반의 흐름을 담당한다.
 *
 * @version 1.0 2025/10/27
 * @author  정하람
 */
public class RaceController {

	private final RaceService service;
	private final MovePolicy policy;

	/**
	 * 기본 생성자에서는 랜덤 전진 정책을 받는다.
	 */
	public RaceController() {
		this(new RandomMovePolicy());
	}

	/**
	 * 테스트용 생성자에서는 전진 정책을 주입 받는다.
	 *
	 * @param policy 테스트용 전진 정책(결과적으로는 랜덤 전진 정책)
	 */
	public RaceController(MovePolicy policy) {
		if (policy == null) {
			throw new IllegalArgumentException("MovePolicy가 null입니다.");
		}
		this.policy = policy;
		this.service = new RaceService();
	}

	/**
	 * 자동차 이름, 시도 횟수 등의 입력값을 받아 객체에 집어넣고
	 * 이를 라운드마다 전진 시도를 진행하고 출력하는 run 메서드
	 */
	public void run() {
		String namesLine = InputView.readNamesLine();
		List<String> rawNames = Parser.parseNames(namesLine);

		List<Car> carList = new ArrayList<>();
		for (String raw : rawNames) {
			carList.add(new Car(new Name(raw)));
		}
		Cars cars = new Cars(carList);

		String tryCountLine = InputView.readTryCountLine();
		TryCount tryCount = TryCount.from(tryCountLine);

		List<RoundSnapshot> snapshots = service.runRound(cars, tryCount, policy);
		for (RoundSnapshot snap : snapshots) {
			OutputView.printRound(snap);
		}

		RaceResult result = service.result(cars);
		OutputView.printWinners(result);
	}
}
