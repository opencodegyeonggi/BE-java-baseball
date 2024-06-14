package baseball.domain;

import baseball.ui.Output;

public record Baseball(int baseballNumber) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public Baseball {
        isValidBaseballNumber(baseballNumber);
    }

    private void isValidBaseballNumber(int baseballNumber) {
        if (baseballNumber < MIN_NUMBER || baseballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(Output.INPUT_NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
