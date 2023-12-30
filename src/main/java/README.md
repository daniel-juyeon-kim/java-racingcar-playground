# TODO

## 기능 요구사항

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)

앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 
커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 구현 목록

- [x] 입력 화면
- [x] 쉼표, 콜론으로 구분
- [x] 커스텀 구분자 지정
- [x] 계산
- [x] 음수, 숫자 이외의 값 예외처리
- [x] 결과 출력

## 구현 클래스

- [x] 입력 화면(inputView)
  - [x] 화면 출력 및 입력(show)
    - [x] 입력 메세지 출력(showMessage)
    - [x] 입력 받음(inputExpression)
- [x] 구분(Divider)
  - [x] 커스텀 구분자 설정(setCustomSeparator)
  - [x] 구분(separator) => 문자열 배열 반환
- [x] 타입 변환(TypeTransfomer)
  - [x] toIntArray
- [x] 계산(Calculator)
  - [x] 전부합산(addAll)
- [x] 검증(Validator)
  - [x] 커스텀 구분자를 사용하는지 확인(hasCustomSeparator)
  - [x] 양수인가(isPositiveInteger)
  - [x] 숫자 이외의 값(isInteger)
- [x] 결과 출력(ResultView)
  - [x] 결과 출력(showResult)
  - [x] 에러 출력(showException)