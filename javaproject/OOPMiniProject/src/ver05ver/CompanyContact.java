package ver05ver;

public class CompanyContact extends Contact {

	private String companyName;
	private String departmentName;
	private String position;

	public CompanyContact(String name, String phoneNumber, String email, String address, String birth, String group,
			String companyName, String departmentName, String position) {
		super(name, phoneNumber, email, address, birth, group);
		this.companyName = companyName;
		this.departmentName = departmentName;
		this.position = position;
	}

	@Override
	void printAll() {
		super.printAll();
		System.out.println("회사 이름 : " + this.companyName);
		System.out.println("부서 이름 : " + this.departmentName);
		System.out.println("직급 : " + this.position);

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	@Override
	public void showData() {
		// TODO Auto-generated method stub
		
	}
	
}
