package baseball.service;

import baseball.domain.Baseballs;
import baseball.ui.Output;

public class Result {
    private static final int COUNT_ZERO = 0;

    private final int strikeNumber;
    private final int ballNumber;

    public Result(Baseballs computerBaseballs, Baseballs userBaseballs) {
        strikeNumber = computerBaseballs.countStrike(userBaseballs);
        ballNumber = computerBaseballs.countBall(userBaseballs);
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();

        if (strikeNumber == COUNT_ZERO && ballNumber == COUNT_ZERO) {
            sb.append(Output.RESULT_NOTHING_MESSAGE);
        }

        if (strikeNumber != COUNT_ZERO) {
            sb.append(strikeNumber).append(Output.RESULT_STRIKE_MESSAGE);
        }

        if (ballNumber != COUNT_ZERO) {
            sb.append(ballNumber).append(Output.RESULT_BALL_MESSAGE);
        }

        return sb.toString();
    }
}
