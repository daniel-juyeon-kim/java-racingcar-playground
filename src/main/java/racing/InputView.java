package racing;

import java.util.Scanner;

public class InputView {

    private final String inputTryTimeMessage = "시도할 회수는 몇회인가요?";
    private final String inputCarNamesMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public Names inputNames() {
        showMessage(inputCarNamesMessage);
        String [] names = input().split(",");
        return new Names(names);
    }

    public RaceCount inputRaceCount() {
        showMessage(inputTryTimeMessage);
        String raceCount = input();
        return new RaceCount(raceCount);
    }

    private String input() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private void showMessage(String message) {
        System.out.println(message);
    }

}
