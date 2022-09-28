package chapter09.exam;

public class Person {

	String name;
	String personNumber;
	
	
	
	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}


	// 주민등록번호가 같으면 같은 인스턴스로 판별하는 프로그램 만들어보자
	// "000000-0000000"
	@Override
	public boolean equals(Object obj) {
	
		boolean result = false;
		
		// 매개변수로 전달받은 객체와 주민번호 비교
		if(obj !=null && obj instanceof Person){
			// Object -> Person 형변환
			Person person = (Person)obj;
			result = this.personNumber.equals(person.personNumber);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		Person p1 = new Person("SON", "000000-1111111");
		Person p2 = new Person("PARK", "000000-11111111");
		Person p3 = new Person("SON", "111111-2222222");
		
		System.out.println("p1 과 p2는 같은 사람인가?" + p1.equals(p2));
		System.out.println("p1 과 p3는 같은 사람인가?" + p1.equals(p3));
		
	}
	
}
