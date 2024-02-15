package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void randomNumbersTest() {
        List<Integer> randomNumbers = new Random().createRandomNumbers(10);
        for (Integer randomNumber : randomNumbers) {
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }
}
