package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NameTest {

    @ParameterizedTest
    @CsvSource({"'Da1ren','a'", "'','pwofe'"})
    void nameValidTest(String nonPass, String pass) {
        assertThatThrownBy(() -> {
            new Name(nonPass);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 0에서 5자리 이내의 문자여야 합니다.");

        assertDoesNotThrow(() -> {
            new Name(pass);
        });

    }
}
