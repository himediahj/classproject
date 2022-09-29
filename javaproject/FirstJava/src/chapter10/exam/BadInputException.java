package chapter10.exam;

public class BadInputException extends Exception {

	BadInputException(){
		super("ID는 영문과 숫자로만 이루어져야 합니다");
	}
}
