package racing;

import java.util.Scanner;

public abstract class InputView {
    protected Scanner in = new Scanner(System.in);
    abstract public String show();
}
