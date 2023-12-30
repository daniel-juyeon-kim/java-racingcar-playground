import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private final Validator validator = new Validator();
    @DisplayName("커스텀 구분자를 확인하는 테스트")
    @Test
    void isValidCustomSeparatorTemplate() {
        String [] trueArgs = {"//;\\n1;2;3", "//a\\n1a2a3", "//a\\n1asdf23"};
        for (String arg : trueArgs) {
            assertTrue(validator.isValidCustomSeparatorTemplate(arg));
        }

        String [] falseArgs = {"/\n1;2;3", "//;\1;2;3", ";\n1;2;3"};
        for (String arg : falseArgs) {
            assertFalse(validator.isValidCustomSeparatorTemplate(arg));
        }
    }

    @DisplayName("음수인지 검증하는 테스트")
    @Test
    void isNegativeIntegerTest() {
        int [] nonPassableValues = new int [] {-1, -123, -17384};
        String expectExceptionMessage = "음수가 있습니다.";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            validator.isPositiveIntegers(nonPassableValues);
        });

        assertTrue(exception.getMessage().contains(expectExceptionMessage));


        int [] passableValues = new int [] {0, 123, 17384};

        assertDoesNotThrow(() -> {
            validator.isPositiveIntegers(passableValues);
        });
    }

    @DisplayName("숫자인지 검증하는 테스트")
    @Test
    void isIntegerTest() {
        String [] nonPassableValues = new String [] {"itn", "1d3"};
        String expectExceptionMessage = "숫자가 아닙니다.";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            validator.isIntegers(nonPassableValues);
        });

        assertTrue(exception.getMessage().contains(expectExceptionMessage));


        String [] passableValues = new String [] {"12489", "0", "-912834"};

        assertDoesNotThrow(() -> {
            validator.isIntegers(passableValues);
        });
    }
}
