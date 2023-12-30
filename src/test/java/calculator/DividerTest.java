import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DividerTest {
    private final Divider divider = new Divider();

    public static Stream<Arguments> provideSeparateTestParameter() {
        return Stream.of(
                Arguments.of("", new String [] {""}),
                Arguments.of("1,2:3", new String [] {"1", "2", "3"}),
                Arguments.of("1,1,1,2:3", new String [] {"1", "1", "1", "2", "3"}),
                Arguments.of("13,2:31,84", new String [] {"13", "2", "31", "84"}),
                Arguments.of("111,2:3:84", new String [] {"111", "2", "3", "84"})
        );
    }

    @DisplayName("커스텀 구분자를 이용한 문자열 구분 테스트")
    @Test
    void separateByCustomSeparator() {
         String [] actual = divider.separateByCustomSeparator("//;\n1;2;3");
         assertThat(actual).isEqualTo(new String [] {"1", "2", "3"});
    }

    //  - [ ] 구분(separator) => 문자열 배열 반환
    @DisplayName("구분자를 이용한 문자열 구분 테스트")
    @ParameterizedTest
    @MethodSource("provideSeparateTestParameter")
    void separate(String expression, String [] expect) {
        String [] result = divider.separate(expression);
        assertThat(result).isEqualTo(expect);
    }
}
