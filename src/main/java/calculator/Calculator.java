import java.util.Arrays;

public class Calculator {
    public int addAll(int [] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
