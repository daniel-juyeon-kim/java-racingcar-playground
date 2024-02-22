package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class NamesTest {
    @Test
    void namesTest() {
        Names names = new Names(Arrays.asList(new Name("a"), new Name("b")));
        assertThat(names).isEqualTo(new Names(Arrays.asList(new Name("a"), new Name("b"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"), new Name("c"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"))));
    }

    @Test
    void namesTest2() {
        Names names = new Names(new String[]{"a", "b"});
        assertThat(names).isEqualTo(new Names(Arrays.asList(new Name("a"), new Name("b"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"), new Name("c"))));
        assertThat(names).isNotEqualTo(new Names(Arrays.asList(new Name("a"))));
    }
}
