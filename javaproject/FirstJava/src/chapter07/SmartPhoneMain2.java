package chapter07;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		AndroidPhone androidPhone = new AndroidPhone("010-0000-0000");
		Iphone iphone = new Iphone("010-1111-1111");
		GooglePhone googlePhone = new GooglePhone("010-2222-2222");
		
		callByPhone(androidPhone);
		callByPhone(iphone);
		callByPhone(googlePhone);
		
		
	}
	
	static void callByPhone(Phone phone) {
		// 메소드의 매개변수
		// Phone phone = androidPhone;
		phone.call();
	}
	
	
	// 안드로이드 폰
//	static void callByPhone(AndroidPhone phone) {
//		phone.call();
//		
//	}
//	
//	// 아이폰
//	static void callByPhone(Iphone phone) {
//		phone.call();
//		
//	}
//	
//	static void callByPhone(GooglePhone phone) {}
//		phone.call();
	
}
