package chapter05.exam;

public class MemberMain {

	public static void main(String[] args) {

		MemberTeacerVer m1 = new MemberTeacerVer("Son", "010-1111-1111", "축구", 1, "son@gmail.com", 20000101, "런던");
		m1.showMemberInfo();
		
		MemberTeacerVer m2 = new MemberTeacerVer("손흥민", "010-9999-1111", "체육", 4, "sonKing@gmail.com");
		m2.showMemberInfo();
	}

}
