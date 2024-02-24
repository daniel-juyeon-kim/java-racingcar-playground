package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    void carGoTest() {
        Car car = new Car(new Name("dan"),0);
        car.go(new RandomNumber(4));

        assertThat(car.isSameDistance(new Car(new Name("dor"), 1))).isTrue();
        assertThat(car.isSameDistance(new Car(new Name("so")))).isFalse();

        car.go(new RandomNumber(3));

        assertThat(car.isSameDistance(new Car(new Name("dor"), 0))).isFalse();
    }

    @Test
    void carNameTest() {
        Car car = new Car(new Name("dan"), 1);

        assertThat(car).isEqualTo(new Car(new Name("dan"), 1));
        assertThat(car).isNotEqualTo(new Car(new Name("so"), 1));
    }

    @Test
    void toStringifyRaceResult() {
        Car car = new Car(new Name("Dan"), 5);
        assertThat(car.toStringifyRaceResult()).isEqualTo("Dan : -----");
        assertThat(car.toStringifyRaceResult()).isNotEqualTo("Dan : ------");
        assertThat(car.toStringifyRaceResult()).isNotEqualTo("dan : -----");
    }
}
