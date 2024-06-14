package baseball.service;

import baseball.ui.Input;
import baseball.ui.Output;

public class GameManager {
    public void run() {
        BaseballGame baseballGame = new BaseballGame();

        Output.printGameStartPrint();

        Input.initializeScanner();
        try {
            baseballGame.playBaseball();
        } finally {
            Input.closeScanner();
        }
    }
}
