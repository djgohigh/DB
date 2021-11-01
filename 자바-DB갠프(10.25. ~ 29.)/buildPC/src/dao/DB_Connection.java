package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import controller.makeQuote;
import dto.*;

public class DB_Connection {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt;
	public ArrayList<cpuVO> cpuList = new ArrayList<cpuVO>();
	public ArrayList<mainboardVO> mainboardList = new ArrayList<mainboardVO>();
	public ArrayList<vgaVO> vgaList = new ArrayList<vgaVO>();
	public ArrayList<ssdVO> ssdList = new ArrayList<ssdVO>();
	public ArrayList<ramVO> ramList = new ArrayList<ramVO>();
	public ArrayList<quoteVO> quoteList = new ArrayList<quoteVO>();
	public quoteVO quote = new quoteVO();
	DecimalFormat DF = new DecimalFormat("###,###");

	public DB_Connection() {
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����:" + e.getMessage());
		}
	}
	
	public void searchCPU() {
		String SQL = "SELECT * FROM CPU";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String company = rs.getString("company");
				String name = rs.getString("name");
				String core = rs.getString("core");
				double min = rs.getDouble("min");
				double max = rs.getDouble("max");
				String inner = rs.getString("inner");
				int price = rs.getInt("price");
				
				cpuVO list = new cpuVO(); // list ��ü ����
				list.setCompany(rs.getString("company"));
				list.setName(rs.getString("name"));
				list.setCore(rs.getString("core"));
				list.setMin(rs.getDouble("min"));
				list.setMax(rs.getInt("max"));
				list.setInner(rs.getString("inner"));
				list.setPrice(rs.getInt("price"));
				cpuList.add(list);
				
			}
			for(int i=0; i<cpuList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + cpuList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + cpuList.get(i).getName() + " / ");
			System.out.printf("�ھ�� : " + cpuList.get(i).getCore() + "�� / ");
			System.out.printf("�⺻Ŭ�� : " + cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("�ִ�Ŭ�� : " + cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("����׷��� ���� : " + cpuList.get(i).getInner() + " / ");
			int price = cpuList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchMainboard() {
		String SQL = "SELECT * FROM MAINBOARD";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String company = rs.getString("company");
				String name = rs.getString("name");
				String chipset = rs.getString("chipset");
				int maxmemory = rs.getInt("maxmemory");
				int price = rs.getInt("price");
				
				mainboardVO list = new mainboardVO(); // list ��ü ����
				list.setCompany(rs.getString("company"));
				list.setName(rs.getString("name"));
				list.setChipset(rs.getString("chipset"));
				list.setMaxmemory(rs.getInt("maxmemory"));
				list.setPrice(rs.getInt("price"));
				mainboardList.add(list);
				
			}
			for(int i=0; i<mainboardList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + mainboardList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + mainboardList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + mainboardList.get(i).getChipset() + " / ");
			System.out.printf("�ִ�޸𸮿뷮 : " + mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = mainboardList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchVGA() {
		String SQL = "SELECT * FROM VGA";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String company = rs.getString("company");
				String name = rs.getString("name");
				String chipset = rs.getString("chipset");
				int clock = rs.getInt("clock");
				int memory = rs.getInt("memory");
				int price = rs.getInt("price");
				
				vgaVO list = new vgaVO(); // list ��ü ����
				list.setCompany(rs.getString("company"));
				list.setName(rs.getString("name"));
				list.setChipset(rs.getString("chipset"));
				list.setClock(rs.getInt("clock"));
				list.setMemory(rs.getInt("memory"));
				list.setPrice(rs.getInt("price"));
				vgaList.add(list);
				
			}
			for(int i=0; i<vgaList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + vgaList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + vgaList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + vgaList.get(i).getChipset() + " / ");
			System.out.printf("�޸𸮿뷮 : " + vgaList.get(i).getMemory() + "GB / ");
			int price = vgaList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchRAM() {
		String SQL = "SELECT * FROM RAM";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String company = rs.getString("company");
				String name = rs.getString("name");
				int capacity = rs.getInt("capacity");
				int clock = rs.getInt("clock");
				int price = rs.getInt("price");
				
				ramVO list = new ramVO(); // list ��ü ����
				list.setCompany(rs.getString("company"));
				list.setName(rs.getString("name"));
				list.setCapacity(rs.getString("capacity"));
				list.setClock(rs.getInt("clock"));
				list.setPrice(rs.getInt("price"));
				ramList.add(list);
			}
			for(int i=0; i<ramList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + ramList.get(i).getCompany() + " / ");
			System.out.printf("�޸𸮿뷮 : " + ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("Ŭ�� : " + ramList.get(i).getClock() + "Mhz / ");
			int price = ramList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchSSD() {
		String SQL = "SELECT * FROM SSD";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String company = rs.getString("company");
				String name = rs.getString("name");
				String capacity = rs.getString("capacity");
				String ssdType = rs.getString("ssdtype");
				int price = rs.getInt("price");
				
				ssdVO list = new ssdVO(); // list ��ü ����
				list.setCompany(rs.getString("company"));
				list.setName(rs.getString("name"));
				list.setCapacity(rs.getString("capacity"));
				list.setSSDType(rs.getString("ssdtype"));
				list.setPrice(rs.getInt("price"));
				ssdList.add(list);
			}
			for(int i=0; i<ssdList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + ssdList.get(i).getCompany() + " / ");
			System.out.printf("����뷮 : " + ssdList.get(i).getCapacity() + " / ");
			System.out.printf("����Ÿ�� : " + ssdList.get(i).getSSDType() + " / ");
			int price = ssdList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertQuote() {
		String SQL = "INSERT INTO QUOTE(QUOTENAME, CPUNAME, CPUPRICE, MBNAME, MBPRICE, VGANAME, VGAPRICE, RAMNAME,"
				+ "RAMPRICE, SSDNAME, SSDPRICE)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(SQL);
			
			String quoteName = quote.getQuoteName();
			String cpuName = quote.getCPUName();
			int cpuPrice = quote.getCPUPrice();
			String mbName = quote.getMbName();
			int mbPrice = quote.getMbPrice();
			String vgaName = quote.getVGAName();
			int vgaPrice = quote.getVGAPrice();
			String ramName = quote.getRAMName();
			int ramPrice = quote.getRAMPrice();
			String ssdName = quote.getSSDName();
			int ssdPrice = quote.getSSDPrice();
			
			pstmt.setString(1, quoteName);
			pstmt.setString(2, cpuName);
			pstmt.setInt(3, cpuPrice);
			pstmt.setString(4, mbName);
			pstmt.setInt(5, mbPrice);
			pstmt.setString(6, vgaName);
			pstmt.setInt(7, vgaPrice);
			pstmt.setString(8, ramName);
			pstmt.setInt(9, ramPrice);
			pstmt.setString(10, ssdName);
			pstmt.setInt(11, ssdPrice);
			
			System.out.println("# ������ ���������� ����Ǿ����ϴ�.");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchQuote() {
		String SQL = "SELECT * FROM QUOTE";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				
				String quoteName = rs.getString("quoteName");
				String cpuName = rs.getString("cpuName");
				int cpuPrice = rs.getInt("cpuPrice");
				String mbName = rs.getString("mbName");
				int mbPrice = rs.getInt("mbPrice");
				String vgaName = rs.getString("vgaName");
				int vgaPrice = rs.getInt("vgaPrice");
				String ramName = rs.getString("ramName");
				int ramPrice = rs.getInt("ramPrice");
				String ssdName = rs.getString("ssdName");
				int ssdPrice = rs.getInt("ssdPrice");
				
				
				quoteVO list = new quoteVO(); // list ��ü ����
				list.setQuoteName(rs.getString("quoteName"));
				list.setCPUName(rs.getString("cpuName"));
				list.setCPUPrice(rs.getInt("cpuPrice"));
				list.setMbName(rs.getString("mbName"));
				list.setMbPrice(rs.getInt("mbPrice"));
				list.setVGAName(rs.getString("vgaName"));
				list.setVGAPrice(rs.getInt("vgaPrice"));
				list.setRAMName(rs.getString("ramName"));
				list.setRAMPrice(rs.getInt("ramPrice"));
				list.setSSDName(rs.getString("ssdName"));
				list.setSSDPrice(rs.getInt("ssdPrice"));
				quoteList.add(list);
			}
			for(int i=0; i<quoteList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)");
			System.out.printf("�������� : " + quoteList.get(i).getQuoteName());
			}
			System.out.println(" ");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDbCPU(String cpuName, int cpuPrice, String quoteName) {
		String SQL = "UPDATE QUOTE SET CPUNAME = ?, PRICE = ? WHERE QUOTENAME = ?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, cpuName);
			pstmt.setInt(2, cpuPrice);
			pstmt.setString(3, quoteName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}