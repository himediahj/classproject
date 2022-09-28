package chapter09.exam;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		int sum = 0;
		for(int i=1; i<=100000000; i++)
			sum += i;
		
		long endTime = System.currentTimeMillis();
		
		long estimatedTime = endTime - startTime;
		System.out.println("해당 기능의 실행 시간 : " + estimatedTime);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요. > ");
		String name = sc.nextLine();
		System.out.println("공백으로 입력되었습니까? " + name.isEmpty());
		
		LocalDate now = LocalDate.now();
		
	}

}
