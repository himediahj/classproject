package chapter07.exam;

import java.time.LocalDate;
import java.util.Calendar;

public class Person {

	String name;
	String personNumber;
	
	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}
	
		
	// 나이를 반환하는 메소드, 주민번호는 멤버변수인 personNumber 값을 이용해서 처리 
	int getAge() {
		// 반환하는 나이
		int result = 0;
		
		// 나이를 계산해서 반환하는 연산
		// 001212-1111111
		// 990203-2222222
		// 태어난 년도 2자리
		String tempyear = personNumber.substring(0, 2);	//"00", "99"
		String tempGender = personNumber.substring(7, 8);	// 뒷자리 1 2 3 4 중 하나
		
		// 891111-2000000
		// 010203-3000000
		// 1 || 2 => 1900 + 89
		// 3 || 4 => 2000 + 01
		
		// Integer.parseInt("문자열"); -> int 정수 반환
		
		// 나이 구하기 : 올해 년도 - 태어난 년도
		// int curYear = Calendar.getInstance().get(Calendar.YEAR);
		// Date -> LocalDate, LocalDatetime, LocalTime
		int curYear = LocalDate.now().getYear(); 
		
		int birthYear = Integer.parseInt(tempyear);
		int genderVal = Integer.parseInt(tempGender);
		
		if(genderVal == 1 || genderVal == 2) {
			result = curYear - (1900 + birthYear);
		} else if(genderVal == 3 || genderVal == 4) {
			result = curYear - (2000 + birthYear);
		}
		
		return result;
	}
	
	
	
	void printInfo() {
		System.out.printf("안녕하세요. 저는 %s입니다. %d살 입니다.", this.name, getAge());
	} 
	
	
	// 연도 테스트
	public static void main(String[] args) {
		LocalDate curDate = LocalDate.now();
		System.out.println(curDate);
		System.out.println(curDate.getYear());
		
		int curYear = LocalDate.now().getYear();	// 올해 년도
		
		Person p = new Person("son", "001111-3000000");
		p.printInfo();
		
		
	}
	
	
	
	
}
