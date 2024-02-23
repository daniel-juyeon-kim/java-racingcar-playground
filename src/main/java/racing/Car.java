package racing;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    public Car(Name name, int distance) {
        this.name = name;
        this.distance = new Distance(distance);
    }

    public void go(RandomNumber randomNumber) {
        if (isOverFour(randomNumber)) {
            this.distance.plus();
        }
    }

    public boolean isSameDistance (Car car) {
        return this.distance.equals(car.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Name getName() {
        return name;
    }

    public String toStringifyRaceResult() {
        return name.getName() + " : " + distance.changeToStringByDash();
    }

    private boolean isOverFour(RandomNumber randomNumber) {
        return randomNumber.isOverOrEqual(new RandomNumber(4));
    }

}
