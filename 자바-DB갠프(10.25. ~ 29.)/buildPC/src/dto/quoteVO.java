package dto;

public class quoteVO {
	private String quoteName;
	private String cpuName;
	private int cpuPrice;
	private String mbName;
	private int mbPrice;
	private String vgaName;
	private int vgaPrice;
	private String ramName;
	private int ramPrice;
	private String ssdName;
	private int ssdPrice;
	
	public quoteVO() {}
	
	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}
	public String getQuoteName() {
		return quoteName;
	}
	
	public void setCPUName(String cpuName) {
		this.cpuName = cpuName;
	}
	public String getCPUName() {
		return cpuName;
	}
	public void setCPUPrice(int cpuPrice) {
		this.cpuPrice = cpuPrice;
	}
	public int getCPUPrice() {
		return cpuPrice;
	}
	
	public void setMbName(String mbName) {
		this.mbName = mbName;
	}
	public String getMbName() {
		return mbName;
	}
	public void setMbPrice(int mbPrice) {
		this.mbPrice = mbPrice;
	}
	public int getMbPrice() {
		return mbPrice;
	}
	
	public void setVGAName(String vgaName) {
		this.vgaName = vgaName;
	}
	public String getVGAName() {
		return vgaName;
	}
	public void setVGAPrice(int vgaPrice) {
		this.vgaPrice = vgaPrice;
	}
	public int getVGAPrice() {
		return vgaPrice;
	}
	
	public void setRAMName(String ramName) {
		this.ramName = ramName;
	}
	public String getRAMName() {
		return ramName;
	}
	public void setRAMPrice(int ramPrice) {
		this.ramPrice = ramPrice;
	}
	public int getRAMPrice() {
		return ramPrice;
	}
	
	public void setSSDName(String ssdName) {
		this.ssdName = ssdName;
	}
	public String getSSDName() {
		return ssdName;
	}
	public void setSSDPrice(int ssdPrice) {
		this.ssdPrice = ssdPrice;
	}
	public int getSSDPrice() {
		return ssdPrice;
	}
}