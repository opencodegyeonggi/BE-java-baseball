package baseball.service;

import baseball.ui.Input;
import baseball.ui.Output;

import java.util.Scanner;

public class GameManager {
    public void run() {
        BaseballGame baseballGame = new BaseballGame();

        Output.printGameStartPrint();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean isResume = true;

            while (isResume) {
                baseballGame.playBaseball(scanner);

                isResume = isResumeOpinion(scanner);
            }
        }
    }

    private boolean isResumeOpinion(Scanner scanner) {
        try {
            ResumeOrNot opinion = new ResumeOrNot(Input.receiveResumeInput(scanner));

            return opinion.isResume();
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());

            return isResumeOpinion(scanner);
        }
    }
}
