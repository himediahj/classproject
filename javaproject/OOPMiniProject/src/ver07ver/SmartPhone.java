package ver07ver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartPhone {

	private List<Contact> contact;
	private int numOfContact;
	Scanner sc;

	private SmartPhone() {
		contact = new ArrayList<>();
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
		name = getName();
		System.out.print("전화번호를 입력하세요 > ");
		phoneNumber = getPhoneNumber();
		System.out.print("이메일을 입력하세요 > ");
		email = getString();
		System.out.print("주소를 입력하세요 > ");
		address = getString();
		System.out.print("생일을 입력하세요 > ");
		birth = getString();
		System.out.print("그룹을 입력하세요 > ");
		group = getString();

		Contact contacts = null;
		// Contact contacts = new Contact(name, phoneNumber, email, address, birth,
		// group); 추상클래스니까 인터페이스 생성 불가

		if (select == 1) {
			System.out.print("회사이름을 입력하세요 > ");
			String company = sc.nextLine();
			System.out.print("부서이름을 입력하세요 > ");
			String department = sc.nextLine();
			System.out.print("직급을 입력하세요 > ");
			String position = sc.nextLine();

			contacts = new CompanyContact(name, phoneNumber, email, address, birth, group, company, department,
					position);

		} else {
			System.out.println("거래처회사이름을 입력하세요 > ");
			String company = sc.nextLine();
			System.out.println("거래품목을 입력하세요 > ");
			String product = sc.nextLine();
			System.out.println("직급을 입력하세요 > ");
			String position = sc.nextLine();

			contacts = new CustomerContact(name, phoneNumber, email, address, birth, group, company, product, position);
		}

		contact.add(contacts);
	}

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

	private String getName() {
		String name = null;
		while (true) {
			try {
				name = sc.nextLine();
				if (name != null && name.trim().length() != 0) {
					if (!Pattern.matches("^[a-zA-Z가-힣]*$", name))
						throw new Exception("이름에는 영문자와 한글만 입력이 가능합니다.");

					boolean check = false;

					for (int i = 0; i < numOfContact; i++) {
						if (name.equals(contact.get(i).getName())) {
							check = true;
							break;
						}
					}

					if (check) {
						// System.out.println("같은 이름의 데이터가 존재합니다.\n다시 입력하세요");
						throw new Exception("같은 이름의 데이터가 존재합니다.\n다시 입력하세요");
					} else {
						break;
					}
				} else {
					System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return name;
	}

	private String getPhoneNumber() {
		String phoneNumber = null;
		while (true) {
			try {
				phoneNumber = sc.nextLine();
				if (phoneNumber != null && phoneNumber.trim().length() != 0) {

					if (Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", phoneNumber))
						throw new Exception("000-000-0000 또는 000-0000-0000 형식으로 입력해야 합니다.");

					boolean check = false;

					for (int i = 0; i < numOfContact; i++) {
						if (phoneNumber.equals(contact.get(i).getPhoneNumber())) {
							check = true;
							break;
						}
					}
					if (check) {
						System.out.println("같은 전화번호의 데이터가 존재합니다.\n다시 입력하세요");
					} else
						break;
				} else
					System.out.println("공백은 허용하지 않습니다. 정상적인 문자를 입력하세요");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return phoneNumber;
	}

	private int getIndex() {
		String name = null;
		name = sc.nextLine();

		int searchIndex = -1;
		for (int i = 0; i < numOfContact; i++) {
			if (contact.get(i).equals(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;

	}

	void editContact() {

		System.out.print("수정하려는 이름을 입력해주세요");

		int searchIndex = getIndex();

		if (searchIndex < 0) {
			System.out.println("수정하고자 하는 이름이 존재하지 않습니다");
			return;
		}

		Contact contacts = contact.get(searchIndex);

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

		if (contacts instanceof CompanyContact) {
			CompanyContact companyContact = (CompanyContact) contacts;

			System.out.println("새로운 거래처회사이름을 입력해주세요. 현재값 : " + companyContact.getCompanyName());
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0)
				companyContact.setCompanyName(company);

			System.out.println("새로운 부서이름을 입력해주세요. 현재값 : " + companyContact.getDepartmentName());
			String department = sc.nextLine();
			if (department != null && department.trim().length() > 0)
				companyContact.setDepartmentName(department);

			System.out.println("새로운 직급을 입력해주세요. 현재값 : " + companyContact.getPosition());
			String position = sc.nextLine();
			if (position != null && position.trim().length() > 0)
				companyContact.setPosition(position);

		} else if (contacts instanceof CustomerContact) {
			CustomerContact customerContact = (CustomerContact) contacts;

			System.out.println("새로운 거래처회사이름을 입력해주세요. 현재값 : " + customerContact.getCompanyName());
			String company = sc.nextLine();
			if (company != null && company.trim().length() > 0)
				customerContact.setCompanyName(company);

			System.out.println("새로운 거래품목을 입력해주세요. 현재값 : " + customerContact.getProduct());
			String product = sc.nextLine();
			if (product != null && product.trim().length() > 0)
				customerContact.setProduct(product);

			System.out.println("새로운 직급을 입력해주세요. 현재값 : " + customerContact.getPosition());
			String position = sc.nextLine();
			if (position != null && position.trim().length() > 0)
				customerContact.setPosition(position);

		}
		System.out.println("정보가 수정되었습니다.");

	}

	void deleteContact() {
		System.out.print("삭제하려는 이름을 입력해주세요");

		int searchIndex = getIndex();

		if (searchIndex < 0) {
			System.out.println("삭제하고자 하는 이름이 존재하지 않습니다");
		} else {
			contact.remove(searchIndex);
			System.out.println("데이터가 삭제되었습니다");
		}

	}

	void printAllData() {
		System.out.println("전체 데이터를 출력합니다");
		if (numOfContact == 0) {
			System.out.println("저장된 정보가 없습니다");
			return;
		}
		for (int i = 0; i < numOfContact; i++)
			contact.get(i).printAll();
	}

	void searchData() {
		String name = null;
		System.out.print("검색할 이름을 입력하세요 > ");

		int searchIndex = getIndex();

		if (searchIndex < 0) {
			System.out.println("검색한 이름 " + name + " 의 정보가 없습니다");
		} else {
			contact.get(searchIndex).printAll();
		}

	}

}
