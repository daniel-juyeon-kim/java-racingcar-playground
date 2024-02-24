package racing;

import java.util.Objects;

public class RaceCount {
    private final int count;

    public RaceCount(int count) {
        this.count = count;
    }

    public RaceCount(String raceCount) {
        isValid(raceCount);
        this.count = Integer.parseInt(raceCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceCount raceCount = (RaceCount) o;
        return count == raceCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public int getCount() {
        return count;
    }

    private void isValid(String stringRaceCount) {
        checkNumber(stringRaceCount);
        int raceCount = Integer.parseInt(stringRaceCount);
        checkOverZero(raceCount);
    }

    private void checkNumber(String raceCount) {
        try {
            Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("레이싱 횟수가 숫자가 아닙니다.");
        }
    }

    private void checkOverZero(int raceCount) {
        if (isOverZero(raceCount) == false) {
            throw new NumberFormatException("레이싱 횟수는 1 이상이여야 합니다.");
        }
    }

    private boolean isOverZero(int raceCount) {
        return 0 < raceCount;
    }

}
