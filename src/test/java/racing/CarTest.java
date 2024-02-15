package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void carGoTest() {
        Car car = new Car("d");
        car.go();
        int distance = car.getDistance();
        assertThat(distance).isEqualTo(1);
    }

    @Test
    void CarNameTest() {
        Car car = new Car("jod");
        String carName = car.getName();
        assertThat(carName).isEqualTo("jod");
    }
}
