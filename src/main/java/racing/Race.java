package racing;

import java.util.List;

public class Race {
    private Judge judge;

    public Race(Judge judge) {
        this.judge = judge;
    }

    public void start(List<Car> cars, List<Integer> randomNumbers) {
        List<Boolean> results = judge.judgeRaceResult(randomNumbers);
        for (int index = 0; index < cars.size(); index++) {
            startRaceSingleCar(results.get(index), cars.get(index));
        }
    }

    private void startRaceSingleCar (Boolean result, Car car) {
        if (result){
            car.go();
        }
    }

}
