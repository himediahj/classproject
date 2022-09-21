package chapter06.exam;

public class Student0Main {

	public static void main(String[] args) {

		Student0[] students = new Student0[10];	// 선언하는 규칙 익숙치 않다..
		
		
		
		
		// 여기 아예 작성 못했음! 인스턴스화 한다는 걸 몰랐음..
		for(int i=0; i<students.length; i++) {
			students[i] = new Student0("학생"+i, (int)(Math.random()*51)+50, (int)(Math.random()*51)+50, (int)(Math.random()*51)+50);
					
		}
		
		int korTotalScore = 0;
		int engTotalScore = 0;
		int matTotalScore = 0;
		System.out.println("이름\t국어\t영어\t수학");
		for (Student0 a : students) {
			a.showInfo();
			korTotalScore += a.getKorScore();
			engTotalScore += a.getEngScore();
			matTotalScore += a.getMatScore();
		}
		System.out.println("-------------------------------");
		System.out.printf("총점\t%d\t%d\t%d", korTotalScore, engTotalScore, matTotalScore);
		
	}
				
		
		
}


