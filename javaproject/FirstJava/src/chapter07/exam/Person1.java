package chapter07.exam;

import java.util.Calendar;

public class Person1 {

	String name;
	String personNumber;
	
	
	public Person1(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}


	int age() {
		int result = 0;
		
		// 001212-2222222
		String tempYear = personNumber.substring(0, 2);
		String genderVal = personNumber.substring(7, 8);
		
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		int birthYear = Integer.parseInt(tempYear);
		int gender = Integer.parseInt(genderVal);
		
		if(gender == 1 || gender ==2) {
			result = curYear - (1900 + birthYear) + 1;
		} else if(gender ==3 || gender == 4) {
			result = curYear - (2000 + birthYear) + 1;
		}
		
		return result;
	}

	void printhi() {
		System.out.printf("안녕하세요. 저는 %s입니다. %d살입니다.", this.name, age());
	}
}
