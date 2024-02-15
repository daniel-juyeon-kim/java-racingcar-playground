package racing;


public class InputRaceCountView extends InputView{

    @Override
    public String show() {
        showMessage();
        String count = input();
        return count;
    }

    private void showMessage () {
        String message = "시도할 회수는 몇회인가요?";
        System.out.println(message);
    }

    private String input () {
        return in.nextLine();
    }
}