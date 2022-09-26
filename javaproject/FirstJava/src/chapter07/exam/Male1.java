package chapter07.exam;

public class Male1 extends Person1 {

	String address;
	
	public Male1(String name, String personNumber, String address) {
		super(name, personNumber);
		this.address = address;
	}

	void hello() {
		System.out.println("안녕하세요");
	}

	@Override
	void printhi() {
		super.printhi();
		System.out.println("저는 " + address + "에 삽니다");
	}
	
	
}
