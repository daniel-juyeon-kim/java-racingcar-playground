package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RaceCountTest {
    @Test
    void raceCountTest() {
        RaceCount raceCount = new RaceCount(3);
        assertThat(raceCount).isNotEqualTo(new RaceCount(2));
        assertThat(raceCount).isEqualTo(new RaceCount(3));
        assertThat(raceCount).isNotEqualTo(new RaceCount(4));
    }

    @Test
    void illegalRaceCountTest() {
        assertThatThrownBy(() -> {
            new RaceCount("0");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessage("레이싱 횟수는 1 이상이여야 합니다.");

        assertThatThrownBy(() -> {
            new RaceCount("asdf2we");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessage("레이싱 횟수가 숫자가 아닙니다.");

        assertDoesNotThrow(() -> {
            new RaceCount("1");
        });

    }
}
