package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {
    @Test
    @DisplayName("유효하지 않은 숫자를 입력하면 에러를 반환한다.")
    void testInvalidBaseballNumber() {
        assertAll(
                "Baseball constructor should throw IllegalArgumentException for invalid number",
                () -> assertThrows(IllegalArgumentException.class, () -> new Baseball(0), "1 이하의 수 입력"),
                () -> assertThrows(IllegalArgumentException.class, () -> new Baseball(0), "9 이상의 수 입력")
        );
    }
}