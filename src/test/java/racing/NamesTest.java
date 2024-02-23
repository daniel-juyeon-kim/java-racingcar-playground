package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class NamesTest {
    @Test
    void namesTest() {
        Names names = new Names(Arrays.asList(new Name("a"), new Name("b")));
        assertThat(names).isEqualTo(new Names(Arrays.asList(new Name("a"), new Name("b"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"), new Name("c"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"))));
    }

    @Test
    void namesTestByString() {

        Names names = new Names("a,b");
        assertThat(names).isEqualTo(new Names(Arrays.asList(new Name("a"), new Name("b"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"), new Name("c"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"))));

        assertDoesNotThrow(() -> {
            new Names("ab");
            new Names("ab,asdf");
        });

        assertThatThrownBy(() -> {
            new Names("");
            new Names(",");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한 개 이상의 자동차 이름을 입력하세요.");
    }

    @Test
    void toStringifyTest() {
        Names names = new Names(Arrays.asList(new Name("a"), new Name("b")));
        assertThat(names.toStringify()).isEqualTo("a,b");
    }
}
