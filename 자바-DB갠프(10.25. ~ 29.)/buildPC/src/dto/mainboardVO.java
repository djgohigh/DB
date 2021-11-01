package dto;

public class mainboardVO {
	private String company;
	private String name;
	private String chipset;
	private int maxmemory;
	private int price;
	
	public mainboardVO() {}
	
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
	
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getChipset() {
		return chipset;
	}
	
	public void setMaxmemory(int maxmemory) {
		this.maxmemory = maxmemory;
	}
	public int getMaxmemory() {
		return maxmemory;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}