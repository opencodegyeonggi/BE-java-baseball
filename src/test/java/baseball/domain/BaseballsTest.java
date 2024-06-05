package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballsTest {
    @Test
    @DisplayName("사용자 입력이 3글자가 아니면 에러를 반환한다.")
    void isValidSize() {
        assertAll(
                "BaseballFactory.createBaseballs should throw IllegalArgumentException for invalid sizes",
                () -> assertThrows(IllegalArgumentException.class, () -> BaseballFactory.createBaseballs("4"), "3글자 보다 작음"),
                () -> assertThrows(IllegalArgumentException.class, () -> BaseballFactory.createBaseballs("4567"), "3글자 보다 큼")
        );
    }

    @Test
    @DisplayName("중복된 숫자가 있으면 에러를 반환한다.")
    void isDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> BaseballFactory.createBaseballs("445"), "중복 숫자 포함");
    }

    @Test
    @DisplayName("리스트 비교 중 숫자의 위치가 정확히 맞는 수만큼 반환한다.")
    void countStrike() {
        Baseballs answer = BaseballFactory.createBaseballs("123");
        Baseballs ask1 = BaseballFactory.createBaseballs("456");
        Baseballs ask2 = BaseballFactory.createBaseballs("873");
        Baseballs ask3 = BaseballFactory.createBaseballs("193");
        Baseballs ask4 = BaseballFactory.createBaseballs("123");

        assertEquals(0, answer.countStrike(ask1), "낫싱");
        assertEquals(1, answer.countStrike(ask2), "1 스트라이크");
        assertEquals(2, answer.countStrike(ask3), "2 스트라이크");
        assertEquals(3, answer.countStrike(ask4), "3 스트라이크");
    }

    @Test
    @DisplayName("리스트 비교 중 숫자가 맞는 수만큼 반환한다.")
    void countBall() {
        Baseballs answer = BaseballFactory.createBaseballs("123");
        Baseballs ask1 = BaseballFactory.createBaseballs("456");
        Baseballs ask2 = BaseballFactory.createBaseballs("417");
        Baseballs ask3 = BaseballFactory.createBaseballs("261");
        Baseballs ask4 = BaseballFactory.createBaseballs("231");

        assertEquals(0, answer.countBall(ask1), "낫싱");
        assertEquals(1, answer.countBall(ask2), "1 볼");
        assertEquals(2, answer.countBall(ask3), "2 볼");
        assertEquals(3, answer.countBall(ask4), "3 볼");
    }
}