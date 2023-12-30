import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TypeTransformerTest {

    public static Stream<Arguments> provideArgumentForToIntArrayTest() {
        return Stream.of(
                Arguments.of(new String [] {"1", "1", "2"}, new int [] {1,1,2}),
                Arguments.of(new String [] {"100", "1", "201"}, new int [] {100,1,201}),
                Arguments.of(new String [] {"1234", "1024", "242"}, new int [] {1234, 1024, 242})
        );
    }

    @DisplayName("문자열 배열을 숫자 배열로 변환 테스트")
    @ParameterizedTest
    @MethodSource("provideArgumentForToIntArrayTest")
    void toIntArrayTest(String [] argument, int [] expect) {
        TypeTransformer typeTransformer = new TypeTransformer();
        assertThat(typeTransformer.toIntArray(argument)).isEqualTo(expect);
    }
}
