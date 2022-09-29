package chapter10.exam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam2Main {

	public static void main(String[] args) {
		// 2. Scanner 클래스로 태어난 년도를 입력받을 때 int 타입으로 받도록 합시다.
		// 이때 nextInt() 메소드를 사용하는데 이때 발생하는 예외처리 하도록

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 >> ");
		
		int num = 0;
		
		try {
			num = sc.nextInt(); // 예외처리 포인트
			System.out.println("num = " + num);
		} catch (InputMismatchException e) {
			System.out.println("예외발생");
			System.out.println("정상적인 숫자를 입력해주세요");
		}
		

	}

}
