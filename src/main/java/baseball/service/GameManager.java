package baseball.service;

import baseball.ui.Input;
import baseball.ui.Output;

public class GameManager {
    public void run() {
        BaseballGame baseballGame = new BaseballGame();

        Output.printGameStartPrint();

        Input.initializeScanner();
        try {
            boolean isResume = true;

            while (isResume) {
                baseballGame.playBaseball();

                isResume = isResumeOpinion();
            }
        } finally {
            Input.closeScanner();
        }
    }

    private boolean isResumeOpinion() {
        try {
            ResumeOrNot opinion = new ResumeOrNot(Input.receiveResumeInput());

            return opinion.isResume();
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());

            return isResumeOpinion();
        }
    }
}
