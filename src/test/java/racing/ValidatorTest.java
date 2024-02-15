package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidatorTest {

    Validator validator = new Validator();

    public static Stream<Arguments> provideForIsValidCarNames() {
        return Stream.of(
                Arguments.of(new String[] {"afej3"}, true),
                Arguments.of(new String[] {"afej35"}, false),
                Arguments.of(new String[] {"as3fej","2r0h3"}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForIsValidCarNames")
    void isValidCarNames(String [] carNames, boolean expects) {
        boolean actual = validator.isValidCarNames(carNames);
        assertThat(actual).isEqualTo(expects);
    }

    @ParameterizedTest
    @CsvSource({",false","e,false", "0,false", "3ji34,false", "1,true"})
    void isValidRaceCount(String count, boolean expect) {
        if(expect) {
            assertDoesNotThrow(() -> {
                validator.isValidRaceCount(count);
            });
        } else {
            assertThatThrownBy(() -> {
                validator.isValidRaceCount(count);
            }).isInstanceOf(NumberFormatException.class);
        }
    }
}
