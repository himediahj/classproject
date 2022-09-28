package chapter09.exam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		// 2번. 1~100,000,000 더하기 연산 실행 시간 측정
		long startTime = System.currentTimeMillis();

		int sum = 0;
		for (int i = 1; i <= 100000000; i++)
			sum += i;

		long endTime = System.currentTimeMillis();

		long estimatedTime = endTime - startTime;
		System.out.println("해당 기능의 실행 시간 : " + estimatedTime);

		// 3번. 이름 입력받아 입력받은 문자열 정상적인지 판별, 공백인지 판별
		Scanner sc = new Scanner(System.in);
			while(true) {System.out.print("이름을 입력하세요. > ");
			String name = sc.nextLine();

			if (name.trim().isEmpty())
				System.out.println("공백문자는 입력이 불가합니다");
			else {
				if (check(name)) {
					System.out.println(name);
				    break;}
				else
					System.out.println("영문자만 입력해주세요");
					
			}
			}
			
			
		// 4번. 오늘까지 몇 일 살았는지 계산
			LocalDate birth = LocalDate.of(1999, 7, 23);
			LocalDate now = LocalDate.now();
			
			long days = ChronoUnit.DAYS.between(birth, now);
			System.out.println(days);

		
	}

	static boolean check(String name) {

		boolean result = true;

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'))
				result = false;
			break;

		}

		return result;

	}
}