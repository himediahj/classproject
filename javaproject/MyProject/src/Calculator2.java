import java.util.Scanner;

public class Calculator2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		double r = in.nextDouble();
				
		addPrint(num1, num2);
		subPrint(num1, num2);
		multiPrint(num1, num2);
		divPrint(num1, num2);
		System.out.println(circumPrint(r));
		System.out.println(areaPrint(r));
		
		
	}

	public static void addPrint(long num1, long num2) {
		long result = num1 + num2;
		System.out.println(result);
	}
	public static void subPrint(long num1, long num2) {
		long result2 = num1 - num2;
		System.out.println(result2);
	}	
	public static void multiPrint(long num1, long num2) {
		long result3 = num1 * num2;
		System.out.println(result3);
	}
		
	public static void divPrint(long num1, long num2) {
		long result4 = num1 / num2 ;
		System.out.println(result4);
	}	
		
	public static double circumPrint(double r) {
		// double result5 = 2 * 3.14 * r ;
		// return result5 ;
		return 2 * 3.14 * 4 ;
	}	
	
	public static double areaPrint(double r) {
		// double result6 = 3.14 * r * r ;
		// return result6 ;
		return 3.14 * r * r ;
	}
	
	
}
