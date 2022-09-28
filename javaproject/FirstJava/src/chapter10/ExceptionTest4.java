package chapter10;

import java.util.Scanner;

public class ExceptionTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Scanner sc = null;
//		
//		try {
//		 sc = new Scanner(System.in);
//		} finally {
//			if(sc != null) {
//				sc.close();
//			}
//			
//		}
		
		
		try(Scanner sc = new Scanner(System.in))	// 자동으로 close 처리 된다.
		{
			
		} catch(Exception e) {
			
		}
		
		
	}

}
