package dto;

public class cpuVO {
	private String company;
	private String name;
	private String core;
	private double min;
	private double max;
	private String inner;
	private int price;
	
	public cpuVO() {}
	
	public cpuVO(String company, String name, String core, double normal, double max,
			String inner, int price) {
		this.company = company;
		this.name = name;
		this.core = core;
		this.min = min;
		this.max = max;
		this.inner = inner;
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
	
	public void setCore(String core) {
		this.core = core;
	}
	public String getCore() {
		return core;
	}
	
	public void setMin(double min) {
		this.min = min;
	}
	public double getMin() {
		return min;
	}
	
	public void setMax(double max) {
		this.max = max;
	}
	public double getMax() {
		return max;
	}
	
	public void setInner(String inner) {
		this.inner = inner;
	}
	public String getInner() {
		if(inner.equals(1)) {
			String newInner = "탑재";
			return newInner;
		} else {
			String newInner = "미탑재";
			return newInner;
		}
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
}