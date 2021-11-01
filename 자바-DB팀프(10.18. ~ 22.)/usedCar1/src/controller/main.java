package controller;

import java.util.ArrayList;
import java.util.Scanner;
import dao.DB_Connection;
import dto.usedCarVo;
import service.usedCarService;

public class main {
	
	
	public static void main(String[] args) {
		menuWhile();
	}
	
	public static void menuWhile() {
		int choice = 0;
		String car_number;
		String wishbuyuser_name;
		String phone_num;
		String car_name;
		Double made_year;
		String wishSellUser_name;
		int dis_driven;
		usedCarService ucs = new usedCarService();
		DB_Connection db = new DB_Connection();
		managementClass mClass = new managementClass();
		boolean login = false;
		
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			choice = sc.nextInt();
			if (choice == 1) {
				userMenu2();
				choice = sc.nextInt();
				if (choice == 1) {
					search();
					break;
				} else if (choice == 2) {
					System.out.print("# �����Ϸ��� ���� ��ȣ�� �Է��ϼ��� : \n");
					System.out.print("# ����)57��1234 \n");
					car_number=sc.next();
					db.SearchCar(car_number);
					System.out.print("\n");
					System.out.print("# �����Ͻ÷��� ���� ������ �½��ϱ�?");
					System.out.print("1. ��  / 2. �ƴϿ�");
					
					choice = sc.nextInt();	
					if(choice == 1){
					System.out.print("�̸� : \n");
					wishbuyuser_name=sc.next();
					System.out.print("ex) 010-0000-0000 \n");
					System.out.print("��ȭ��ȣ : \n");
					phone_num=sc.next();
					db.insertwishBuyList(car_number,wishbuyuser_name,phone_num);
					
					System.out.print("# �̿��� �ּż� �����մϴ�. ���� ���� ���� ����ڰ� Ȯ�� �� �����帮�ڽ��ϴ�. \n");
					break;
					}
					else if(choice == 2){
						menuWhile();
				}
				} else if (choice == 3) {
					menuWhile();
				}
			} else if (choice == 2) {
				System.out.print("# �Ǹ������� ������ �Է��ϼ���. \n");
				System.out.print("ex) 26��3441 \n");
				System.out.print("1. �Ǹ����� ��ȣ : \n");
				car_number=sc.next();
				System.out.print("2. ������ : \n");
				System.out.print("ex) �Ÿ, �ƹݶ� ... \n");
				car_name=sc.next();
				System.out.print("3. ���� : \n");
				System.out.print("ex) ���� : 0000���� \n");
				made_year=sc.nextDouble();
				System.out.print("4. ����Ÿ� : \n");
				System.out.print("ex) ���� : 000,000Km // �ش��ϴ� ���ڸ�ǥ�� \n");
				dis_driven=sc.nextInt();
				System.out.print("5. �Ǹ����̸� : \n");
				wishSellUser_name=sc.next();
				System.out.print("6. �Ǹ��� ����ó: \n");
				System.out.print("ex) 010-0000-0000 \n");
				phone_num=sc.next();
				
				System.out.print("# �Է��Ͻ� ������ ��ġ�մϱ�? \n");
				System.out.print("1. �� / 2. �ƴϿ�\n");	
				System.out.print("=====================\n");
				System.out.println(car_number  );
				System.out.println(car_name  );
				System.out.println(made_year+"��");
				System.out.println(dis_driven+"Km");
				System.out.println(wishSellUser_name);
				System.out.println(phone_num  );
				System.out.print("=====================\n");
				
				
				
				choice = sc.nextInt();	
				if(choice == 1){
					db.insertwishSellList(car_number, car_name, made_year, dis_driven, wishSellUser_name, phone_num);
					System.out.print("# �̿��� �ּż� �����մϴ�. ���� ���� ���� ����ڰ� Ȯ�� �� �����帮�ڽ��ϴ�. \n");
					break;
					
				}
				else if(choice == 2){
					menuWhile();
				}
				
				
				
			} else if (choice == 3) {
				if(login==false) {
					login=ucs.login(login);
					mClass.Menu();
				}else if(login==true){
					System.out.println("# �α��� �Ϸ�");
					mClass.Menu();
				}
			}  else if (choice == 4) {
				break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("# �߰����� ȣī");
		System.out.println("1. �������");
		System.out.println("2. �����ȱ�");
		System.out.println("3. �����ڷα���");
		System.out.println("4. ���α׷� ����");
	}
	
	public static void userMenu1() {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			userMenu2();
			choice = sc.nextInt();
			if (choice == 1) {
				search();
			} else if (choice == 2) {
			} else if (choice == 3) {
			} 
		}
	}
	
	public static void userMenu2() {
		System.out.println("1. �����˻�");
		System.out.println("2. ��������");
		System.out.println("3. �ڷΰ���");
	}
	
	public static void search() {
		DB_Connection db = new DB_Connection();
		ArrayList<usedCarVo> arrayListCar;
		
		int choice = 0;
		int searchNum = 0;
		int min, max = 0;
		int cnt = 0;
		String searchWord = "";

		Scanner sc = new Scanner(System.in);

		while (true) {
			if(cnt == 0) {
			System.out.println("# �˻������� �����ϼ���.");
			} else {
				System.out.println("# �˻� �߰������� �����ϼ���.");
			}
			System.out.println("1. ��������");
			System.out.println("2. �𵨸�");
			System.out.println("3. ������");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.println("6. ����Ÿ�");
			System.out.println("7. ����");
			System.out.println("8. ����");
			System.out.println("9. �˻�����");
			choice = sc.nextInt();

			if (cnt == 0) {

				switch (choice) {
				case 1: // �������� �˻�
					System.out.println("# ���������� �����ϼ���.");
					System.out.println("1. ����");
					System.out.println("2. SUV");
					System.out.println("3. ������");
					System.out.println("4. ����");
					System.out.println("5. ����");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "����";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "SUV";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "������";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "����";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "����";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					}
					break;
				case 2: // �𵨸� �˻�
					System.out.println("# �𵨸��� �Է��ϼ���.");
					System.out.println("ex) �Ÿ, �ƹݶ�, �׷��� �� // ��ҹ��ڸ� �����մϴ�.");
					searchWord = sc.next();
					db.searchByName(searchWord);
					cnt++;
					break;
				case 3: // ������ �˻�
					System.out.println("# �����縦 �����ϼ���.");
					System.out.println("1. ����");
					System.out.println("2. ���");
					System.out.println("3. ������");
					System.out.println("4. �Ｚ");
					System.out.println("5. �ֿ�");
					System.out.println("6. ���׽ý�");
					System.out.println("7. ����");
					System.out.println("8. BMW");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "����";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "���";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "������";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "�Ｚ";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "�ֿ�";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "���׽ý�";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 7:
						searchWord = "����";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 8:
						searchWord = "BMW";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					}
					break;
				case 4: // ���� �˻�
					System.out.println("# ���� ������ �Է��ϼ���.");
					System.out.println("���� : 0 ~ 99,999����");
					min = sc.nextInt();
					max = sc.nextInt();
					db.searchByCarPrice(min, max);
					cnt++;
					break;
				case 5: // ���� �˻�
					System.out.println("# ���� ������ �Է��ϼ���.");
					System.out.println("���� : 0000�� ~ 9999��");
					min = sc.nextInt();
					max = sc.nextInt();
					db.searchByCarMadeYear(min, max);
					cnt++;
					break;
				case 6: // ����Ÿ� �˻�
					System.out.println("# ����Ÿ� ������ �Է��ϼ���.");
					System.out.println("���� : 0km ~ 999,999km");
					min = sc.nextInt();
					max = sc.nextInt();
					db.searchByCarDriven(min, max);
					cnt++;
					break;
				case 7: // ����Ÿ�� �˻�
					System.out.println("# ����Ÿ���� �����ϼ���.");
					System.out.println("1. ���ָ�");
					System.out.println("2. ����");
					System.out.println("3. LPG");
					System.out.println("4. ���ָ� + ����");
					System.out.println("5. ���� + ����");
					System.out.println("6. ����");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "���ָ�";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "����";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "LPG";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "���ָ�+����";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "����+����";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "����";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					}
					break;
				case 8: // ����Ÿ�� �˻�
					System.out.println("# ����Ÿ���� �����ϼ���.");
					System.out.println("1. ������");
					System.out.println("2. ���");
					System.out.println("3. ����");
					System.out.println("4. ���");
					System.out.println("5. ������");
					System.out.println("6. û��");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						searchWord = "������";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "���";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "����";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "���";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "������";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "û��";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					}
				case 9: // �˻�����
					System.out.println("�˻��� �����մϴ�.");
					System.out.print("\n");
					menuWhile();
				}
			} else if (cnt > 0) {
				switch (choice) {
				case 1: // �������� �˻�
					System.out.println("# ���������� �����ϼ���.");
					System.out.println("1. ����");
					System.out.println("2. SUV");
					System.out.println("3. ������");
					System.out.println("4. ����");
					System.out.println("5. ����");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "����";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "SUV";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "������";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "����";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "����";
						db.listByCarType(searchWord);
						cnt++;
						break;
					}
					break;
				case 2: // �𵨸� �˻�
					System.out.println("# �𵨸��� �Է��ϼ���.");
					System.out.println("ex) �Ÿ, �ƹݶ�, �׷��� �� // ��ҹ��ڸ� �����մϴ�.");
					searchWord = sc.next();
					db.listByCarName(searchWord);
					cnt++;
					break;
				case 3: // ������ �˻�
					System.out.println("# �����縦 �����ϼ���.");
					System.out.println("1. ����");
					System.out.println("2. ���");
					System.out.println("3. ������");
					System.out.println("4. �Ｚ");
					System.out.println("5. �ֿ�");
					System.out.println("6. ���׽ý�");
					System.out.println("7. ����");
					System.out.println("8. BMW");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "����";
						db.listByCarCompany(searchWord);
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "���";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "������";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "�Ｚ";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "�ֿ�";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "���׽ý�";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 7:
						searchWord = "����";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 8:
						searchWord = "BMW";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					}
					break;
				case 4: // ���� �˻�
					System.out.println("# ���� ������ �Է��ϼ���.");
					System.out.println("���� : 0 ~ 99,999����");
					min = sc.nextInt();
					max = sc.nextInt();
					db.listByCarPrice(min, max);
					cnt++;
					break;
				case 5: // ���� �˻�
					System.out.println("# ���� ������ �Է��ϼ���.");
					System.out.println("���� : 0000�� ~ 9999��");
					min = sc.nextInt();
					max = sc.nextInt();
					db.listByCarMadeYear(min, max);
					cnt++;
					break;
				case 6: // ����Ÿ� �˻�
					System.out.println("# ����Ÿ� ������ �Է��ϼ���.");
					System.out.println("���� : 0km ~ 999,999km");
					min = sc.nextInt();
					max = sc.nextInt();
					db.listByCarDriven(min, max);
					cnt++;
					break;
				case 7: // ����Ÿ�� �˻�
					System.out.println("# ����Ÿ���� �����ϼ���.");
					System.out.println("1. ���ָ�");
					System.out.println("2. ����");
					System.out.println("3. LPG");
					System.out.println("4. ���ָ� + ����");
					System.out.println("5. ���� + ����");
					System.out.println("6. ����");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "���ָ�";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "����";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "LPG";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "���ָ�+����";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "����+����";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "����";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					}
					break;
				case 8: // ����Ÿ�� �˻�
					System.out.println("# ����Ÿ���� �����ϼ���.");
					System.out.println("1. ������");
					System.out.println("2. ���");
					System.out.println("3. ����");
					System.out.println("4. ���");
					System.out.println("5. ������");
					System.out.println("6. û��");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						searchWord = "������";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "���";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "����";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "���";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "������";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "û��";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					}
					break;
				case 9: // �˻�����
					System.out.println("�˻��� �����մϴ�.");
					System.out.print("\n");
					menuWhile();
				}
			}
		}
	}
}

