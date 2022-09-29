package chapter10.exam;

import java.util.regex.Pattern;

public class Exam1Main {

	public static void main(String[] args) {
		// 1. 콘솔에서 사용자 아이디 입력받아 정상적인 영문자와 숫자로만 이루어진 값 입력했는지 확인
		// 사용자 예외 클래스 정의해서 예외 발생 시켜보고
		// 예외 클래스 이름은 BadInputException

		String str = "abc!";
		boolean chk1 = Pattern.matches("^[a-z0-9A-Z]*$", str); // ^; 패턴 시작 $; 패턴 종료 *; 0개나 하나 이상의 문자가 있는 것을 의미

		// 한글만 -> ^[가-힣]*$
		// 이메일 : ^[a-zA-Z0-9]+@+[a-zA-Z0-9]\.+[a-zA-Z]+$ qqq@naver.com
		// 핸드폰 전화번호 : ^\\d{2,3}-\\d{4}-\\d{4} \d 숫자형식의 문자가 2~3개 들어온다
		// ? : 물음표 앞의 문자가 하나 이거나 없거나
		// \w : 알파벳 + 숫자

		try {
			if (!chk1) {	// false 나올 때
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("소문자, 대문자, 숫자 입력만 가능합니다");
		}

	}

}
