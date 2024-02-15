package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    private static Stream<Arguments> provideForSplitTest() {
        return Stream.of(
                Arguments.of("1234fa,2r908h", new String [] {"1234fa","2r908h"}),
                Arguments.of("jpr30g,3hjo4p2", new String [] {"jpr30g","3hjo4p2"}),
                Arguments.of(",", new String [] {}),
                Arguments.of(",,", new String [] {})
        );
    }

    @ParameterizedTest
    @MethodSource("provideForSplitTest")
    void spilt(String names, String [] expect) {
        String [] splitedNames = new Spliter().split(names);
        assertThat(splitedNames).isEqualTo(expect);
    }

}
