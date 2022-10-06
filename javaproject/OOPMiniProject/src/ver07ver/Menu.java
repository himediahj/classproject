package ver07ver;

public class Menu {

	public static void main(String[] args) {

		SmartPhone sp = SmartPhone.getInstance();

		while (true) {
			printMenu();

			try {

				int select = Integer.parseInt(sp.sc.nextLine());

				if (!(select >= 1 && select <= 6)) {
					throw new Exception("1부터 6까지의 숫자만 입력하세요");
				}

				switch (select) {
				case 1:
					sp.storeContact();
					break;
				case 2:
					sp.searchData();
					break;
				case 3:
					sp.editContact();
					break;
				case 4:
					sp.deleteContact();
					break;
				case 5:
					sp.printAllData();
					break;
				case 6:
					System.out.println("프로그램을 종료합니다");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자 형태로 입력하세요");

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		}

	}

	static void printMenu() {
		System.out.println("====================================");
		System.out.println("# 연락처 관리프로그램");
		System.out.println("1. 연락처 입력");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 리스트 보기");
		System.out.println("6. 종료");
		System.out.println("====================================");
		System.out.println("원하시는 메뉴 번호를 입력해주세요");
	}
}
