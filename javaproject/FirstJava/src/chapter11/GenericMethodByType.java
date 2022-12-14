package chapter11;

import chapter08.phone.Phone;
import chapter08.phone.PhoneImpl;

public class GenericMethodByType {

	public <T extends Phone> void hello(T t) {
		System.out.println("안녕하세요 " + t.toString() + "입니다");
	} 
	
	public static void main(String[] args) {
		GenericMethodByType byType = new GenericMethodByType();
		// byType.<String>hello("손흥민");
		// byType.hello(10);	// 앞에 타입 자동으로 설정됨 = 생략 가능
		byType.<PhoneImpl>hello(new PhoneImpl());
	}
}
