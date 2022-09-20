package ver01;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {

		Contact c1 = new Contact();
		
				
	Scanner in = new Scanner(System.in);
	System.out.print("이름 입력 : ");
	c1.setName(in.nextLine());
	
	System.out.print("전화번호 입력 : ");
	c1.setPhoneNumber(in.nextLine());
	
	System.out.print("이메일 입력 : ");
	c1.setEmail(in.nextLine());
	
	System.out.print("주소 입력 : ");
	c1.setAddress(in.nextLine());
	
	System.out.print("생일 입력 : ");
	c1.setBirthday(in.nextInt());
	
	System.out.print("그룹 입력 : ");
	c1.setGroup(in.nextLine());
	
	System.out.println("--------------");
	c1.showInfo();
	}

}
