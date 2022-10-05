package ver07;

public class CustomerContact1 extends Contact1 {

	// 거래처회사이름, 거래품목, 직급 변수 추가
	// 정보 출력하는 메소드 오버라이딩 해서 추가된 정보 출력
	
	private String company;
	private String product;
	private String manager;
	
	
	public CustomerContact1(String name, String phoneNumber, String email, String address, String birthday, String group,
			String company, String product, String manager) {
		super(name, phoneNumber, email, address, birthday, group);
		this.company = company;
		this.product = product;
		this.manager = manager;
	}

	

	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}



	public String getManager() {
		return manager;
	}



	public void setManager(String manager) {
		this.manager = manager;
	}



	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("거래처 회사이름 : " + this.company);
		System.out.println("거래품목 : " + this.product);
		System.out.println("담당자 : " + this.manager);
	}



	@Override
	public void showData() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
