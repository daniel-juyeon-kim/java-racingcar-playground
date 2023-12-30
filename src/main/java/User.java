import java.util.Arrays;

public class User {
    private final InputView inputView = new InputView();
    private final Validator validator = new Validator();
    private final Divider divider = new Divider();
    private final ResultView resultView = new ResultView();
    private final TypeTransformer typeTransformer = new TypeTransformer();
    private final Calculator calculator = new Calculator();
    public void startCalculate() {
        String userExpression = inputView.show();
        if (validator.isValidCustomSeparatorTemplate(userExpression)) {
            String [] splitedExpression = divider.separateByCustomSeparator(userExpression);
            calculate(splitedExpression);
            return;
        }
        String [] splitedExpression = divider.separate(userExpression);
        calculate(splitedExpression);
    }

    private void calculate(String [] splitedExpression) {
        try {
            validator.isIntegers(splitedExpression);
            int [] parsedExpression = typeTransformer.toIntArray(splitedExpression);
            validator.isPositiveIntegers(parsedExpression);
            int result = calculator.addAll(parsedExpression);
            resultView.showResult(result);
        } catch (RuntimeException e) {
            resultView.showException(e.getMessage());
        }
    }

}
