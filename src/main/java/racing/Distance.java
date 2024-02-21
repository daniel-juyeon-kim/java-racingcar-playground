package racing;

import java.util.Objects;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }
    public Distance(int distance) {
        if (isValid(distance) == false) {
            throw new IllegalArgumentException("0 이상의 숫자만 가능합니다.");
        }
        this.distance = distance;
    }

    private boolean isValid (int distance) {
        return 0 <= distance;
    }

    public void plus() {
        this.distance = this.distance + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
