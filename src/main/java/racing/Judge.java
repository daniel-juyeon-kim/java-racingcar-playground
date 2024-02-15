package racing;

import java.util.*;

public class Judge {

    private boolean judgeCarGo(int random) {
        return 4 <= random;
    }
    public List<Boolean> judgeRaceResult(List<Integer> randomNumbers) {

        List<Boolean> result = new ArrayList<>();

        for (int index = 0; index < randomNumbers.size(); index++) {
            result.add(judgeCarGo(randomNumbers.get(index)));
        }

        return result;
    }

    public List<Car> judgeWinners(List<Car> racedCars) {
        int maxDistance = findMaxDistance(racedCars);
        return findWinners(maxDistance, racedCars);
    }

    private int findMaxDistance (List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getDistance))
                .get()
                .getDistance();
    }

    private List<Car> findWinners (int maxDistance, List<Car> racedCars) {
        List<Car> winCars = new ArrayList<>();

        for (Car racedCar : racedCars) {
            addWinnerCar(maxDistance, racedCar, winCars);
        }

        return winCars;
    }

    private void addWinnerCar (int maxDistance, Car racedCar, List<Car> winCars) {
        if (maxDistance == racedCar.getDistance()) {
            winCars.add(racedCar);
        }
    }
}
