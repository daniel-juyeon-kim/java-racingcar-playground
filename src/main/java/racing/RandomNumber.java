package racing;

public class RandomNumber {
    private final int number;

    public RandomNumber() {
        this.number = create();
    }

    public RandomNumber(int randomNumber) {
        this.number = randomNumber;
    }

    public boolean isLessOrEqual(RandomNumber randomNumber) {
        return number <= randomNumber.number;
    }

    public boolean isOverOrEqual(RandomNumber randomNumber) {
        return randomNumber.number <= this.number;
    }

    private int create() {
        return (int) (Math.random() * 10);
    }

}
