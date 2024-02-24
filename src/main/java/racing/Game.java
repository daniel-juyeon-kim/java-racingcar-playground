package racing;

public class Game {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public void start() {
        try {
            Names names = inputView.inputNames();
            RaceCount raceCount = inputView.inputRaceCount();

            Cars cars = new Cars(names);

            startRaces(cars, raceCount);
            Cars winners = cars.findWinners();

            outputView.showWinners(winners);
        } catch (NumberFormatException e) {
            outputView.showErrorMessage(e.getMessage());
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
        }
    }

    private void startRaces(Cars cars, RaceCount raceCount) {
        outputView.showExecuteTitle();
        for (int count = 0; count < raceCount.getCount(); count++) {
            RandomNumbers randomNumbers = new RandomNumbers(cars.size());
            race(cars, randomNumbers);
            outputView.showRaceResult(cars);
        }
    }

    public void race(Cars cars, RandomNumbers randomNumbers) {
        cars.go(randomNumbers);
    }

}
