package chapter02;

public class ValiableIntergerTest {

	public static void main(String[] args) {
		// 정수 : byte  short int (기본 타입)   long
        //       1byte 2byte 4byte           8byte
		
		
		int num = 100;
		
		byte byteNum1 = 10;
		byte byteNum2 = 127;
		byte byteNum3 = (byte)200;
		
		System.out.println(byteNum1);
		System.out.println(byteNum2);
		System.out.println(byteNum3);
		
		
		long longNum1 = 2200000000L;
		
		int num1 = 100000;
		int num2 = 100000;
		
		// 곱 연산
		long result = (long)num1 * num2; // long * long => long
		
		System.out.println(result);
		
		
	}

}
