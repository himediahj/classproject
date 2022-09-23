package ver02;

import java.util.Scanner;

public class SmartPhone {
	// public으로 적었음...
	private Contact[] contacts;

	private int numOfContact;
	Scanner sc;

	private SmartPhone() {
		contacts = new Contact[10];
		numOfContact = 0;
		sc = new Scanner(System.in);
	}

	private static SmartPhone sp = new SmartPhone();

	public static SmartPhone getInstance() {
		if (sp == null)
			sp = new SmartPhone();
		return sp;
	}

	
	
	
	
	public void print() {
		for(int i=0; i<numOfContact; i++)
			contacts[i].print();
	}
	
	
	public void delete() {
		System.out.println("삭제할 이름을 찾습니다.");
		System.out.print("이름을 입력하세요. > ");
		String name = sc.nextLine();

		int searchIndex = -1;
		
		for(int i=0; i<numOfContact; i++) {
			if(contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름이 없습니다");
		} else {		
			for(int i = searchIndex; i<numOfContact-1; i++) {
			contacts[i] = contacts[i+1];
			}
			numOfContact--;
			System.out.println("데이터가 삭제되었습니다");
		}
		
		

	}

	public void modify() {
		System.out.println("수정할 이름을 찾습니다.");
		System.out.println("이름을 입력하세요. > ");
		String name = sc.nextLine();

		int searchIndex = -1;

		for (int i = 0; i < numOfContact; i++) {
			if (contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}

		if (searchIndex < 0) {
			System.out.println("찾으시는 이름이 없습니다");
		}

		Contact contact = contacts[searchIndex];

		System.out.print("수정하고자 하는 이름을 입력하세요");
		contact.setName(sc.nextLine());

		System.out.print("수정하고자 하는 전화번호를 입력하세요");
		contact.setPhoneNumber(sc.nextLine());

		System.out.print("수정하고자 하는 이메일을 입력하세요");
		contact.setEmail(sc.nextLine());

		System.out.print("수정하고자 하는 주소를 입력하세요");
		contact.setAddress(sc.nextLine());

		System.out.print("수정하고자 하는 생일을 입력하세요");
		contact.setBirthday(sc.nextLine());

		System.out.print("수정하고자 하는 그룹을 입력하세요");
		contact.setGroup(sc.nextLine());
		
		System.out.println();

	}

	public void insert() {
		System.out.println("정보를 입력합니다.");
		System.out.print("이름을 입력하세요. > ");
		String name = sc.nextLine();
		System.out.print("전화번호를 입력하세요. > ");
		String phoneNumber = sc.nextLine();
		System.out.print("이메일을 입력하세요. > ");
		String email = sc.nextLine();
		System.out.print("주소를 입력하세요. > ");
		String address = sc.nextLine();
		System.out.print("생일을 입력하세요. > ");
		String birthday = sc.nextLine();
		System.out.print("그룹을 입력하세요. > ");
		String group = sc.nextLine();

		Contact contact = new Contact(name, phoneNumber, email, address, birthday, group);
		contacts[numOfContact++] = contact;
	}

}
