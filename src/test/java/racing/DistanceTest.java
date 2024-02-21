package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DistanceTest {
    @Test
    void constructor() {
        Distance distance = new Distance(2);

        assertThat(distance).isEqualTo(new Distance(2));
        assertThat(distance).isNotEqualTo(new Distance(3));
    }

    @Test
    void plus() {
        Distance distance = new Distance(2);
        distance.plus();

        assertThat(distance).isNotEqualTo(new Distance(2));
        assertThat(distance).isEqualTo(new Distance(3));
    }

    @Test
    void isValid() {

        assertThatThrownBy(() -> {
            new Distance(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 이상의 숫자만 가능합니다.");

        assertDoesNotThrow(() -> {
            new Distance(0);
        });

    }
}
