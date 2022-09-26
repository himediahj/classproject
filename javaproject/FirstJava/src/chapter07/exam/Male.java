package chapter07.exam;

public class Male extends Person {

	String nickName;
	
	Male(String name, String pNum, String nickName){
		super(name, pNum);
		this.nickName = nickName;
	}
	
	
	void hi() {
		System.out.println("안녕하세요!");
	}


	@Override	
	void printInfo() {
		super.printInfo();
		System.out.println("별명은 " + nickName + " 입니다.");
	}
	
	
	
}
