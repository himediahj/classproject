package chapter05.exam;

public class Member {

	String name;
	String phoneNumber;
	String major;
	int grade;
	String emailAddress;
	int birthMonth;
	int birthDay;
	String address;
	
		
	Member(){}	
	Member(String name, String phoneNumber, String major, int grade, String emailAddress, int birthMonth, int birthDay, String address){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.grade = grade;
		this.emailAddress = emailAddress;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.address = address;} 
	
	Member(String name, String phoneNumber, String major, int grade, String emailAddress){
		this(name, phoneNumber, major, grade, emailAddress, 0, 0, null);
	}
		
	
	void showInfo()
	{
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade + "학년");
		System.out.println("email : " + emailAddress);
		System.out.println("생일 : " + birthMonth + "월" + birthDay + "일");
		System.out.println("주소 : " + address);
	}
	
	
	
	
	
		
		
		
	

	public static void main(String[] args) {
		Member all = new Member("손흥민", "010-1234-2345", "축구", 4, "sonny@tt.com", 2, 4, "Englnad");
		all.showInfo();
		
		Member notall = new Member("손흥민", "010-1234-2345)", "축구", 4, "sonny@tt.com");
		notall.showInfo();
		
	} 
	
}





