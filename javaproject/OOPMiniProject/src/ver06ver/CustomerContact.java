package ver06ver;


public class CustomerContact extends Contact {

	private String companyName;
	private String product;
	private String position;

	public CustomerContact(String name, String phoneNumber, String email, String address, String birth, String group,
			String companyName, String product, String position) {
		super(name, phoneNumber, email, address, birth, group);
		this.companyName = companyName;
		this.product = product;
		this.position = position;
	}

	@Override
	void printAll() {
		super.printAll();
		System.out.println("거래처회사이름 : "+this.companyName);
		System.out.println("거래품목 : "+this.product);
		System.out.println("직급 : "+this.position);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
}
