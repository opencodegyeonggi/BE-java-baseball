package baseball.service;

import baseball.domain.BaseballFactory;
import baseball.domain.Baseballs;

public class Computer {
    public Baseballs generateRandomBaseballs() {
        return BaseballFactory.createRandomBaseballs();
    }
}
