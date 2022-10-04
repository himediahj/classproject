package ver04ver;

import java.util.Scanner;

public class SmartPhone {

	private Contact[] contact;
	private int numOfContact;
	Scanner sc;

	private SmartPhone() {
		contact = new Contact[10];
		numOfContact = 0;
		sc = new Scanner(System.in);
	}

	private static SmartPhone sp = new SmartPhone();

	public static SmartPhone getInstance() {
		if (sp == null) {
			sp = new SmartPhone();
		}
		return sp;
	}

	void storeContact() {

		System.out.println("입력하고자 하는 친구 타입을 선택해주세요");
		System.out.println("1. 회사 동료 \t2. 거래처");
		int select = Integer.parseInt(sc.nextLine());
		
		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birth = null;
		String group = null;		
		
		System.out.print("이름을 입력하세요 > ");
		name = sc.nextLine();
		System.out.print("전화번호를 입력하세요 > ");
		phoneNumber = sc.nextLine();
		System.out.print("이메일을 입력하세요 > ");
		email = sc.nextLine();
		System.out.print("주소를 입력하세요 > ");
		address = sc.nextLine();
		System.out.print("생일을 입력하세요 > ");
		birth = sc.nextLine();
		System.out.print("그룹을 입력하세요 > ");
		group = sc.nextLine();

		Contact contacts = null;
		// Contact contacts = new Contact(name, phoneNumber, email, address, birth, group);	추상클래스니까 인터페이스 생성 불가
		
		if(select==1) {
			System.out.print("회사이름을 입력하세요 > ");
			String company = sc.nextLine();
			System.out.print("부서이름을 입력하세요 > ");
			String department = sc.nextLine();
			System.out.print("직급을 입력하세요 > ");
			String position = sc.nextLine();
			
			contacts = new CompanyContact(name, phoneNumber, email, address, birth, group, company, department, position);
		
		} else {
			System.out.println("거래처회사이름을 입력하세요 > ");
			String company = sc.nextLine();
			System.out.println("거래품목을 입력하세요 > ");
			String product = sc.nextLine();
			System.out.println("직급을 입력하세요 > ");
			String position = sc.nextLine();
			
			contacts = new CustomerContact(name, phoneNumber, email, address, birth, group, company, product, position);
		}
		
		contact[numOfContact++] = contacts;
	}

	void editContact() {

		String name = null;
		System.out.print("수정하려는 이름을 입력해주세요");
		name = sc.nextLine();

		int searchIndex = -1;
		for (int i = 0; i < numOfContact; i++) {
			if (contact[i].equals(name)) {
				searchIndex = i;
				break;
			}
		}

		if (searchIndex < 0) {
			System.out.println("수정하고자 하는 이름이 존재하지 않습니다");
			return;
		}

		Contact contacts = contact[searchIndex];

		System.out.println("데이터 수정을 진행합니다");
		System.out.print("새로운 이름을 입력해주세요. 현재값 : " + contacts.getName());
		String newName = sc.nextLine();

		if (newName != null && newName.trim().length() > 0)
			contacts.setName(newName);

		System.out.print("새로운 전화번호를 입력해주세요. 현재값 : " + contacts.getPhoneNumber());
		String newPhoneName = sc.nextLine();

		if (newPhoneName != null && newPhoneName.trim().length() > 0)
			contacts.setPhoneNumber(newPhoneName);

		System.out.print("새로운 이메일을 입력해주세요. 현재값 : " + contacts.getEmail());
		String newEmail = sc.nextLine();

		if (newEmail != null && newEmail.trim().length() > 0)
			contacts.setEmail(newEmail);

		System.out.print("새로운 주소를 입력해주세요. 현재값 : " + contacts.getAddress());
		String newAddress = sc.nextLine();

		if (newAddress != null && newAddress.trim().length() > 0)
			contacts.setAddress(newAddress);

		System.out.print("새로운 생일을 입력해주세요. 현재값 : " + contacts.getBirth());
		String newBirth = sc.nextLine();

		if (newBirth != null && newBirth.trim().length() > 0)
			contacts.setBirth(newBirth);

		System.out.print("새로운 그룹을 입력해주세요. 현재값 : " + contacts.getGroup());
		String newGroup = sc.nextLine();

		if (newGroup != null && newGroup.trim().length() > 0)
			contacts.setGroup(newGroup);

		System.out.println("정보가 수정되었습니다.");

	}

	void deleteContact() {
		System.out.print("삭제하려는 이름을 입력해주세요");
		String name = sc.nextLine();
		
		int searchIndex = -1;
		for(int i=0; i<numOfContact; i++) {
			if(contact[i].equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		if(searchIndex<0) {
			System.out.println("삭제하고자 하는 이름이 존재하지 않습니다");
		} else {
			for(int i=searchIndex; i<numOfContact-1; i++) {
				contact[i] = contact[i+1];
				}
			numOfContact--;
			System.out.println("데이터가 삭제되었습니다");
		}
		
	}
	
	void printAllData() {
		System.out.println("전체 데이터를 출력합니다");
		if(numOfContact ==0) {
			System.out.println("저장된 정보가 없습니다");
			return;
		}
		for(int i=0; i<numOfContact; i++)
			contact[i].printAll();
	}
	
	void searchData() {
		String name = null;
		System.out.print("검색할 이름을 입력하세요 > ");
		name = sc.nextLine();
		
		Contact contacts = null;
		for(int i=0; i<numOfContact; i++) {
			if(contact[i].equals(name)) {
				contacts = contact[i];
				break;
			}
		}
		
		if(contacts == null) {
			System.out.println("검색한 이름 " + name + " 의 정보가 없습니다");
		} else {
			contacts.printAll();
		}
		
	}

}
