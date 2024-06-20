package baseball.service;

import baseball.domain.BaseballFactory;
import baseball.domain.Baseballs;
import baseball.ui.Input;
import baseball.ui.Output;

import java.util.Scanner;

public class BaseballGame {
    private final Computer computer = new Computer();
    private Baseballs userBaseballs;
    private Baseballs computerBaseballs;

    public void playBaseball(Scanner scanner) {
        computerBaseballs = computer.generateRandomBaseballs();

        boolean correct = false;

        while(!correct) {
            playBaseballOnce(scanner);
            correct = isCorrectAnswer();
        }

        Output.printCorrectAnswer();
    }

    private void playBaseballOnce(Scanner scanner) {
        userBaseballs = receiveUserBaseballs(scanner);
        Result result = new Result(computerBaseballs, userBaseballs);

        Output.printBaseballGameResult(result.getResult());
    }

    private Baseballs receiveUserBaseballs(Scanner scanner) {
        try {
            return BaseballFactory.createBaseballs(Input.receiveNumberInput(scanner));
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(e.getMessage());

            return receiveUserBaseballs(scanner);
        }
    }

    private boolean isCorrectAnswer() {
        return userBaseballs.equals(computerBaseballs);
    }
}
