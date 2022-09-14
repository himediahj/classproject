import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		//class 파일의 실행 포인트
		printMyname("손흥민");
		
		
		Scanner in = new Scanner(System.in);
		
			
		
		// String name = null;
		int age = 0;
		String nickName = null;
		double height = 0.0;
		boolean hasBook = false;
		
		System.out.print("이름을 입력해주세요.>>> ");
		String name = in.nextLine();
		
		System.out.print("나이를 입력해주세요.>>> ");
		age = in.nextInt();
		
		
		// 스캐너 안에서 숫자 타입은 숫자 에서 끝나고 뒤에 공백을 못읽으니까 읽게끔 하려고 밑에 줄 추가 
		// 추가 안하면 별명 입력하지도 않았는데 끝남
		in.nextLine();
		
		System.out.print("별명을 입력해주세요.>>> ");
		nickName = in.nextLine();
		
		System.out.print("키 정보를 입력해주세요.>>> ");
		height = in.nextDouble();
		
		System.out.print("책 보유여부를 입력해주세요.>>> ");
		hasBook = in.nextBoolean();
		
		
		
		/*
		 * name = "서혜정"; age = 32; height = 168.5; hasBook = true;
		 */
		
		System.out.println("저의 이름은 " + name + "입니다.");
		System.out.println("나이는 " + age + " 세 입니다.");
		System.out.println("별명은 " + nickName + " 입니다.");
		System.out.println("키는 " + height + "cm 입니다.");
		System.out.println("자바 책의 보유 여부 : " + hasBook);
		
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
