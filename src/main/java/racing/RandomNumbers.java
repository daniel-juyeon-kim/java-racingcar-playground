package racing;

import java.util.LinkedList;
import java.util.List;

public class RandomNumbers {
    private final List<RandomNumber> randomNumbers;

    public RandomNumbers(int carAmount) {
        this.randomNumbers = createRandomNumbers(carAmount);
    }

    public RandomNumbers(List<RandomNumber> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public RandomNumber getRandomNumber(int index) {
        return randomNumbers.get(index);
    }

    private List<RandomNumber> createRandomNumbers(int amount) {
        LinkedList<RandomNumber> randomNumbers = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            randomNumbers.add(new RandomNumber());
        }
        return randomNumbers;
    }
}
