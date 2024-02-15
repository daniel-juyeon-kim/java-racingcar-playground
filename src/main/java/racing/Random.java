package racing;

import java.util.ArrayList;
import java.util.List;

public class Random {
    private int createRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public List<Integer> createRandomNumbers(int times) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int count = 0; count < times; count++) {
            randomNumbers.add(createRandomNumber());
        }

        return randomNumbers;
    }
}
