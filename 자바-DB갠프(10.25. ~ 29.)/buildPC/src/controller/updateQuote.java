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
			System.out.println("# CPU 제품목록입니다. ");
			update.searchCPU();
			searchWhileCPU();
		} else if (cnt > 0) {
			searchWhileCPU();
		}
	}

	public static void searchWhileCPU() {
		while (check) {
			System.out.println("① 조건추가");
			System.out.println("② 제품선택");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("① 제조사 검색");
				System.out.println("② 가격 검색");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("① INTEL");
					System.out.println("② AMD");
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
					System.out.println("가격 범위를 입력하세요.");
					System.out.println("ex) 0 ~ 0,000,000원 // 입력 : 2회(최소, 최대값)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListCPUPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# 선택하실 제품번호를 입력하세요.");
				int selectNum = sc.nextInt();
				System.out.println("# 아래 제품으로 수정하시겠습니까?");
				showCPU(selectNum);
				System.out.println("① 예");
				System.out.println("② 아니오");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# 선택하신 제품으로 견적서가 수정되었습닏.");
					String name = update.cpuList.get(selectNum - 1).getName();
					int number = update.cpuList.get(selectNum - 1).getPrice();
					String quoteName = "";
					update.updateDbCPU(name, number, quoteName);

					check = false;
					break;
				case 2:
					System.out.println("# 제품을 다시 조회합니다.");
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
		System.out.printf("제조사 : " + update.cpuList.get(num - 1).getCompany() + " / ");
		System.out.printf("제품명 : " + update.cpuList.get(num - 1).getName() + " / ");
		System.out.printf("코어수 : " + update.cpuList.get(num - 1).getCore() + "개 / ");
		System.out.printf("기본클럭 : " + update.cpuList.get(num - 1).getMin() + "GHz / ");
		System.out.printf("최대클럭 : " + update.cpuList.get(num - 1).getMax() + "GHz / ");
		System.out.printf("내장그래픽 유무 : " + update.cpuList.get(num - 1).getInner() + " / ");
		int price = update.cpuList.get(num - 1).getPrice();
		System.out.println("가격 : " + DF.format(price) + "원");
	}

	public static void searchListCPUCompany(String searchWord) {

		for (int i = (update.cpuList.size() - 1); i > -1; i--) {
			String character = update.cpuList.get(i).getCompany();
			if (character.contains(searchWord) == false) {
				update.cpuList.remove(i);
			}
		}

		for (int i = 0; i < update.cpuList.size(); i++) {
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("제조사 : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("제품명 : " + update.cpuList.get(i).getName() + " / ");
			System.out.printf("코어수 : " + update.cpuList.get(i).getCore() + "개 / ");
			System.out.printf("기본클럭 : " + update.cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("최대클럭 : " + update.cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("내장그래픽 유무 : " + update.cpuList.get(i).getInner() + " / ");
			int price = update.cpuList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.cpuList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
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
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("제조사 : " + update.cpuList.get(i).getCompany() + " / ");
			System.out.printf("제품명 : " + update.cpuList.get(i).getName() + " / ");
			System.out.printf("코어수 : " + update.cpuList.get(i).getCore() + "개 / ");
			System.out.printf("기본클럭 : " + update.cpuList.get(i).getMin() + "GHz / ");
			System.out.printf("최대클럭 : " + update.cpuList.get(i).getMax() + "GHz / ");
			System.out.printf("내장그래픽 유무 : " + update.cpuList.get(i).getInner() + " / ");
			int price = update.cpuList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.cpuList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
			System.out.println(" ");
			choiceCPU();
		}
	}

	public static void choiceMainboard() {
		cnt = 0;
		check = true;

		if (cnt == 0) {
			System.out.println("# MAINBOARD 제품목록입니다. ");
			update.searchMainboard();
			searchWhileMainboard();
		} else if (cnt > 0) {
			searchWhileMainboard();
		}
	}

	public static void searchWhileMainboard() {
		while (check) {
			System.out.println("① 조건추가");
			System.out.println("② 제품선택");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("① 칩셋 검색");
				System.out.println("② 가격 검색");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("① INTEL");
					System.out.println("② AMD");
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
					System.out.println("가격 범위를 입력하세요.");
					System.out.println("ex) 0 ~ 0,000,000원 // 입력 : 2회(최소, 최대값)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListMainboardPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# 선택하실 제품번호를 입력하세요.");
				int selectNum = sc.nextInt();
				System.out.println("# 위 제품을 견적서에 추가하시겠습니까?");
				showMainboard(selectNum);
				System.out.println("① 예");
				System.out.println("② 아니오");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# 선택하신 제품을 견적서에 추가했습니다.");
					String name = update.mainboardList.get(selectNum - 1).getName();
					update.quote.setMbName(name);
					int number = update.mainboardList.get(selectNum - 1).getPrice();
					update.quote.setMbPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# 제품을 다시 조회합니다.");
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
		System.out.printf("제조사 : " + update.mainboardList.get(num - 1).getCompany() + " / ");
		System.out.printf("제품명 : " + update.mainboardList.get(num - 1).getName() + " / ");
		System.out.printf("칩셋 : " + update.mainboardList.get(num - 1).getChipset() + " / ");
		System.out.printf("최대메모리용량 : " + update.mainboardList.get(num - 1).getMaxmemory() + "GB / ");
		int price = update.mainboardList.get(num - 1).getPrice();
		System.out.println("가격 : " + DF.format(price) + "원");
	}

	public static void searchListMainboardChipset(String searchWord) {

		for (int i = (update.mainboardList.size() - 1); i > -1; i--) {
			String character = update.mainboardList.get(i).getChipset();
			if (character.contains(searchWord) == false) {
				update.mainboardList.remove(i);
			}
		}

		for (int i = 0; i < update.mainboardList.size(); i++) {
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.mainboardList.get(i).getCompany() + " / ");
			System.out.printf("제품명 : " + update.mainboardList.get(i).getName() + " / ");
			System.out.printf("칩셋 : " + update.mainboardList.get(i).getChipset() + " / ");
			System.out.printf("최대메모리용량 : " + update.mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = update.mainboardList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.mainboardList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
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
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.mainboardList.get(i).getCompany() + " / ");
			System.out.printf("제품명 : " + update.mainboardList.get(i).getName() + " / ");
			System.out.printf("칩셋 : " + update.mainboardList.get(i).getChipset() + " / ");
			System.out.printf("최대메모리용량 : " + update.mainboardList.get(i).getMaxmemory() + "GB / ");
			int price = update.mainboardList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.mainboardList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
			System.out.println(" ");
			choiceMainboard();
		}
	}

	public static void choiceVGA() {
		cnt = 0;
		check = true;

		if (cnt == 0) {
			System.out.println("# VGA 제품목록입니다. ");
			update.searchVGA();
			searchWhileVGA();
		} else if (cnt > 0) {
			searchWhileVGA();
		}
	}

	public static void searchWhileVGA() {
		while (check) {
			System.out.println("① 조건추가");
			System.out.println("② 제품선택");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("① 칩셋 검색");
				System.out.println("② 가격 검색");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("① GEFORCE");
					System.out.println("② AMD");
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
					System.out.println("가격 범위를 입력하세요.");
					System.out.println("ex) 0 ~ 0,000,000원 // 입력 : 2회(최소, 최대값)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListVGAPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# 선택하실 제품번호를 입력하세요.");
				int selectNum = sc.nextInt();
				System.out.println("# 위 제품을 견적서에 추가하시겠습니까?");
				showVGA(selectNum);
				System.out.println("① 예");
				System.out.println("② 아니오");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# 선택하신 제품을 견적서에 추가했습니다.");
					String name = update.vgaList.get(selectNum - 1).getName();
					update.quote.setVGAName(name);
					int number = update.vgaList.get(selectNum - 1).getPrice();
					update.quote.setVGAPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# 제품을 다시 조회합니다.");
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
		System.out.printf("제조사 : " + update.vgaList.get(num - 1).getCompany() + " / ");
		System.out.printf("제품명 : " + update.vgaList.get(num - 1).getName() + " / ");
		System.out.printf("칩셋 : " + update.vgaList.get(num - 1).getChipset() + " / ");
		System.out.printf("메모리용량 : " + update.vgaList.get(num - 1).getMemory() + "GB / ");
		int price = update.vgaList.get(num - 1).getPrice();
		System.out.println("가격 : " + DF.format(price) + "원");
	}

	public static void searchListVGAChipset(String searchWord) {

		for (int i = (update.vgaList.size() - 1); i > -1; i--) {
			String character = update.vgaList.get(i).getChipset();
			if (character.contains(searchWord) == false) {
				update.vgaList.remove(i);
			}
		}

		for (int i = 0; i < update.vgaList.size(); i++) {
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.vgaList.get(i).getCompany() + " / ");
			System.out.printf("제품명 : " + update.vgaList.get(i).getName() + " / ");
			System.out.printf("칩셋 : " + update.vgaList.get(i).getChipset() + " / ");
			System.out.printf("메모리용량 : " + update.vgaList.get(i).getMemory() + "GB / ");
			int price = update.vgaList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.vgaList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
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
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.vgaList.get(i).getCompany() + " / ");
			System.out.printf("제품명 : " + update.vgaList.get(i).getName() + " / ");
			System.out.printf("칩셋 : " + update.vgaList.get(i).getChipset() + " / ");
			System.out.printf("메모리용량 : " + update.vgaList.get(i).getMemory() + "GB / ");
			int price = update.vgaList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.vgaList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
			System.out.println(" ");
			choiceVGA();
		}
	}

	public static void choiceRAM() {
		cnt = 0;
		check = true;

		if (cnt == 0) {
			System.out.println("# RAM 제품목록입니다. ");
			update.searchRAM();
			searchWhileRAM();
		} else if (cnt > 0) {
			searchWhileRAM();
		}
	}

	public static void searchWhileRAM() {
		while (check) {
			System.out.println("① 조건추가");
			System.out.println("② 제품선택");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("① 용량 검색");
				System.out.println("② 가격 검색");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("① 8GB");
					System.out.println("② 16GB");
					System.out.println("③ 32GB");
					System.out.println("④ 64GB");
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
					System.out.println("가격 범위를 입력하세요.");
					System.out.println("ex) 0 ~ 0,000,000원 // 입력 : 2회(최소, 최대값)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListRAMPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# 선택하실 제품번호를 입력하세요.");
				int selectNum = sc.nextInt();
				System.out.println("# 위 제품을 견적서에 추가하시겠습니까?");
				showRAM(selectNum);
				System.out.println("① 예");
				System.out.println("② 아니오");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# 선택하신 제품을 견적서에 추가했습니다.");

					String name = update.ramList.get(selectNum - 1).getName();
					update.quote.setRAMName(name);
					int number = update.ramList.get(selectNum - 1).getPrice();
					update.quote.setRAMPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# 제품을 다시 조회합니다.");
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
		System.out.printf("제조사 : " + update.ramList.get(num - 1).getCompany() + " / ");
		System.out.printf("메모리용량 : " + update.ramList.get(num - 1).getCapacity() + "GB / ");
		System.out.printf("클럭 : " + update.ramList.get(num - 1).getClock() + "Mhz / ");
		int price = update.ramList.get(num - 1).getPrice();
		System.out.println("가격 : " + DF.format(price) + "원");
	}

	public static void searchListRAMCapacity(String searchWord) {

		for (int i = (update.ramList.size() - 1); i > -1; i--) {
			String character = update.ramList.get(i).getCapacity();
			if (character.equals(searchWord) == false) {
				update.ramList.remove(i);
			}
		}

		for (int i = 0; i < update.ramList.size(); i++) {
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.ramList.get(i).getCompany() + " / ");
			System.out.printf("메모리용량 : " + update.ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("클럭 : " + update.ramList.get(i).getClock() + "Mhz / ");
			int price = update.ramList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.ramList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
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
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.ramList.get(i).getCompany() + " / ");
			System.out.printf("메모리용량 : " + update.ramList.get(i).getCapacity() + "GB / ");
			System.out.printf("클럭 : " + update.ramList.get(i).getClock() + "Mhz / ");
			int price = update.ramList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.ramList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
			System.out.println(" ");
			choiceRAM();
		}
	}

	public static void choiceSSD() {
		cnt = 0;
		check = true;

		if (cnt == 0) {
			System.out.println("# SSD 제품목록입니다. ");
			update.searchSSD();
			searchWhileSSD();
		} else if (cnt > 0) {
			searchWhileSSD();
		}
	}

	public static void searchWhileSSD() {
		while (check) {
			System.out.println("① 조건추가");
			System.out.println("② 제품선택");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("① 용량 검색");
				System.out.println("② 가격 검색");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("① 250GB");
					System.out.println("② 500GB");
					System.out.println("③ 1TB");
					System.out.println("④ 2TB");
					System.out.println("⑤ 4TB");
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
					System.out.println("가격 범위를 입력하세요.");
					System.out.println("ex) 0 ~ 0,000,000원 // 입력 : 2회(최소, 최대값)");
					min = sc.nextInt();
					max = sc.nextInt();
					searchListSSDPrice(min, max);
					break;
				}
				break;
			case 2:
				System.out.println("# 선택하실 제품번호를 입력하세요.");
				int selectNum = sc.nextInt();
				System.out.println("# 위 제품을 견적서에 추가하시겠습니까?");
				showSSD(selectNum);
				System.out.println("① 예");
				System.out.println("② 아니오");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("# 선택하신 제품을 견적서에 추가했습니다.");

					String name = update.ssdList.get(selectNum - 1).getName();
					update.quote.setSSDName(name);
					int number = update.ssdList.get(selectNum - 1).getPrice();
					update.quote.setSSDPrice(number);

					check = false;
					break;
				case 2:
					System.out.println("# 제품을 다시 조회합니다.");
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
		System.out.printf("제조사 : " + update.ssdList.get(num - 1).getCompany() + " / ");
		System.out.printf("저장용량 : " + update.ssdList.get(num - 1).getCapacity() + " / ");
		System.out.printf("저장타입 : " + update.ssdList.get(num - 1).getSSDType() + " / ");
		int price = update.ssdList.get(num - 1).getPrice();
		System.out.println("가격 : " + DF.format(price) + "원");
	}

	public static void searchListSSDCapacity(String searchWord) {

		for (int i = (update.ssdList.size() - 1); i > -1; i--) {
			String character = update.ssdList.get(i).getCapacity();
			if (character.equals(searchWord) == false) {
				update.ssdList.remove(i);
			}
		}

		for (int i = 0; i < update.ssdList.size(); i++) {
			System.out.printf("제조사 : " + update.ssdList.get(i).getCompany() + " / ");
			System.out.printf("저장용량 : " + update.ssdList.get(i).getCapacity() + " / ");
			System.out.printf("저장타입 : " + update.ssdList.get(i).getSSDType() + " / ");
			int price = update.ssdList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.ssdList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
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
			System.out.printf("(" + (i + 1) + "번)" + " / ");
			System.out.printf("제조사 : " + update.ssdList.get(i).getCompany() + " / ");
			System.out.printf("저장용량 : " + update.ssdList.get(i).getCapacity() + " / ");
			System.out.printf("저장타입 : " + update.ssdList.get(i).getSSDType() + " / ");
			int price = update.ssdList.get(i).getPrice();
			System.out.println("가격 : " + DF.format(price) + "원");
		}
		System.out.println(" ");
		if (update.ssdList.isEmpty() == true) {
			System.out.println("# 검색 정보가 없습니다. 다시 조회합니다.");
			System.out.println(" ");
			choiceSSD();
		}
	}
	
	public static void inquiryQuote() {
		quoteChoice = sc.nextInt();
		
		System.out.println("# 견적서 명 : 사무");
		System.out.printf("CPU : " + update.quoteList.get(quoteChoice-1).getCPUName() + " | ");
		int cpuPrice = update.quoteList.get(quoteChoice-1).getCPUPrice();
		System.out.println("가격 : " + DF.format(cpuPrice) + "원");
		System.out.printf("MAINBOARD : " + update.quoteList.get(quoteChoice-1).getMbName() + " | ");
		int mbPrice = update.quoteList.get(quoteChoice-1).getMbPrice();
		System.out.println("가격 : " + DF.format(mbPrice) + "원");
		System.out.printf("VGA : " + update.quoteList.get(quoteChoice-1).getVGAName() + " | ");
		int vgaPrice = update.quoteList.get(quoteChoice-1).getVGAPrice();
		System.out.println("가격 : " + DF.format(vgaPrice) + "원");
		System.out.printf("RAM : " + update.quoteList.get(quoteChoice-1).getRAMName() + " | ");
		int ramPrice = update.quoteList.get(quoteChoice-1).getRAMPrice();
		System.out.println("가격 : " + DF.format(ramPrice) + "원");
		System.out.printf("SSD : " + update.quoteList.get(quoteChoice-1).getSSDName() + " | ");
		int ssdPrice = update.quoteList.get(quoteChoice-1).getSSDPrice();
		System.out.println("가격 : " + DF.format(ssdPrice) + "원");
		System.out.println("총 금액 : " + DF.format(cpuPrice + mbPrice + vgaPrice + ramPrice + ssdPrice) + "원");
	}
}
