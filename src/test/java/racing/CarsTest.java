package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @Test
    void carsTest() {
        Cars cars = new Cars(
            new Names(
                Arrays.asList(new Name("Dan"), new Name("io"), new Name("js"))
            )
        );

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.size()).isNotEqualTo(2);
        assertThat(cars.size()).isNotEqualTo(4);
    }

    @Test
    void findMaxDistanceTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("Dan"), 3),
                new Car(new Name("io"), 9),
                new Car(new Name("js"), 1)
        ));

        assertThat(cars.findMaxDistance()).isEqualTo(new Distance(9));
        assertThat(cars.findMaxDistance()).isNotEqualTo(new Distance(8));
    }

    @Test
    void findWinnersTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("Dan"), 3),
                new Car(new Name("io"), 9),
                new Car(new Name("js"), 9)
        ));

        assertThat(cars.findWinners()).isEqualTo(new Cars(Arrays.asList(new Car(new Name("io"), 9),
                new Car(new Name("js"), 9))));
        assertThat(cars.findWinners()).isNotEqualTo(new Cars(Arrays.asList(new Car(new Name("Dan"), 3),
                new Car(new Name("js"), 9))));
    }

    @Test
    void toStringifyWinnersNames() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("io"), 9),
                new Car(new Name("js"), 9)
        ));

        assertThat(cars.toStringifyWinnersNames()).isEqualTo("io,js가 최종 우승했습니다.");
    }

    @Test
    void toStringifyRaceResultTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("Dan"), 3),
                new Car(new Name("io"), 4),
                new Car(new Name("js"), 9)
        ));
        assertThat(cars.toStringifyRaceResult()).isEqualTo("Dan : ---\n" +
                "io : ----\n" +
                "js : ---------");
    }

    @Test
    void goTest() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("Dan"), 3),
                new Car(new Name("io"), 4),
                new Car(new Name("js"), 9)
        ));

        RandomNumbers randomNumbers = new RandomNumbers(Arrays.asList(
                new RandomNumber(3),
                new RandomNumber(4),
                new RandomNumber(5)
        ));

        cars.go(randomNumbers);

        assertThat(cars).isEqualTo(new Cars(Arrays.asList(
                new Car(new Name("Dan"), 3),
                new Car(new Name("io"), 5),
                new Car(new Name("js"), 10)
        )));

    }
}
