package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private InputView inputCarNamesView = new InputCarNameView();
    private InputView inputRaceCountView = new InputRaceCountView();
    private Validator validator = new Validator();
    private Spliter spliter = new Spliter();
    private Random random = new Random();
    private OutputView outputView = new OutputView();
    private Judge judge = new Judge();

    public void start() {
        String [] carNames = inputCarNames();
        if (checkInputCarNames(carNames) == false) {
            return;
        }

        String stringRaceCount = inputRaceCountView.show();

        if (checkValidRaceCount(stringRaceCount) == false) {
            return;
        }
        int raceCount = Integer.parseInt(stringRaceCount);
        List<Car> cars = generateCars(carNames);
        race(raceCount, cars);
    }

    private void race(int raceCount, List<Car> cars) {
        outputView.showResultTitle();
        Race singleRace = new Race(judge);
        for (int count = 0; count < raceCount; count++) {
            List<Integer> randomNumbers = random.createRandomNumbers(cars.size());
            singleRace.start(cars, randomNumbers);
            outputView.showRaceResult(cars);
        }

        List<Car> winners = judge.judgeWinners(cars);
        outputView.showWinners(winners);
    }

    private List<Car> generateCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    private boolean checkValidRaceCount(String stringRaceCount) {
        try {
            validator.isValidRaceCount(stringRaceCount);
            return true;
        } catch (NumberFormatException e) {
            outputView.showError(e.getMessage());
            return false;
        }
    }


    private String[] inputCarNames () {
        String stringCarNames = inputCarNamesView.show();
        return spliter.split(stringCarNames);
    }

    private boolean checkInputCarNames (String[] carNames) {
        if (validator.isValidCarNames(carNames) == false) {
            outputView.showError("조건에 맞는 자동차 이름을 입력해 주세요");
            return false;
        }
        return true;
    }


}
