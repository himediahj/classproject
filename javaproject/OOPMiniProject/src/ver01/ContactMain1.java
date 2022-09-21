package ver01;

import java.util.Scanner;

public class ContactMain1 {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);

		// contact 인스턴스 생성 : 생성자를 이용한 데이터 초기화
//		Contact1 c1 = new Contact1("손흥민", "010-9999-8888", "son@gmail.com", "런던", "1999-10-12", "친구");
//		System.out.println("이름 : " + c1.getName());
//		System.out.println("전화번호 : " + c1.getPhoneNumber());
//		System.out.println("이메일 : " + c1.getEmail());
//		System.out.println("주소 : " + c1.getAddress());
//		System.out.println("생일 : " + c1.getBirthday());
//		System.out.println("그룹 : " + c1.getGroup());
//		
//		System.out.println();
//		c1.printInfo();
//		
//		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터 수정합니다.
//		c1.setName("박지성");
//		c1.setPhoneNumber("010-3333-5555");
//		System.out.println();
//		c1.printInfo();
		
		
		//////////////////////////////////////
		while(true) {
			System.out.println();
			System.out.println();
			
			System.out.println("1. 입력 시작 | 0. 종료");
			String select = in.nextLine();
			
			// 사용자 요청에 따라 프로그램 ( 종료 / 진행 )분기 처리
			if(select.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(!select.equals("1")) {
				System.out.println("올바른 요청이 아닙니다.");
				continue;
			}
			
			System.out.println("데이터 입력을 시작합니다.");
			
			System.out.print("이름 >>> ");
			String name = in.nextLine();
			System.out.print("전화번호 >>> ");
			String phoneNumber = in.nextLine();
			System.out.print("이메일 >>> ");
			String email = in.nextLine();
			System.out.print("주소 >>> ");
			String address = in.nextLine();
			System.out.print("생일 >>> ");
			String birthday = in.nextLine();
			System.out.print("그룹 >>> ");
			String group = in.nextLine();
			
			Contact1 c = new Contact1(name, phoneNumber, email, address, birthday, group);
			
			c.printInfo();
		}
		
		
		
	}

}
