package controller;

import java.text.DecimalFormat;
import java.util.Scanner;

import dao.DB_Connection;

public class updateQuote {
	public static DB_Connection update = new DB_Connection();
	static int choice;
	static int quoteChoice;
	static int cnt;
	static int min;
	static int max;
	static boolean check;
	static String word;
	static Scanner sc = new Scanner(System.in);
	static DecimalFormat DF = new DecimalFormat("###,###");

	public static void updateCPU() {
		cnt = 0;
		check = true;

		if (cnt == 0) {
			System.out.println("# CPU ��ǰ����Դϴ�. ");
			update.searchCPU();
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
				System.out.println("# �Ʒ� ��ǰ���� �����Ͻðڽ��ϱ�?");
				showCPU(selectNum);
				System.out.println("�� ��");
				System.out.println("�� �ƴϿ�");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# �����Ͻ� ��ǰ���� �������� �����Ǿ�����.");
					String name = update.cpuList.get(selectNum - 1).getName();
					int number = update.cpuList.get(selectNum - 1).getPrice();
					String quoteName = "";
					update.updateDbCPU(name, number, quoteName);

					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (update.cpuList.size() - 1); i > -1; i--) {
						update.cpuList.remove(i);
					}
					updateCPU();
					break;
				}
				break;
			}
		}
	}

	public static void showCPU(int num) {
		System.out.printf("������ : " + update.cpuList.get(num - 1).getCompany() + " / ");
		System.out.printf("��ǰ�� : " + update.cpuList.get(num - 1).getName() + " / ");
		System.out.printf("�ھ�� : " + update.cpuList.get(num - 1).getCore() + "�� / ");
		System.out.printf("�⺻Ŭ�� : " + update.cpuList.get(num - 1).getMin() + "GHz / ");
		System.out.printf("�ִ�Ŭ�� : " + update.cpuList.get(num - 1).getMax() + "GHz / ");
		System.out.printf("����׷��� ���� : " + update.cpuList.get(num - 1).getInner() + " / ");
		int price = update.cpuList.get(num - 1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
	}

	public static void searchListCPUCompany(String searchWord) {

		for (int i = (update.cpuList.size() - 1); i > -1; i--) {
			String character = update.cpuList.get(i).getCompany();
			if (character.contains(searchWord) == false) {
				update.cpuList.remove(i);
			}
		}

		for (int i = 0; i < update.cpuList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("������ : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + update.cpuList.get(i).getName() + " / ");
			System.out.printf("�ھ�� : " + update.cpuList.get(i).getCore() + "�� / ");
			System.out.printf("�⺻Ŭ�� : " + update.cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("�ִ�Ŭ�� : " + update.cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("����׷��� ���� : " + update.cpuList.get(i).getInner() + " / ");
			int price = update.cpuList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.cpuList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			updateCPU();
		}
	}

	public static void searchListCPUPrice(int min, int max) {

		for (int i = (update.cpuList.size() - 1); i > -1; i--) {
			int number = update.cpuList.get(i).getPrice();
			if (min > number || max < number) {
				update.cpuList.remove(i);
			}
		}

		for (int i = 0; i < update.cpuList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("������ : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + update.cpuList.get(i).getName() + " / ");
			System.out.printf("�ھ�� : " + update.cpuList.get(i).getCore() + "�� / ");
			System.out.printf("�⺻Ŭ�� : " + update.cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("�ִ�Ŭ�� : " + update.cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("����׷��� ���� : " + update.cpuList.get(i).getInner() + " / ");
			int price = update.cpuList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.cpuList.isEmpty() == true) {
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
			update.searchMainboard();
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
					String name = update.mainboardList.get(selectNum - 1).getName();
					update.quote.setMbName(name);
					int number = update.mainboardList.get(selectNum - 1).getPrice();
					update.quote.setMbPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (update.mainboardList.size() - 1); i > -1; i--) {
						update.mainboardList.remove(i);
					}
					choiceMainboard();
				}
				break;
			}
		}
	}

	public static void showMainboard(int num) {
		System.out.printf("������ : " + update.mainboardList.get(num - 1).getCompany() + " / ");
		System.out.printf("��ǰ�� : " + update.mainboardList.get(num - 1).getName() + " / ");
		System.out.printf("Ĩ�� : " + update.mainboardList.get(num - 1).getChipset() + " / ");
		System.out.printf("�ִ�޸𸮿뷮 : " + update.mainboardList.get(num - 1).getMaxmemory() + "GB / ");
		int price = update.mainboardList.get(num - 1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
	}

	public static void searchListMainboardChipset(String searchWord) {

		for (int i = (update.mainboardList.size() - 1); i > -1; i--) {
			String character = update.mainboardList.get(i).getChipset();
			if (character.contains(searchWord) == false) {
				update.mainboardList.remove(i);
			}
		}

		for (int i = 0; i < update.mainboardList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.mainboardList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + update.mainboardList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + update.mainboardList.get(i).getChipset() + " / ");
			System.out.printf("�ִ�޸𸮿뷮 : " + update.mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = update.mainboardList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.mainboardList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceMainboard();
		}
	}

	public static void searchListMainboardPrice(int min, int max) {

		for (int i = (update.mainboardList.size() - 1); i > -1; i--) {
			int number = update.mainboardList.get(i).getPrice();
			if (min > number || max < number) {
				update.mainboardList.remove(i);
			}
		}

		for (int i = 0; i < update.mainboardList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.mainboardList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + update.mainboardList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + update.mainboardList.get(i).getChipset() + " / ");
			System.out.printf("�ִ�޸𸮿뷮 : " + update.mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = update.mainboardList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.mainboardList.isEmpty() == true) {
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
			update.searchVGA();
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
					String name = update.vgaList.get(selectNum - 1).getName();
					update.quote.setVGAName(name);
					int number = update.vgaList.get(selectNum - 1).getPrice();
					update.quote.setVGAPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (update.vgaList.size() - 1); i > -1; i--) {
						update.vgaList.remove(i);
					}
					choiceVGA();
				}
				break;
			}
		}
	}

	public static void showVGA(int num) {
		System.out.printf("������ : " + update.vgaList.get(num - 1).getCompany() + " / ");
		System.out.printf("��ǰ�� : " + update.vgaList.get(num - 1).getName() + " / ");
		System.out.printf("Ĩ�� : " + update.vgaList.get(num - 1).getChipset() + " / ");
		System.out.printf("�޸𸮿뷮 : " + update.vgaList.get(num - 1).getMemory() + "GB / ");
		int price = update.vgaList.get(num - 1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
	}

	public static void searchListVGAChipset(String searchWord) {

		for (int i = (update.vgaList.size() - 1); i > -1; i--) {
			String character = update.vgaList.get(i).getChipset();
			if (character.contains(searchWord) == false) {
				update.vgaList.remove(i);
			}
		}

		for (int i = 0; i < update.vgaList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.vgaList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + update.vgaList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + update.vgaList.get(i).getChipset() + " / ");
			System.out.printf("�޸𸮿뷮 : " + update.vgaList.get(i).getMemory() + "GB / ");
			int price = update.vgaList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.vgaList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceVGA();
		}
	}

	public static void searchListVGAPrice(int min, int max) {

		for (int i = (update.vgaList.size() - 1); i > -1; i--) {
			int number = update.vgaList.get(i).getPrice();
			if (min > number || max < number) {
				update.vgaList.remove(i);
			}
		}

		for (int i = 0; i < update.vgaList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.vgaList.get(i).getCompany() + " / ");
			System.out.printf("��ǰ�� : " + update.vgaList.get(i).getName() + " / ");
			System.out.printf("Ĩ�� : " + update.vgaList.get(i).getChipset() + " / ");
			System.out.printf("�޸𸮿뷮 : " + update.vgaList.get(i).getMemory() + "GB / ");
			int price = update.vgaList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.vgaList.isEmpty() == true) {
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
			update.searchRAM();
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

					String name = update.ramList.get(selectNum - 1).getName();
					update.quote.setRAMName(name);
					int number = update.ramList.get(selectNum - 1).getPrice();
					update.quote.setRAMPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (update.ramList.size() - 1); i > -1; i--) {
						update.ramList.remove(i);
					}
					choiceRAM();
					break;
				}
				break;
			}
		}
	}

	public static void showRAM(int num) {
		System.out.printf("������ : " + update.ramList.get(num - 1).getCompany() + " / ");
		System.out.printf("�޸𸮿뷮 : " + update.ramList.get(num - 1).getCapacity() + "GB / ");
		System.out.printf("Ŭ�� : " + update.ramList.get(num - 1).getClock() + "Mhz / ");
		int price = update.ramList.get(num - 1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
	}

	public static void searchListRAMCapacity(String searchWord) {

		for (int i = (update.ramList.size() - 1); i > -1; i--) {
			String character = update.ramList.get(i).getCapacity();
			if (character.equals(searchWord) == false) {
				update.ramList.remove(i);
			}
		}

		for (int i = 0; i < update.ramList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.ramList.get(i).getCompany() + " / ");
			System.out.printf("�޸𸮿뷮 : " + update.ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("Ŭ�� : " + update.ramList.get(i).getClock() + "Mhz / ");
			int price = update.ramList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.ramList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceRAM();
		}
	}

	public static void searchListRAMPrice(int min, int max) {

		for (int i = (update.ramList.size() - 1); i > -1; i--) {
			int number = update.ramList.get(i).getPrice();
			if (min > number || max < number) {
				update.ramList.remove(i);
			}
		}

		for (int i = 0; i < update.ramList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.ramList.get(i).getCompany() + " / ");
			System.out.printf("�޸𸮿뷮 : " + update.ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("Ŭ�� : " + update.ramList.get(i).getClock() + "Mhz / ");
			int price = update.ramList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.ramList.isEmpty() == true) {
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
			update.searchSSD();
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

					String name = update.ssdList.get(selectNum - 1).getName();
					update.quote.setSSDName(name);
					int number = update.ssdList.get(selectNum - 1).getPrice();
					update.quote.setSSDPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# ��ǰ�� �ٽ� ��ȸ�մϴ�.");
					for (int i = (update.ssdList.size() - 1); i > -1; i--) {
						update.ssdList.remove(i);
					}
					choiceSSD();
				}
				break;
			}
		}
	}

	public static void showSSD(int num) {
		System.out.printf("������ : " + update.ssdList.get(num - 1).getCompany() + " / ");
		System.out.printf("����뷮 : " + update.ssdList.get(num - 1).getCapacity() + " / ");
		System.out.printf("����Ÿ�� : " + update.ssdList.get(num - 1).getSSDType() + " / ");
		int price = update.ssdList.get(num - 1).getPrice();
		System.out.println("���� : " + DF.format(price) + "��");
	}

	public static void searchListSSDCapacity(String searchWord) {

		for (int i = (update.ssdList.size() - 1); i > -1; i--) {
			String character = update.ssdList.get(i).getCapacity();
			if (character.equals(searchWord) == false) {
				update.ssdList.remove(i);
			}
		}

		for (int i = 0; i < update.ssdList.size(); i++) {
			System.out.printf("������ : " + update.ssdList.get(i).getCompany() + " / ");
			System.out.printf("����뷮 : " + update.ssdList.get(i).getCapacity() + " / ");
			System.out.printf("����Ÿ�� : " + update.ssdList.get(i).getSSDType() + " / ");
			int price = update.ssdList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.ssdList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceSSD();
		}
	}

	public static void searchListSSDPrice(int min, int max) {

		for (int i = (update.ssdList.size() - 1); i > -1; i--) {
			int number = update.ssdList.get(i).getPrice();
			if (min > number || max < number) {
				update.ssdList.remove(i);
			}
		}

		for (int i = 0; i < update.ssdList.size(); i++) {
			System.out.printf("(" + (i + 1) + "��)" + " / ");
			System.out.printf("������ : " + update.ssdList.get(i).getCompany() + " / ");
			System.out.printf("����뷮 : " + update.ssdList.get(i).getCapacity() + " / ");
			System.out.printf("����Ÿ�� : " + update.ssdList.get(i).getSSDType() + " / ");
			int price = update.ssdList.get(i).getPrice();
			System.out.println("���� : " + DF.format(price) + "��");
		}
		System.out.println(" ");
		if (update.ssdList.isEmpty() == true) {
			System.out.println("# �˻� ������ �����ϴ�. �ٽ� ��ȸ�մϴ�.");
			System.out.println(" ");
			choiceSSD();
		}
	}
	
	public static void inquiryQuote() {
		quoteChoice = sc.nextInt();
		
		System.out.println("# ������ �� : �繫");
		System.out.printf("CPU : " + update.quoteList.get(quoteChoice-1).getCPUName() + " | ");
		int cpuPrice = update.quoteList.get(quoteChoice-1).getCPUPrice();
		System.out.println("���� : " + DF.format(cpuPrice) + "��");
		System.out.printf("MAINBOARD : " + update.quoteList.get(quoteChoice-1).getMbName() + " | ");
		int mbPrice = update.quoteList.get(quoteChoice-1).getMbPrice();
		System.out.println("���� : " + DF.format(mbPrice) + "��");
		System.out.printf("VGA : " + update.quoteList.get(quoteChoice-1).getVGAName() + " | ");
		int vgaPrice = update.quoteList.get(quoteChoice-1).getVGAPrice();
		System.out.println("���� : " + DF.format(vgaPrice) + "��");
		System.out.printf("RAM : " + update.quoteList.get(quoteChoice-1).getRAMName() + " | ");
		int ramPrice = update.quoteList.get(quoteChoice-1).getRAMPrice();
		System.out.println("���� : " + DF.format(ramPrice) + "��");
		System.out.printf("SSD : " + update.quoteList.get(quoteChoice-1).getSSDName() + " | ");
		int ssdPrice = update.quoteList.get(quoteChoice-1).getSSDPrice();
		System.out.println("���� : " + DF.format(ssdPrice) + "��");
		System.out.println("�� �ݾ� : " + DF.format(cpuPrice + mbPrice + vgaPrice + ramPrice + ssdPrice) + "��");
	}
}
