import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Divider {
    public String [] separate(String expression) {
        return expression.split("[,:]");
    }

    public String [] separateByCustomSeparator(String expression) {
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(expression);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return new String [] {};
    }
}
