package chapter06.exam;

public class Student0 {

	private String name;
	private int korScore;
	private int engScore;
	private int matScore;

	public Student0(String name, int korScore, int engScore, int matScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.matScore = matScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMatScore() {
		return matScore;
	}

	public void setMatScore(int matScore) {
		this.matScore = matScore;
	}
	
	
	public int totalScore() {
		int result = this.korScore + this.engScore + this.matScore;
		return result;
	}
	
	public int avgScore() {
		return totalScore()/3;
	}
	
	public void showInfo() {
		System.out.println(this.name + "\t" + this.korScore + "\t" + this.engScore + "\t" + this.matScore);	// '+' 안쓰고 쉼표 써서 에러났음! 안되는 줄 알고 get 매서드도 집어넣어 봄
																											// 메소드 안에 메소드는 못넣으니까 get은 못넣겠지..?
	}
	
	// main클래스에서 작성하다가 오류났음! 흠.. 선생님 답변 : 간단한 기능 테스트 목적이다!!!
//	public static void main(String[] args) {
//		Student0 s = new Student0("박지성", 100, 0, 24);
//	}
}
	

