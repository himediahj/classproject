package chapter04;

public class WhileLoop {

	public static void main(String[] args) {

		// 5번 "JAVA"를 출력하는 코드 작성
		
		int count = 0;
		while(count++ < 5) {	// ++count 넣으면 4번 반복
			System.out.println("JAVA");
			
			// 반복문을 탈출할 수 있는 증감식
			// count++;	// count = count + 1 ; count += 1 ;
		}
		
	}

}
