package racing;

public class OutputView {
    public void showWinners(Cars winners) {
        System.out.println(winners.toStringifyWinnersNames());
    }

    public void showRaceResult(Cars cars) {
        System.out.println(cars.toStringifyRaceResult());
        showBlankLine();
    }

    public void showErrorMessage(String message) {
        System.out.println(message);
    }

    private void showBlankLine() {
        System.out.println();
    }

    public void showExecuteTitle() {
        showBlankLine();
        System.out.println("실행 결과");
    }

}
