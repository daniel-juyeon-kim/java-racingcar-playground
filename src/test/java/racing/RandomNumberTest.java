package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @Test
    void randomNumberTest() {
        RandomNumber maxRandomNumber = new RandomNumber(9);

        for (int i = 0; i < 100; i++) {
            assertThat(new RandomNumber().isLessOrEqual(maxRandomNumber)).isTrue();
        }
    }

    @Test
    void isOverOrEqualTest() {
        RandomNumber four = new RandomNumber(4);

        assertThat(four.isOverOrEqual(new RandomNumber(4))).isTrue();
        assertThat(four.isOverOrEqual(new RandomNumber(5))).isFalse();
        assertThat(four.isOverOrEqual(new RandomNumber(3))).isTrue();
    }
}
