package racing;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    //    우승자 발표
    public void showWinners(List<Car> cars) {
        String resultString = generateWinCarsToString(cars);
        System.out.println(resultString + "가 최종 우승했습니다.");
    }

    private String generateWinCarsToString(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());

        return String.join( ",", carNames);
    }

    public void showResultTitle () {
        printEmptyLine();
        System.out.println("실행 결과");
    }

    //    레이스 결과 출력

    public void showRaceResult(List<Car> cars) {
        for (Car car : cars) {
            printSingleRace(car);
        }
        printEmptyLine();
    }

    private void printSingleRace(Car car) {

        StringBuilder distance = new StringBuilder();
        for (int count = 0; count < car.getDistance(); count++) {
            distance.append("-");
        }

        System.out.println(car.getName() + " : " + distance);
    }

    //    입력 오류 출력
    public void showError(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
