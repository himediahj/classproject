package ver07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhone1 {
	// 기능 클래스 : 속성을 가지지 않고 메소드들로만 정의된 클래스
	// 여러개의 인스턴스가 생성될 필요 없다! => 싱글톤 패턴
	// 1. private 생성자
	// 2. 클래스 내부에서 인스턴스를 생성 static private
	// 3. 내부에서 생성한 참조값을 반환해주는 메소드 static public

	// 요구사항
	// 이 클래스는 연락처 정보를 관리하는 클래스이다.
	// 1. Contact1 클래스의 인스턴스 10개를 저장 할 수 있는 배열 정의 ==> 10개 정보를 저장할 수 있다. ==> 배열 인스턴스
	// 생성. Contact1[]
	// Contact1 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장

	//private Contact1[] contacts; // null
	//private int numOfContact1; // 입력된 정보의 개수, 배열의 index 값으로 사용
	List<Contact1> contacts;
	Scanner sc;

	private SmartPhone1() { // 초기화에 필요한 데이터 받기 위해 매개변수 정의한 생성자
		//contacts = new Contact1[size]; // 인스턴스 변수들 초기화..
		//numOfContact1 = 0;
		contacts = new ArrayList<>();	//<>안에 Contact1 생략 가능
		sc = new Scanner(System.in);
	}

	// new SmartPhone1(100); 100개도 만들 수 있다!

	private static SmartPhone1 sp = new SmartPhone1(); // 인스턴스 생성 전 static으로 미리 만들어놓는 거! (메모리에 올라간다). 메모리에 올라가있어서 인스턴스
															// 생성 없이 바로 사용 가능

	public static SmartPhone1 getInstance() { // static으로 미리 만들어놓는다..
		if (sp == null)
			sp = new SmartPhone1();
		return sp;
	}

	// 2. 기능
	// 배열에 인스턴스 저장,
	// 수정,
	// 삭제,
	// 검색 후 결과 출력,
	// 저장된 데이터의 리스트를 출력하는 메소드 정의

	// 이름을 입력받고 배열에 해당 이름의 Contact 객체가 있는 index 반환
	private int getIndex1() { // 외부에서 알 필요 없는 메소드
		String name = sc.nextLine();

		// 이름 검색 하는 index 찾아야 한다
		int searchIndex1 = -1; // 현재 검색의 결과는 없다!

		// 데이터 찾기
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(name)) {
				searchIndex1 = i;
				break;
			}
		}
		return searchIndex1;
	}

	// 이름 검색 후 데이터 수정
	void editContact1() {
		System.out.println("데이터 수정이 진행됩니다.");
		System.out.print("수정하고자 하는 이름을 입력해주세요 > ");

		int searchIndex1 = getIndex1();

		if (searchIndex1 < 0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
			return;
		}
		Contact1 contact1 = contacts.get(searchIndex1);

		System.out.println("데이터 수정을 진행합니다.");
		System.out.println("변경하고자 하는 이름을 입력해주세요.(현재값 : " + contact1.getName() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
		String newName = sc.nextLine();

		// " abc " trim -> "abc"
		if (newName != null && newName.trim().length() > 0) {
			contact1.setName(newName);
		}

		System.out
				.println("변경하고자 하는 전화번호를 입력해주세요.(현재값 : " + contact1.getPhoneNumber() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
		String newPhoneNumber = sc.nextLine();
		if (newPhoneNumber != null && newPhoneNumber.trim().length() > 0) {
			contact1.setPhoneNumber(newPhoneNumber);
		}

		System.out.println("변경하고자 하는 이메일을 입력해주세요.(현재값 : " + contact1.getEmail() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
		String newEmail = sc.nextLine();
		if (newEmail != null && newEmail.trim().length() > 0) {
			contact1.setEmail(newEmail);
		}

		System.out.println("변경하고자 하는 주소를 입력해주세요.(현재값 : " + contact1.getAddress() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
		String newAddress = sc.nextLine();
		if (newAddress != null && newAddress.trim().length() > 0) {
			contact1.setAddress(newAddress);
		}

		System.out.println("변경하고자 하는 생일을 입력해주세요.(현재값 : " + contact1.getBirthday() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
		String newBirthday = sc.nextLine();
		if (newBirthday != null && newBirthday.trim().length() > 0) {
			contact1.setBirthday(newBirthday);
		}

		System.out.println("변경하고자 하는 그룹을 입력해주세요.(현재값 : " + contact1.getGroup() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
		String newGroup = sc.nextLine();
		if (newGroup != null && newGroup.trim().length() > 0) {
			contact1.setGroup(newGroup);
		}

		if (contact1 instanceof CompanyContact1) {
			CompanyContact1 companyContact1 = (CompanyContact1) contact1;

			System.out.println(
					"변경하고자 하는 회사 이름을 입력해주세요.(현재값 : " + companyContact1.getCompany() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0) {
				companyContact1.setCompany(company);
			}

			System.out.println(
					"변경하고자 하는 부서 이름을 입력해주세요.(현재값 : " + companyContact1.getDivision() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
			String division = sc.nextLine();
			if (division != null && division.trim().length() > 0) {
				companyContact1.setDivision(division);
			}

			System.out.println(
					"변경하고자 하는 직급을 입력해주세요.(현재값 : " + companyContact1.getManager() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
			String manager = sc.nextLine();
			if (manager != null && manager.trim().length() > 0) {
				companyContact1.setManager(manager);
			}

		} else if (contact1 instanceof CustomerContact1) {
			CustomerContact1 customerContact1 = (CustomerContact1) contact1;

			System.out.println("변경하고자 하는 거래처 회사 이름을 입력해주세요.(현재값 : " + customerContact1.getCompany() + ")\n"
					+ "변경하지 않으려면 엔터를 치세요 > ");
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0) {
				customerContact1.setCompany(company);
			}

			System.out.println(
					"변경하고자 하는 거래품목을 입력해주세요.(현재값 : " + customerContact1.getProduct() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
			String product = sc.nextLine();
			if (product != null && product.trim().length() > 0) {
				customerContact1.setProduct(product);
			}

			System.out.println(
					"변경하고자 하는 담당자 이름을 입력해주세요.(현재값 : " + customerContact1.getManager() + ")\n" + "변경하지 않으려면 엔터를 치세요 > ");
			String manager = sc.nextLine();
			if (manager != null && manager.trim().length() > 0) {
				customerContact1.setManager(manager);
			}
		}

		System.out.println("정보가 수정되었습니다.");
		System.out.println();
	}

	// 삭제
	void deleteContact1() {
		// 검색어 받기
		System.out.println("데이터 삭제가 진행됩니다.");
		System.out.print("삭제하고자 하는 이름을 입력해주세요 > ");

		int searchIndex1 = getIndex1();

		// 검색한 index 값으로 분기 : 시프트를 하거나 검색 결과 이름이 존재하지 않는다!
		if (searchIndex1 < 0) {
			System.out.println("삭제하고자 하는 이름의 데이터가 존재하지 않습니다.");

		} else {
			contacts.remove(searchIndex1);
			System.out.println("데이터가 삭제되었습니다.");
		}
	}

	// 검색 후 결과 출력 ( 이름으로 검색)
	void searchInfoPrint1() {

		// 1. 사용자에게 검색할 키워드 입력받는다
		// 2. 배열에서 이름 검색
		// 3. 결과 출력 : "검색한 이름의 정보가 없습니다"
		String name = null; // 검색할 이름
		System.out.println("검색을 시작합니다");
		System.out.print("검색할 이름을 입력하세요 > ");

		int searchIndex1 = getIndex1();

		// 3. 결과 출력
		System.out.println("검색의 결과 ====================");
		if (searchIndex1 < 0) {
			System.out.println("검색한 이름 " + name + " 의 정보가 없습니다.");
		} else {
			contacts.get(searchIndex1).printInfo();
		}
	}

	// 전체 입력 데이터 출력
	void printAllData1() {
		// 배열에 저장된 데이터를 모두 출력
		System.out.println("전체 데이터를 출력합니다. =====================");
		if (contacts.size() == 0) {// contacts.isEmpty()로 써도 됨
			System.out.println("입력된 정보가 없습니다.");
			return; // 메소드 종료
		}
		for (int i = 0; i < contacts.size(); i++) {
			contacts.get(i).printInfo();
		}
	}

	// 친구 정보 입력
	void insertContact1() {
		// 배열에 인스턴스를 저장하고,
		// 데이터 받고
		// 인스턴스 생성
		// 배열에 인스턴스의 참조값을 저장

		if (contacts.size() == 10) {
			System.out.println("최대 저장 개수는 10개 입니다");
			return;
		}

		// 회사 친구 입력 ?
		// 거래처 정보 입력

		System.out.println("입력하고자 하는 친구 타입을 선택해주세요.");
		System.out.println("1. 회사 동료 \t 2. 거래처");
		int select = Integer.parseInt(sc.nextLine());

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		// 데이터 받는 코드
		System.out.println("입력을 시작합니다.");
		System.out.print("이름 > ");
		name = getName1();
		System.out.print("전화번호 > ");
		phoneNumber = getPhoneNumber1();
		System.out.print("이메일 > ");
		email = getString();
		System.out.print("주소 > ");
		address = getString();
		System.out.print("생일 > ");
		birthday = getString();
		System.out.print("그룹 > ");
		group = getString();

		Contact1 contact1 = null;

		// 분기 1. 회사 2. 거래처
		if (select == 1) {
			// CompanyContact1 인스턴스 생성
			System.out.print("회사 이름 > ");
			String company = getString();
			System.out.print("부서 이름 > ");
			String division = getString();
			System.out.print("직급 > ");
			String manager = getString();

			contact1 = new CompanyContact1(name, phoneNumber, email, address, birthday, group, company, division,
					manager);

		} else {
			// CustomerContact1 인스턴스 생성

			System.out.print("거래처 이름 > ");
			String company = getString();
			System.out.print("거래 품목 > ");
			String product = getString();
			System.out.print("담당자 > ");
			String manager = getString();

			contact1 = new CustomerContact1(name, phoneNumber, email, address, birthday, group, company, product,
					manager);
		}

		// 인스턴스 생성
		// Contact1 contact1 = new Contact1(name, phoneNumber, email, address, birthday,
		// group);

		// 배열에 저장
		// 처음 입력할 때 numOfContact1 = 0
		//contacts[numOfContact1++] = contact1; // 증감 후위형은 데이터 먼저 대입하고 후++이니까 0부터 적용
		// numOfContact1++;
		contacts.add(contact1);
	}

	// Scanner 를 통해서 사용자에게 문자열을 받아서 반환하는 메소드
	// 입력 문자가 공백일 경우 다시 입력하도록 하는 기능
	private String getString() {
		String str = null;

		while (true) {
			str = sc.nextLine();
			if (str != null && str.trim().length() != 0) {
				break;
			} else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요");
			}
		}
		return str;
	}

	// 이름 정보를 받아서 중복 여부 체크 후 문자열 반환
	private String getName1() {
		String name = null;

		while (true) {
			name = sc.nextLine();
			if (name != null && name.trim().length() != 0) {
				// 배열 요소에 같은 이름의 요소가 있는지 체크
				boolean check = false;

				// 이름 검색
				for (int i = 0; i < contacts.size(); i++) {
					if (name.equals(contacts.get(i).getName())) {
						check = true;
						break;
					}
				}
				if (check) {
					System.out.println("같은 이름의 데이터가 존재합니다.\n다시 입력하세요");
					// continue;
				} else {
					break;
				}

			} else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요");
			}
		}

		return name;

	}

	// 전화번호를 받아서 중복된 전화번호가 있는지 체크
	// 중복되지 않는 전화번호 받아서 반환
	private String getPhoneNumber1() {
		String phoneNumber = null;
		

		while (true) {
			phoneNumber = sc.nextLine();
			if (phoneNumber != null && phoneNumber.trim().length() > 0) {

				boolean check = false;

				// 중복여부 체크
				for (int i = 0; i < contacts.size(); i++) {
					if (phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
						check = true;
						break;
					}

				}

				if (check) {
					System.out.println("중복된 전화번호가 존재합니다. \n다시 입력해주세요");
				} else {
					break;
				}

			} else {
				System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요");
			}

		}
		return phoneNumber;
	}
}
