import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void isIntegers(String [] integers) {
        for (String integer : integers) {
            this.isInteger(integer);
        }
    }

    public void isPositiveIntegers(int [] integers) {
        for (int integer : integers) {
            this.isPositiveInteger(integer);
        }
    }

    private void isInteger(String integer) {
        try {
            Integer.parseInt(integer);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private void isPositiveInteger(int integer) {
        if(integer < 0) {
            throw new RuntimeException("음수가 있습니다.");
        }
    }

    public boolean isValidCustomSeparatorTemplate(String expression) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(expression);
        return matcher.find();
    }
}
