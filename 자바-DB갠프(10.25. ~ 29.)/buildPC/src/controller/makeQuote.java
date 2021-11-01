package controller;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import dao.DB_Connection;
import dto.quoteVO;

public class makeQuote {
	public static DB_Connection db = new DB_Connection();
	static int choice;
	static int cnt;
	static int min;
	static int max;
	static boolean check;
	static String word;
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat DF = new DecimalFormat("###,###");

	public static void choiceCPU() {
		cnt = 0;
		check = true;
		
		if (cnt == 0) {
			System.out.println("# CPU ��ǰ����Դϴ�. ");
			db.searchCPU();
			searchWhileCPU();
		} else if (cnt > 0) {
			searchWhileCPU();
		}
	}
	
	public static void searchWhileCPU() {
		while (check) {
			System.out.println("�� �����߰�");
			System.out.println("�� ��ǰ����");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("�� ������ �˻�");
				System.out.println("�� ���� �˻�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("�� INTEL");
					System.out.println("�� AMD");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						word = "INTEL";
						searchListCPUCompany(word);
						cnt++;
						break;
					case 2:
						word = "AMD";
						searchListCPUCompany(word);
						cnt++;
						break;
					}
					break;
				case 2:
					System.out.println("���� ������ �Է��ϼ���.");
					System.out.println("ex) 0 ~ 0,000,000�� // �Է� : 2ȸ(�ּ�, �ִ밪)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListCPUPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# �����Ͻ� ��ǰ��ȣ�� �Է��ϼ���.");
				int selectNum = sc.nextInt();
				System.out.println("# �� ��ǰ�� �������� �߰��Ͻðڽ��ϱ�?");
				showCPU(selectNum);
				System.out.println("�� ��");
				System.out.println("�� �ƴϿ�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# �����Ͻ� ��ǰ�� �������� �߰��߽��ϴ�.");
					String name = db.cpuList.get(selectNum-1).getName();
					db.quote.setCPUName(name);
					int number = db.cpuList.get(selectNum-1).getPrice();
					db.quote.setCPUPrice(number);
					
					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (db.cpuList.size()-1); i > -1; i--) {
						db.cpuList.remove(i);
					}
					choiceCPU();
					break;
				}
				break;
			}
		}
	}
		

	public static void showCPU(int num) {
		System.out.printf("������ : " + db.cpuList.get(num-1).getCompany() + " / ");
		System.out.printf("��ǰ�� : " + db.cpuList.get(num-1).getName() + " / ");
		System.out.printf("�ھ�� : " + db.cpuList.get(num-1).getCore() + "�� / ");
		System.out.printf("�⺻Ŭ�� : " + db.cpuList.get(num-1).getMin() + "GHz / ");
		System.out.printf("�ִ�Ŭ�� : " + db.cpuList.get(num-1).getMax() + "GHz / ");
		System.out.printf("����׷��� ���� : " + db.cpuList.get(num-1).getInner() + " / ");
		int price = db.cpuList.get(num-1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
		}
	
	public static void searchListCPUCompany(String searchWord) {
		
		for (int i = (db.cpuList.size()-1); i > -1; i--) {
			String character = db.cpuList.get(i).getCompany();
			if (character.contains(searchWord) == false) { db.cpuList.remove(i); }}
		
		for (int i=0; i<db.cpuList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.cpuList.get(i).getCompany() + " / ");
			System.out.printf("������ : " + db.cpuList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + db.cpuList.get(i).getName() + " / ");
			System.out.printf("�ھ�� : " + db.cpuList.get(i).getCore() + "�� / ");
			System.out.printf("�⺻Ŭ�� : " + db.cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("�ִ�Ŭ�� : " + db.cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("����׷��� ���� : " + db.cpuList.get(i).getInner() + " / ");
			int price = db.cpuList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if(db.cpuList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceCPU();
		}
	}
	
	public static void searchListCPUPrice(int min, int max) {

		for (int i = (db.cpuList.size() - 1); i > -1; i--) {
			int number = db.cpuList.get(i).getPrice();
			if (min > number || max < number) {
				db.cpuList.remove(i);
			}
		}
		
		for (int i = 0; i < db.cpuList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + db.cpuList.get(i).getCompany() + " / ");
			System.out.printf("������ : " + db.cpuList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + db.cpuList.get(i).getName() + " / ");
			System.out.printf("�ھ�� : " + db.cpuList.get(i).getCore() + "�� / ");
			System.out.printf("�⺻Ŭ�� : " + db.cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("�ִ�Ŭ�� : " + db.cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("����׷��� ���� : " + db.cpuList.get(i).getInner() + " / ");
			int price = db.cpuList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (db.cpuList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceCPU();
		}
	}
	
	public static void choiceMainboard() {
		cnt = 0;
		check = true;
		
		if (cnt == 0) {
			System.out.println("# MAINBOARD ��ǰ����Դϴ�. ");
			db.searchMainboard();
			searchWhileMainboard();
		} else if (cnt > 0) {
			searchWhileMainboard();
		}
	}
	
	public static void searchWhileMainboard() {
		while (check) {
			System.out.println("�� �����߰�");
			System.out.println("�� ��ǰ����");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("�� Ĩ�� �˻�");
				System.out.println("�� ���� �˻�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("�� INTEL");
					System.out.println("�� AMD");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						word = "INTEL";
						searchListMainboardChipset(word);
						cnt++;
						break;
					case 2:
						word = "AMD";
						searchListMainboardChipset(word);
						cnt++;
						break;
					}
					break;
				case 2:
					System.out.println("���� ������ �Է��ϼ���.");
					System.out.println("ex) 0 ~ 0,000,000�� // �Է� : 2ȸ(�ּ�, �ִ밪)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListMainboardPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# �����Ͻ� ��ǰ��ȣ�� �Է��ϼ���.");
				int selectNum = sc.nextInt();
				System.out.println("# �� ��ǰ�� �������� �߰��Ͻðڽ��ϱ�?");
				showMainboard(selectNum);
				System.out.println("�� ��");
				System.out.println("�� �ƴϿ�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# �����Ͻ� ��ǰ�� �������� �߰��߽��ϴ�.");
					String name = db.mainboardList.get(selectNum-1).getName();
					db.quote.setMbName(name);
					int number = db.mainboardList.get(selectNum-1).getPrice();
					db.quote.setMbPrice(number);
					
					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (db.mainboardList.size()-1); i > -1; i--) {
						db.mainboardList.remove(i);
					}
					choiceMainboard();
				}
				break;
			}
		}
	}
		
	public static void showMainboard(int num) {
		System.out.printf("������ : " + db.mainboardList.get(num-1).getCompany() + " / ");
		System.out.printf("��ǰ�� : " + db.mainboardList.get(num-1).getName() + " / ");
		System.out.printf("Ĩ�� : " + db.mainboardList.get(num-1).getChipset() + " / ");
		System.out.printf("�ִ�޸𸮿뷮 : " + db.mainboardList.get(num-1).getMaxmemory() + "GB / ");
		int price = db.mainboardList.get(num-1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
		}
	
	public static void searchListMainboardChipset(String searchWord) {
		
		for (int i = (db.mainboardList.size()-1); i > -1; i--) {
			String character = db.mainboardList.get(i).getChipset();
			if (character.contains(searchWord) == false) { db.mainboardList.remove(i); }}
		
		for (int i=0; i<db.mainboardList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.mainboardList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + db.mainboardList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + db.mainboardList.get(i).getChipset() + " / ");
			System.out.printf("�ִ�޸𸮿뷮 : " + db.mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = db.mainboardList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if(db.mainboardList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceMainboard();
		}
	}
	
	public static void searchListMainboardPrice(int min, int max) {

		for (int i = (db.mainboardList.size() - 1); i > -1; i--) {
			int number = db.mainboardList.get(i).getPrice();
			if (min > number || max < number) {
				db.mainboardList.remove(i);
			}
		}
		
		for (int i = 0; i < db.mainboardList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.mainboardList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + db.mainboardList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + db.mainboardList.get(i).getChipset() + " / ");
			System.out.printf("�ִ�޸𸮿뷮 : " + db.mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = db.mainboardList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (db.mainboardList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceMainboard();
		}
	}
	
	public static void choiceVGA() {
		cnt = 0;
		check = true;
		
		if (cnt == 0) {
			System.out.println("# VGA ��ǰ����Դϴ�. ");
			db.searchVGA();
			searchWhileVGA();
		} else if (cnt > 0) {
			searchWhileVGA();
		}
	}
	
	public static void searchWhileVGA() {
		while (check) {
			System.out.println("�� �����߰�");
			System.out.println("�� ��ǰ����");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("�� Ĩ�� �˻�");
				System.out.println("�� ���� �˻�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("�� GEFORCE");
					System.out.println("�� AMD");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						word = "GEFORCE";
						searchListVGAChipset(word);
						cnt++;
						break;
					case 2:
						word = "AMD";
						searchListVGAChipset(word);
						cnt++;
						break;
					}
					break;
				case 2:
					System.out.println("���� ������ �Է��ϼ���.");
					System.out.println("ex) 0 ~ 0,000,000�� // �Է� : 2ȸ(�ּ�, �ִ밪)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListVGAPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# �����Ͻ� ��ǰ��ȣ�� �Է��ϼ���.");
				int selectNum = sc.nextInt();
				System.out.println("# �� ��ǰ�� �������� �߰��Ͻðڽ��ϱ�?");
				showVGA(selectNum);
				System.out.println("�� ��");
				System.out.println("�� �ƴϿ�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# �����Ͻ� ��ǰ�� �������� �߰��߽��ϴ�.");
					String name = db.vgaList.get(selectNum-1).getName();
					db.quote.setVGAName(name);
					int number = db.vgaList.get(selectNum-1).getPrice();
					db.quote.setVGAPrice(number);
					
					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (db.vgaList.size()-1); i > -1; i--) {
						db.vgaList.remove(i);
					}
					choiceVGA();
				}
				break;
			}
		}
	}
		
	public static void showVGA(int num) {
		System.out.printf("������ : " + db.vgaList.get(num-1).getCompany() + " / ");
		System.out.printf("��ǰ�� : " + db.vgaList.get(num-1).getName() + " / ");
		System.out.printf("Ĩ�� : " + db.vgaList.get(num-1).getChipset() + " / ");
		System.out.printf("�޸𸮿뷮 : " + db.vgaList.get(num-1).getMemory() + "GB / ");
		int price = db.vgaList.get(num-1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
		}
	
	public static void searchListVGAChipset(String searchWord) {
		
		for (int i = (db.vgaList.size()-1); i > -1; i--) {
			String character = db.vgaList.get(i).getChipset();
			if (character.contains(searchWord) == false) { db.vgaList.remove(i); }}
		
		for (int i=0; i<db.vgaList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.vgaList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + db.vgaList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + db.vgaList.get(i).getChipset() + " / ");
			System.out.printf("�޸𸮿뷮 : " + db.vgaList.get(i).getMemory() + "GB / ");
			int price = db.vgaList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if(db.vgaList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceVGA();
		}
	}
	
	public static void searchListVGAPrice(int min, int max) {

		for (int i = (db.vgaList.size() - 1); i > -1; i--) {
			int number = db.vgaList.get(i).getPrice();
			if (min > number || max < number) {
				db.vgaList.remove(i);
			}
		}
		
		for (int i = 0; i < db.vgaList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.vgaList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + db.vgaList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + db.vgaList.get(i).getChipset() + " / ");
			System.out.printf("�޸𸮿뷮 : " + db.vgaList.get(i).getMemory() + "GB / ");
			int price = db.vgaList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (db.vgaList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceVGA();
		}
	}
	
	public static void choiceRAM() {
		cnt = 0;
		check = true;
		
		if (cnt == 0) {
			System.out.println("# RAM ��ǰ����Դϴ�. ");
			db.searchRAM();
			searchWhileRAM();
		} else if (cnt > 0) {
			searchWhileRAM();
		}
	}
	
	public static void searchWhileRAM() {
		while (check) {
			System.out.println("�� �����߰�");
			System.out.println("�� ��ǰ����");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("�� �뷮 �˻�");
				System.out.println("�� ���� �˻�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("�� 8GB");
					System.out.println("�� 16GB");
					System.out.println("�� 32GB");
					System.out.println("�� 64GB");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						word = "8";
						searchListRAMCapacity(word);
						cnt++;
						break;
					case 2:
						word = "16";
						searchListRAMCapacity(word);
						cnt++;
						break;
					case 3:
						word = "32";
						searchListRAMCapacity(word);
						cnt++;
						break;
					case 4:
						word = "64";
						searchListRAMCapacity(word);
						cnt++;
						break;
					}
					break;
				case 2:
					System.out.println("���� ������ �Է��ϼ���.");
					System.out.println("ex) 0 ~ 0,000,000�� // �Է� : 2ȸ(�ּ�, �ִ밪)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListRAMPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# �����Ͻ� ��ǰ��ȣ�� �Է��ϼ���.");
				int selectNum = sc.nextInt();
				System.out.println("# �� ��ǰ�� �������� �߰��Ͻðڽ��ϱ�?");
				showRAM(selectNum);
				System.out.println("�� ��");
				System.out.println("�� �ƴϿ�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# �����Ͻ� ��ǰ�� �������� �߰��߽��ϴ�.");

					String name = db.ramList.get(selectNum - 1).getName();
					db.quote.setRAMName(name);
					int number = db.ramList.get(selectNum - 1).getPrice();
					db.quote.setRAMPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (db.ramList.size() - 1); i > -1; i--) {
						db.ramList.remove(i);
					}
					choiceRAM();
					break;
				}
				break;
			}
		}
	}
		
	public static void showRAM(int num) {
		System.out.printf("������ : " + db.ramList.get(num-1).getCompany() + " / ");
		System.out.printf("�޸𸮿뷮 : " + db.ramList.get(num-1).getCapacity() + "GB / ");
		System.out.printf("Ŭ�� : " + db.ramList.get(num-1).getClock() + "Mhz / ");
		int price = db.ramList.get(num-1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
		}
	
	public static void searchListRAMCapacity(String searchWord) {
		
		for (int i = (db.ramList.size()-1); i > -1; i--) {
			String character = db.ramList.get(i).getCapacity();
			if (character.equals(searchWord) == false) { db.ramList.remove(i); }}
		
		for (int i=0; i<db.ramList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.ramList.get(i).getCompany() + " / ");
			System.out.printf("�޸𸮿뷮 : " + db.ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("Ŭ�� : " + db.ramList.get(i).getClock() + "Mhz / ");
			int price = db.ramList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if(db.ramList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceRAM();
		}
	}
	
	public static void searchListRAMPrice(int min, int max) {

		for (int i = (db.ramList.size() - 1); i > -1; i--) {
			int number = db.ramList.get(i).getPrice();
			if (min > number || max < number) {
				db.ramList.remove(i);
			}
		}
		
		for (int i = 0; i < db.ramList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.ramList.get(i).getCompany() + " / ");
			System.out.printf("�޸𸮿뷮 : " + db.ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("Ŭ�� : " + db.ramList.get(i).getClock() + "Mhz / ");
			int price = db.ramList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (db.ramList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceRAM();
		}
	}
	
	public static void choiceSSD() {
		cnt = 0;
		check = true;
		
		if (cnt == 0) {
			System.out.println("# SSD ��ǰ����Դϴ�. ");
			db.searchSSD();
			searchWhileSSD();
		} else if (cnt > 0) {
			searchWhileSSD();
		}
	}
	
	public static void searchWhileSSD() {
		while (check) {
			System.out.println("�� �����߰�");
			System.out.println("�� ��ǰ����");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("�� �뷮 �˻�");
				System.out.println("�� ���� �˻�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("�� 250GB");
					System.out.println("�� 500GB");
					System.out.println("�� 1TB");
					System.out.println("�� 2TB");
					System.out.println("�� 4TB");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						word = "250GB";
						searchListSSDCapacity(word);
						cnt++;
						break;
					case 2:
						word = "500GB";
						searchListSSDCapacity(word);
						cnt++;
						break;
					case 3:
						word = "1TB";
						searchListSSDCapacity(word);
						cnt++;
						break;
					case 4:
						word = "2TB";
						searchListSSDCapacity(word);
						cnt++;
						break;
					case 5:
						word = "4TB";
						searchListSSDCapacity(word);
						cnt++;
						break;
					}
					break;
				case 2:
					System.out.println("���� ������ �Է��ϼ���.");
					System.out.println("ex) 0 ~ 0,000,000�� // �Է� : 2ȸ(�ּ�, �ִ밪)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListSSDPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# �����Ͻ� ��ǰ��ȣ�� �Է��ϼ���.");
				int selectNum = sc.nextInt();
				System.out.println("# �� ��ǰ�� �������� �߰��Ͻðڽ��ϱ�?");
				showSSD(selectNum);
				System.out.println("�� ��");
				System.out.println("�� �ƴϿ�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# �����Ͻ� ��ǰ�� �������� �߰��߽��ϴ�.");
					
					String name = db.ssdList.get(selectNum-1).getName();
					db.quote.setSSDName(name);
					int number = db.ssdList.get(selectNum-1).getPrice();
					db.quote.setSSDPrice(number);
					
					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (db.ssdList.size()-1); i > -1; i--) {
						db.ssdList.remove(i);
					}
					choiceSSD();
				}
				break;
			}
		}
	}
		
	public static void showSSD(int num) {
		System.out.printf("������ : " + db.ssdList.get(num-1).getCompany() + " / ");
		System.out.printf("����뷮 : " + db.ssdList.get(num-1).getCapacity() + " / ");
		System.out.printf("����Ÿ�� : " + db.ssdList.get(num-1).getSSDType() + " / ");
		int price = db.ssdList.get(num-1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
		}
	
	public static void searchListSSDCapacity(String searchWord) {
		
		for (int i = (db.ssdList.size()-1); i > -1; i--) {
			String character = db.ssdList.get(i).getCapacity();
			if (character.equals(searchWord) == false) { db.ssdList.remove(i); }}
		
		for (int i=0; i<db.ssdList.size(); i++) {
			System.out.printf("������ : " + db.ssdList.get(i).getCompany() + " / ");
			System.out.printf("����뷮 : " + db.ssdList.get(i).getCapacity() + " / ");
			System.out.printf("����Ÿ�� : " + db.ssdList.get(i).getSSDType() + " / ");
			int price = db.ssdList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if(db.ssdList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceSSD();
		}
	}
	
	public static void searchListSSDPrice(int min, int max) {

		for (int i = (db.ssdList.size() - 1); i > -1; i--) {
			int number = db.ssdList.get(i).getPrice();
			if (min > number || max < number) {
				db.ssdList.remove(i);
			}
		}
		
		for (int i = 0; i < db.ssdList.size(); i++) {
			System.out.printf("(" + (i+1) + "��)" + " / ");
			System.out.printf("������ : " + db.ssdList.get(i).getCompany() + " / ");
			System.out.printf("����뷮 : " + db.ssdList.get(i).getCapacity() + " / ");
			System.out.printf("����Ÿ�� : " + db.ssdList.get(i).getSSDType() + " / ");
			int price = db.ssdList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (db.ssdList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceSSD();
		}
	}
}