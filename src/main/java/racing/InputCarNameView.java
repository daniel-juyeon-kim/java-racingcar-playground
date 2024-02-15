package racing;

import java.util.List;

public class InputCarNameView extends InputView {

    private Spliter spliter = new Spliter();
    @Override
    public String show() {
        showMessage();
        String carNames = input();
        return carNames;
    }

    private void showMessage() {
        String message = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        System.out.println(message);
    }

    private String input() {
        return in.nextLine();
    }

}
