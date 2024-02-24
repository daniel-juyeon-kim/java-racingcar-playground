package racing;

import java.util.Objects;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }

    public Distance(int distance) {
        isValid(distance);
        this.distance = distance;
    }

    public boolean isOverOrEquals(Distance distance) {
        return this.distance >= distance.distance;
    }

    public void plus() {
        this.distance = this.distance + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return this.distance == distance.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    public String changeToStringByDash() {
        StringBuilder sb = new StringBuilder();

        for(int count = 0; count < this.distance; count++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private void isValid (int distance) {
        if (isOverZero(distance) == false) {
            throw new IllegalArgumentException("0 이상의 숫자만 가능합니다.");
        }
    }

    private boolean isOverZero(int distance) {
        return 0 <= distance;
    }

}
