package controller;

import java.util.Scanner;
import dao.DB_Connection;
import service.usedCarService;

public class managementClass {

	public static void Menu() {
		System.out.print("# ������ ��� \n");
		System.out.print("1. ����������Ȳ \n");
		System.out.print("2. �Ǹ�������Ȳ \n");
		System.out.print("3. ���������Է� \n");
		System.out.print("4. ������������ \n");
		System.out.print("5. ������������ \n");
		System.out.print("6. ����ȭ������ �̵� \n");

		String car_number = "";
		String car_type = "";
		String car_name = "";
		String made_company = "";
		int price = 0;
		double made_year = 0.0;
		int dis_driven = 0;
		String fuel_type = "";
		String color = "";

		int choice = 0;

		menuClass mc = new menuClass();
		DB_Connection car = new DB_Connection();
		Scanner sc = new Scanner(System.in);
		usedCarService ucs = new usedCarService(); 
		main mainc = new main();
		
		while (true) {
			choice = sc.nextInt();
			if (choice == 1) {
				ucs.wishBuyList();
				Menu();
			}
			if (choice == 2) {
				ucs.wishSellList();
				Menu();
			}
			if (choice == 3) {
				System.out.print("1. ���� ��ȣ �Է� : ");
				car_number = sc.next();
				System.out.print("2. ���� ���� �Է� : \n");
				car_type = sc.next();
				System.out.print("3. ���� �𵨸� �Է� : ");
				car_name = sc.next();
				System.out.print("4. ������ �Է� : ");
				made_company = sc.next();
				System.out.print("5. ���� �Է� : // ���� : 0000����");
				price = sc.nextInt();
				System.out.print("6. ���� �Է� : // ���� : 0000����");
				made_year = sc.nextDouble();
				System.out.print("7. ����Ÿ� �Է� : // ���� : 000,000Km ");
				dis_driven = sc.nextInt();
				System.out.print("8. ���� ���� �Է� : ");
				fuel_type = sc.next();
				System.out.print("9. ���� �Է� : ");
				color = sc.next();

				car.InsertusedCar(car_number, car_type, car_name, made_company, price, made_year, dis_driven, fuel_type,
						color);
				System.out.println("# �������� �Է��� �Ϸ�Ǿ����ϴ�.");
				Menu();
			}
			if (choice == 4) {
				System.out.print("# ���� ��ȣ �Է� : ");
				System.out.println("// ���Է� �� ������ȣ �����)");
				car_number = sc.next();
				car.SearchByNo(car_number);

				System.out.println("# �� ������ �½��ϱ�?");
				System.out.println("1. ��");
				System.out.println("2. �ƴϿ�");

				choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("# ������ �׸��� �����ϼ���.");
					System.out.println("1. ���� ����");
					System.out.println("2. �𵨸�");
					System.out.println("3. ������");
					System.out.println("4. ����");
					System.out.println("5. ����");
					System.out.println("6. ����Ÿ�");
					System.out.println("7. ���� ����");
					System.out.println("8. ����");
					System.out.println("9. ���� ����");

					choice = sc.nextInt();

					if (choice == 1) {
						System.out.println("# ������ ���������� �����ϼ���. ");
						mc.car_type();
					
						choice = sc.nextInt();

						if (choice == 1) {
							car_type = "����";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 2) {
							car_type = "SUV";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 3) {
							car_type = "������";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 4) {
							car_type = "����";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 5) {
							car_type = "����";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}

						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 2) {
						System.out.print("# ������ �𵨸��� �Է��ϼ��� : ");
						car_name = sc.nextLine();
						car_name = sc.nextLine();
						car.UpdateusedCarbyCarname(car_number, car_name);

						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 3) {
						System.out.println("# ������ �����縦 �����ϼ���. : ");
						System.out.println("1. ����");
						System.out.println("2. ���");
						System.out.println("3. ������");
						System.out.println("4. �Ｚ");
						System.out.println("5. �ֿ�");
						System.out.println("6. ���׽ý�");
						System.out.println("7. ����");
						System.out.println("8. BMW");

						choice = sc.nextInt();

						if (choice == 1) {
							made_company = "����";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 2) {
							made_company = "���";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 3) {
							made_company = "������";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 4) {
							made_company = "�Ｚ";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 5) {
							made_company = "�ֿ�";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 6) {
							made_company = "���׽ý�";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 7) {
							made_company = "����";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 8) {
							made_company = "BMW";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}

						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 4) {
						System.out.print("# ������ ������ �Է��ϼ���. : ");
						price = sc.nextInt();

						car.UpdateusedCarbyPrice(car_number, price);

						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 5) {
						System.out.print("# ������ ������ �Է��ϼ���. : ");
						made_year = sc.nextDouble();

						car.UpdateusedCarbyYear(car_number, made_year);

						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 6) {
						System.out.print("# ������ ����Ÿ��� �Է��Ͻʽÿ�. : ");
						dis_driven = sc.nextInt();

						car.UpdateusedCarbyDis(car_number, dis_driven);

						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 7) {
						System.out.println("# ������ ���������� �����ϼ���. ");
						System.out.println("1. ���ָ�");
						System.out.println("2. ����");
						System.out.println("3. LPG");
						System.out.println("4. ���ָ�+����");
						System.out.println("5. ����+����");
						System.out.println("6. ����");
						
						choice=sc.nextInt();
						
						if (choice == 1) {
							fuel_type = "���ָ�";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 2) {
							fuel_type = "����";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 3) {
							fuel_type = "LPG";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 4) {
							fuel_type = "���ָ�+����";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 5) {
							fuel_type = "����+����";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 6) {
							fuel_type = "����";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 8) {
						System.out.println("# ������ ������ �����ϼ���.");
						System.out.println("1. ������");
						System.out.println("2. ���");
						System.out.println("3. ����");
						System.out.println("4. ���");
						System.out.println("5. ������");
						System.out.println("6. û��");
						
						choice=sc.nextInt();
						
						if (choice == 1) {
							color = "������";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 2) {
							color = "���";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 3) {
							color = "����";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 4) {
							color = "���";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 5) {
							color = "������";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 6) {
							color = "û��";
							car.UpdateusedCarbyColor(car_number, color);
						}
						System.out.println("# ������ ���� �����Ǿ����ϴ�.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 9) {
						Menu();
					}
				}
				if (choice == 2) {
					Menu();
				}
			}
			if (choice == 5) {
				System.out.print("# ���� ��ȣ �Է�:");
				car_number = sc.next();
				car.SearchByNo(car_number);
			
				System.out.println("���� ���� ������ �����ϰڽ��ϱ�?");
				System.out.println("// ���Է� �� ������ȣ �����)");
				System.out.println("1. ��");
				System.out.println("2. �ƴϿ�");
				System.out.println("3. �ʱ�ȭ������");

				choice = sc.nextInt();

				if (choice == 1) {
					car.DeleteusedCar(car_number);
					Menu();
				}
				if (choice == 2) {
					Menu();
				}
				if (choice == 3) {
					managementClass.Menu();
				}
			}
			if (choice == 6) {
				mainc.menuWhile();
			}
		}
	}
}