package chapter06.exam;

public class Exam {

	public static void main(String[] args) {
		
		// 메인 안적어서 오류났었음!
		int[][] n = new int[10][3];
	
		System.out.println("국어\t영어\t수학\t평균");
		
		
				
		for(int i=0; i < n.length; i++) {
			int sum = 0;	// sum을 i for문 위에 적어서 오류났었음! 행 바뀔때마다 0으로 초기화해줘야 하니까 위치가 여기겠지..
			for(int j=0; j < n[i].length; j++) {
				int num = (int)(Math.random()*51+50); 
				n[i][j] = num;
				sum += n[i][j];
				System.out.print(n[i][j] + "\t");
			}
			System.out.print(sum/n[i].length);
			System.out.println();
		}
		
		
		
	}
}