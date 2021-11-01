package dto;

public class ramVO {
	private String company;
	private String capacity;
	private String name;
	private int clock;
	private int price;
	
	public ramVO() {}
	
	public ramVO(String company, String name, String capacity, int clock, int price) {
		this.company = company;
		this.name = name;
		this.capacity = capacity;
		this.clock = clock;
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
	
	
	public void setClock(int clock) {
		this.clock = clock;
	}
	public int getClock() {
		return clock;
	}
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}