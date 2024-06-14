package baseball.service;

import baseball.domain.BaseballFactory;
import baseball.domain.Baseballs;
import baseball.ui.Input;
import baseball.ui.Output;

public class BaseballGame {
    private final Computer computer = new Computer();
    private Baseballs userBaseballs;
    private Baseballs computerBaseballs;

    public void playBaseball() {
        computerBaseballs = computer.generateRandomBaseballs();

        boolean correct = false;

        while(!correct) {
            playBaseballOnce();
            correct = isCorrectAnswer();
        }

        Output.printCorrectAnswer();
    }

    private void playBaseballOnce() {
        userBaseballs = receiveUserBaseballs();
        Result result = new Result(computerBaseballs, userBaseballs);

        Output.printBaseballGameResult(result.getResult());
    }

    private Baseballs receiveUserBaseballs() {
        try {
            return BaseballFactory.createBaseballs(Input.receiveNumberInput());
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());

            return receiveUserBaseballs();
        }
    }

    private boolean isCorrectAnswer() {
        return userBaseballs.equals(computerBaseballs);
    }
}
