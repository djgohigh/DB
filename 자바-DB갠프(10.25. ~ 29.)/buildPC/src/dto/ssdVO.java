package dto;

public class ssdVO {
	private String company;
	private String name;
	private String capacity;
	private String ssdType;
	private int price;
	
	public ssdVO() {}
	
	public ssdVO(String company, String name, String capacity, String ssdType, int price) {
		this.company = company;
		this.name = name;
		this.capacity = capacity;
		this.ssdType = ssdType;
		this.price = price;
	}
	

	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getCapacity() {
		return capacity;
	}
	
	
	public void setSSDType(String ssdType) {
		this.ssdType = ssdType;
	}
	public String getSSDType() {
		return ssdType;
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}