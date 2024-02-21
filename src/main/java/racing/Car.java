package racing;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance();
    }

    public void go() {
        this.distance.plus();
    }

    public boolean isSameDistance (Car car) {
        return this.distance.equals(car.distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
