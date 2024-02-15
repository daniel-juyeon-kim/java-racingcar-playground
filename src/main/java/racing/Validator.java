package racing;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {

    private boolean isValidCarName (String name) {
        return name != null && !name.isEmpty() && name.length() <= 5;
    }

    public boolean isValidCarNames (String [] carNames) {
        boolean result = Arrays.stream(carNames)
                .map(carName -> isValidCarName(carName))
                .collect(Collectors.toList())
                .contains(false);

        return result ? false : true;
    }

    public void isValidRaceCount(String count) {
        int number = isNumber(count);
        isOverZero(number);
    }

    private void isOverZero(int number) {
        if (number <= 0) {
            throw new NumberFormatException("1 이상의 수를 입력해 주세요");
        }
    }

    private int isNumber(String count) {
        try{
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해 주세요.");
        }
    }

}
