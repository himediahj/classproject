package chapter02;

public class Member {

	public static void main(String[] args) {
		//class 파일의 실행 포인트
		printMyname("손흥민");
		
		
		String name = "손흥민";
		int age = 20;
		double height = 181.2;
		boolean hasBook = false;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(hasBook);
		
			}

	// 자기 자신의 이름을 출력하는 메소드
	// 반환타입 : 없다 => void
	// 매개변수 : 없다
	// 처리내용 : 자신의 이름을 출력한다

	
	public static void printMyname(String name) {
		
		System.out.println("안녕하세요! " + name + " 입니다.");
		
		// 반환이 있다면 return 사용
	}
}
