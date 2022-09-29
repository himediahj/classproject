package chapter10.exam;

import java.util.Scanner;

public class Throw {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디를 입력하세요 > ");
		String id = sc.nextLine();
		try {
			for (int i = 0; i < id.length(); i++) {
				char c = id.charAt(i);
				if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '1' && c <= '9')) {
					BadInputException e = new BadInputException();
					throw e;
				}
			}
		} catch (BadInputException e) {
			e.printStackTrace();
		}
		System.out.println(id);
	}
}
