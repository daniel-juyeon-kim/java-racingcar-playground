package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    void carGoTest() {
        Car car = new Car("dan",0);
        car.go();

        assertThat(car.isSameDistance(new Car("dor", 1))).isTrue();
        assertThat(car.isSameDistance(new Car("dor"))).isFalse();
    }

    @Test
    void carNameTest() {
        Car car = new Car("dan", 1);

        assertThat(car).isEqualTo(new Car("dan", 1));
        assertThat(car).isNotEqualTo(new Car("so", 1));
    }
}
