package chapter05.exam;

import java.util.Scanner;

public class Contact {
	
	String name;
	String phoneNumber;
	String email;
	String address;
	int birthday;
	String group;
	
	Contact(){}
	Contact(String name, String phoneNumber, String email, String address, int birthday, String group){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
		}
	
	void showInfo() {
		
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("이메일 : " + email);
		System.out.println("생일 : " + birthday);
		System.out.println("그룹 : " + group);
		
	}
	public void main(String[] args) {
		Contact c1 = new Contact();
		c1.showInfo();
	}
}
