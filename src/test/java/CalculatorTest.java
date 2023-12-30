import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static Stream<Arguments> provideSumElements() {
        return Stream.of(
                Arguments.of(new int [] {1,2,3}, 6),
                Arguments.of(new int [] {4,5,6}, 15),
                Arguments.of(new int [] {1,2,9}, 12),
                Arguments.of(new int [] {999,2,3}, 1004)
        );
    }

    @DisplayName("합산을 확인 하는 테스트")
    @ParameterizedTest
    @MethodSource("provideSumElements")
    void addAll(int [] elements, int expect) {
        Calculator calculator = new Calculator();

        assertThat(calculator.addAll(elements)).isEqualTo(expect);
    }
}
