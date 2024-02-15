package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {

    private Judge judge = new Judge();

    public static Stream<Arguments> provideForJudgeWinners() {

        List<Car> racedCars1 = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));

        racedCars1.get(0).go();
        racedCars1.get(1).go();
        racedCars1.get(1).go();
        racedCars1.get(1).go();
        racedCars1.get(2).go();
        racedCars1.get(2).go();
        racedCars1.get(2).go();

        List<Car> twoWinCars = Arrays.asList(new Car("b"), new Car("c"));
        twoWinCars.get(0).go();
        twoWinCars.get(0).go();
        twoWinCars.get(0).go();
        twoWinCars.get(1).go();
        twoWinCars.get(1).go();
        twoWinCars.get(1).go();

        List<Car> racedCars2 = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));

        racedCars2.get(0).go();
        racedCars2.get(1).go();
        racedCars2.get(1).go();
        racedCars2.get(1).go();
        racedCars2.get(2).go();
        racedCars2.get(2).go();

        List<Car> oneWinCars = Arrays.asList(new Car("b"));
        twoWinCars.get(0).go();
        twoWinCars.get(0).go();
        twoWinCars.get(0).go();

        return Stream.of(
                Arguments.of(racedCars1, twoWinCars),
                Arguments.of(racedCars2, oneWinCars)
        );

    }

    @Test
    void judgeRaceResultTest() {
        List<Integer> randomNumbers = Arrays.asList(0, 3, 4, 9);
        List<Boolean> expects = Arrays.asList(false,false,true,true);
        List<Boolean> result = judge.judgeRaceResult(randomNumbers);
        assertThat(result).isEqualTo(expects);
    }

    @ParameterizedTest
    @MethodSource("provideForJudgeWinners")
    void judgeWinners(List<Car> racedCars, List<Car> expectCars) {

        List<Car> filterdCars = judge.judgeWinners(racedCars);

        for (int index = 0; index < filterdCars.size(); index++) {
            Car filterdCar = filterdCars.get(index);
            Car expectCar = expectCars.get(index);

            assertThat(expectCar.getName()).isEqualTo(filterdCar.getName());
            assertThat(expectCar.getName()).isEqualTo(filterdCar.getName());
        }

    }
}
