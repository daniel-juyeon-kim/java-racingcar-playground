package racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {

    @Test
    void raceTest() {

        Game game = new Game();

        Cars cars = new Cars(new Names(Arrays.asList(new Name("Dan"), new Name("Co"))));
        RandomNumbers randomNumbers = new RandomNumbers(Arrays.asList(new RandomNumber(3), new RandomNumber(4)));

        game.race(cars, randomNumbers);

        assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car(new Name("Dan"), 0), new Car(new Name("Co"), 1))));
        assertThat(cars).isNotEqualTo(new Cars(Arrays.asList(new Car(new Name("Dan"), 0), new Car(new Name("Co"), 3))));

    }
}
