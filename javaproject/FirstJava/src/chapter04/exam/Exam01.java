package chapter04.exam;

public class Exam01 {

	public static void main(String[] args) {
		// 문제 1.

		// for 문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성
		
		
		int result = 1;
		
		for(int i = 1; i <=10; i++) {
			
			// result = result * i;
			result *= i;
			System.out.print( i + " : " + result + "\n");

		}
		
	}

}
