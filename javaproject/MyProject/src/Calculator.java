
public class Calculator {

	public static void main(String[] args) {
		System.out.println("10+20=" + add(10, 20));  // 10+20=30
		System.out.println("100-10=" + substract(100, 10));  // 100-10=90
		System.out.println("100*100=" + multifly(100, 100)); // 100*100=10000
		System.out.println("10/3=" + divide(10, 3));
	}
	
	public static long add(long n1, long n2) {
		//long result = n1 + n2;
		//return result;
		return n1 + n2;
	}
	
	public static long substract(long n1, long n2) {
		//long result2 = n1 - n2;
		//return result2;
		return n1 - n2;
	}
	
	public static long multifly(long n1, long n2) {
		//long result3 = n1 * n2;
		//return result3;
		return n1 * n2;
	}
	
	public static double divide(double n1, double n2) {
		//double result4 = n1 / n2;
		//return result4;
		return n1 / n2;
	}
	
}



