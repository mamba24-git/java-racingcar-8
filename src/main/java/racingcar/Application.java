/*
 * Application.java
 *
 * ver 0.1
 *
 * 2025/10/25
 */
package racingcar;

import racingcar.controller.RaceController;
/**
 * Application.java 실행 시퀀스
 * GameController 실행
 *
 * @version 0.1 2025/10/25
 * @author  정하람
 */
public class Application {
    private Application() {}

    public static void main(String[] args) {
            RaceController controller = new RaceController();
            controller.run();
    }
}
