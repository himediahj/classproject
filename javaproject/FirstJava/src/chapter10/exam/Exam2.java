package chapter10.exam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("태어난 년도를 입력하세요 > ");
		
		try {
			int birth = sc.nextInt();
			System.out.println(birth);
		} catch(InputMismatchException e) {
			System.out.println("숫자만 입력하세요");
		}
	}

}
