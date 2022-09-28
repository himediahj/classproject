package chapter09.exam;

public class Person1 {

	String name;
	String personNumber;
	
	
	
	public Person1(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}



	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;

		if(obj !=null && obj instanceof Person1) {
			 Person1 p = (Person1)obj;
			 result = this.personNumber.equals(p.personNumber);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Person1 p1 = new Person1("son", "000102-3989218");
		Person1 p2 = new Person1("Jin", "000102-3989218");
		Person1 p3 = new Person1("son", "920325-2439948");
		
		System.out.println("p1과 p2의 주민번호는 같습니까? " + p1.equals(p2));
		System.out.println("p1과 p3의 주민번호는 같습니까? " + p1.equals(p3));
	}
	
}
