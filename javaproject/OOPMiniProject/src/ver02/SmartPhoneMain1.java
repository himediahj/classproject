package ver02;

public class SmartPhoneMain1 {

	public static void main(String[] args) {

		SmartPhone1 smartPhone1 = SmartPhone1.getInstance();

		// 입력
		smartPhone1.insertContact1();
		System.out.println();

		// 전체 출력
		smartPhone1.printAllData1();
		System.out.println();

		// 이름 검색 후 결과 출력
//		smartPhone1.searchInfoPrint1();
//		System.out.println();
		
		// 이름 검색 후 정보 수정
		smartPhone1.editContact1();
		System.out.println();
		smartPhone1.searchInfoPrint1();
		System.out.println();
		smartPhone1.searchInfoPrint1();
		System.out.println();
		smartPhone1.printAllData1();
		

		// 이름 검색 후 삭제
//		smartPhone1.deleteContact1();
//		System.out.println();
//		smartPhone1.searchInfoPrint1();
//		System.out.println();
//		smartPhone1.printAllData1();
//
//		// 이름 검색 후 삭제
//		smartPhone1.deleteContact1();
//		System.out.println();
//		smartPhone1.searchInfoPrint1();
//		System.out.println();
//		smartPhone1.printAllData1();
	}

}
