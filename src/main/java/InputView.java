import java.util.Scanner;

public class InputView {
    private final Scanner in = new Scanner(System.in);

    public String show () {
        this.showMessage();
        return  this.getExpression();
    }
    private void showMessage() {
        String inputMessage = "수식 입력: ";
        System.out.print(inputMessage);
    }

    private String getExpression() {
        return in.nextLine();
    }

}
