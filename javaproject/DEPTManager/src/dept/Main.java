package dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dept.controller.Controller;
import dept.controller.DeleteController;
import dept.controller.ExitController;
import dept.controller.InsertController;
import dept.controller.SelectByController;
import dept.controller.SelectController;
import dept.controller.UpdateController;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Command command = new Command();
		
//		List<Controller> list = new ArrayList<>(); 
//		list.add(null);
//		list.add(new SelectController());
//		list.add(new SelectByController());
//		list.add(new InsertController());
//		list.add(new UpdateController());
//		list.add(new DeleteController());
//		list.add(new ExitController());
//		
//		Map<Integer, Controller> command = new HashMap<>();
//		command.put(1, new SelectController());
//		command.put(2, new SelectByController());
//		command.put(3, new InsertController());
//		command.put(4, new UpdateController());
//		command.put(5, new DeleteController());
//		command.put(6, new ExitController());
//		
		
		
		while(true) {
			
			menu();
			System.out.print("원하시는 메뉴 번호를 입력하세요 >> ");
			int select = Integer.parseInt(sc.nextLine());
			
			//list.get(select).process();
			command.command.get(select).process();
		}
	}
	
	public static void menu() {
		System.out.println("부서관리 프로그램");
		System.out.println("1. 전체 부서 리스트");
		System.out.println("2. 부서 검색");
		System.out.println("3. 부서 정보 저장");
		System.out.println("4. 부서 정보 수정");
		System.out.println("5. 부서 정보 삭제");
		System.out.println("6. 프로그램 종료");
	}

}
