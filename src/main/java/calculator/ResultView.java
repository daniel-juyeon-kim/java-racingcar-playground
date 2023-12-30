public class ResultView {

    //  - [ ] 결과 출력(showResult)
    public void showResult(int sumResult) {
        String resultMessageTemplate = "합산 결과: ";
        System.out.println(resultMessageTemplate + sumResult);
    }
    //  - [ ] 에러 출력(showException)
    public void showException(String exceptionMessage) {
        String exceptionNessageTemplate = "에러: ";
        System.out.println(exceptionNessageTemplate + exceptionMessage);
    }
}
