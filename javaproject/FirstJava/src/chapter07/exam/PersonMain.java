package chapter07.exam;

public class PersonMain {

	public static void main(String[] args) {

		Male m = new Male("SON", "971212-1111111", "sonny");
		Female f = new Female("king", "001223-4444444", "체육", 3);
		
		m.printInfo();
		m.hi();
		
		System.out.println();
		f.printInfo();
		System.out.println();
		System.out.println();
		f.printSchoolInfo();
		
		Person p1 = m;	// (Person)형변환 연산자 생략 가능
		Person p2 = f;
		
		// p1.hi();	// hi()는 Person 클래스의 멤버가 아니기 때문에 호출 불가
		// p2.printSchoolInfo();	
		System.out.println();
		System.out.println("--------------------------");
		p2.printInfo();
	}
	
	

}
