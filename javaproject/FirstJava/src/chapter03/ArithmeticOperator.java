package chapter03;

public class ArithmeticOperator {

	public static void main(String[] args) {

		int num1 = 15;
		int num2 = 4;
		float num3 = 2.0f;
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		System.out.println(num1 / num3);
		System.out.println(num1 % num2);
		System.out.println(num1 % num3);
		
		// 0으로 나누는 건 오류야
		int result = num1 / 0;
		
	}

}
