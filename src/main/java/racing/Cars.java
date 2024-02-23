package racing;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> cars;

    public Cars(Names names) {
        this.cars = createCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public Distance findMaxDistance() {
        Distance maxDistance = new Distance();
        for (Car car : this.cars) {
            if (isCarDistanceOverOrEquals(car, maxDistance)) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    public Cars findWinners() {
        List<Car> cars = new LinkedList<>();
        Distance maxDistance = findMaxDistance();
        for (Car car : this.cars) {
            if (car.getDistance().equals(maxDistance)) {
                cars.add(car);
            }
        }
        return new Cars(cars);
    }

    public String toStringifyWinnersNames() {
        Names names = new Names(getNames());
        return names.toStringify() + "가 최종 우승했습니다.";
    }

    public String toStringifyRaceResult() {
        List<String> raceResults = new LinkedList<>();
        for (Car car : cars) {
            raceResults.add(car.toStringifyRaceResult());
        }
        return String.join("\n", raceResults);
    }

    public void go(RandomNumbers randomNumbers) {
        for (int index = 0; index < cars.size(); index++) {
            Car car = cars.get(index);
            RandomNumber randomNumber = randomNumbers.getRandomNumber(index);
            car.go(randomNumber);
        }
    }

    private List<Car> createCars(Names names) {
        List<Name> nameList = names.getNames();
        LinkedList<Car> cars = new LinkedList<>();

        for (Name name : nameList) {
            cars.add(new Car(name));
        }

        return cars;
    }

    private boolean isCarDistanceOverOrEquals(Car car, Distance maxDistance) {
        return car.getDistance().isOverOrEquals(maxDistance);
    }

    private List<Name> getNames() {
        List<Name> names = new LinkedList<>();
        for (Car car : cars) {
             names.add(car.getName());
        }
        return names;
    }
}
