package racing;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void go() {
        distance = distance + 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
