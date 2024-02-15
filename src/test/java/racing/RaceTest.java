package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private static List<Car> expectCars = Arrays.asList(new Car("a"), new Car("b"), new Car("c"), new Car("d"));

    @BeforeAll
    static void beforeAll() {
        expectCars.get(2).go();
        expectCars.get(3).go();
    }

    @Test
    void start() {
        List<Integer> randomNumbers = Arrays.asList(0,3,4,5);
        List<Car> cars = Arrays.asList(new Car("a"), new Car("b"), new Car("c"), new Car("d"));

        new Race(new Judge()).start(cars, randomNumbers);

        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.get(index);
            Car expectCar = expectCars.get(index);

            assertThat(car.getName()).isEqualTo(expectCar.getName());
            assertThat(car.getDistance()).isEqualTo(expectCar.getDistance());
        }
    }
}
