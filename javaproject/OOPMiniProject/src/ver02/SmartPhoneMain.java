package ver02;

public class SmartPhoneMain {

	public static void main(String[] args) {

		SmartPhone smartPhone = SmartPhone.getInstance();
		
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.insert();
		smartPhone.print();
		smartPhone.delete();
		smartPhone.modify();
		
	}

}
