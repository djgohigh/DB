package dto;

public class vgaVO {
	private String company;
	private String name;
	private String chipset;
	private int clock;
	private int memory;
	private int price;
	
	public vgaVO() {}
	
	public vgaVO(String company, String name, String chipset, int clock, int memory,
			int price) {
		this.company = company;
		this.name = name;
		this.chipset = chipset;
		this.clock = clock;
		this.memory = memory;
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
	
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getChipset() {
		return chipset;
	}
	
	public void setClock(int clock) {
		this.clock = clock;
	}
	public int getClock() {
		return clock;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getMemory() {
		return memory;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}