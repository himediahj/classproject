package ver05;

public class SmartPhoneMain2 {

	public static void main(String[] args) {

		SmartPhone1 sp = SmartPhone1.getInstance();
		
		while(true) {
			printMenu();
			
			int select = Integer.parseInt(sp.sc.nextLine()); 
			
			switch(select) {
			case 1:
				sp.insertContact1();
				break;
			case 2:
				sp.searchInfoPrint1();
				break;
			case 3:
				sp.editContact1();
				break;
			case 4:
				sp.deleteContact1();
				break;
			case 5:
				sp.printAllData1();
				break;
			case 6:
				System.out.println("프로그램 종료합니다");
				return;
			}
		}
		
	
	}

	static void printMenu() {
		System.out.println("====================================");
		System.out.println("# 전화번호부");
		System.out.println("1. 연락처 저장");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 출력");
		System.out.println("6. 프로그램 종료");
		System.out.println("====================================");
		System.out.println("원하시는 메뉴 번호를 입력해주세요");
	}
}