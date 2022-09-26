package chapter07.exam;

public class Female1 extends Person1 {

	int favnum;
	
	public Female1(String name, String personNumber, int favnum) {
		super(name, personNumber);
		this.favnum = favnum;
	}

	void like() {
		System.out.println("제가 좋아하는 숫자는 " + favnum + "입니다");
	}

	@Override
	void printhi() {
		super.printhi();
		like();
	}
	
	
}
