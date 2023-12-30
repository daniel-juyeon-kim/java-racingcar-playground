import java.util.Arrays;

public class TypeTransformer {
    public int[] toIntArray(String[] argument) {
        return Arrays.stream(argument)
                .mapToInt((element) -> Integer.parseInt(element))
                .toArray();
    }
}
