package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DB_Connection;
import dto.wishBuyListVo;
import dto.wishSellListVo;
import dto.usedCarVo;
import dao.wishBuyListDao;
import dao.wishSellListDao;

public class usedCarService {
	// dao�� ����
		private DB_Connection dao;
		private usedCarVo vo;
		private wishBuyListDao wbdao;
		private wishBuyListVo wbvo;
		private wishSellListDao wsdao;
		private wishSellListVo wsvo;
		Scanner sc = new Scanner(System.in);

		public usedCarService() {
			dao = new DB_Connection();
			wbdao = new wishBuyListDao();
			wsdao = new wishSellListDao();
		}

		public ArrayList<usedCarVo> getAllUsedCar() {
			return dao.getAllUsedCar();
		}
		
		public ArrayList<wishBuyListVo> wishBuyList() {
			return wbdao.wishBuyList();
		}
		public ArrayList<wishSellListVo> wishSellList() {
			return wsdao.wishSellList();
		}
		

		public boolean login(boolean login) {

			String pw = "";
			String id = "";
			String PW = new String("1234");
			String ID = new String("system");

			while (true) {
				if (login == true) {
					System.out.println("�̹� �α��� �Ǿ� �ֽ��ϴ�.");
					System.out.println();
					break;
				}
				System.out.print("������ ���̵�� �α��� �ϼ���\n");
				System.out.print("�α��� ȭ���� �����Ϸ��� f�� �Է��ϼ���\n");
				System.out.println("ID:");
				id = sc.next();

				if(id.equals("f")) {
					System.out.println("�α��� ����");
					break;
				}		
				else if(ID.equals(id)) {
					System.out.println("PW:");
					pw = sc.next();
					if (PW.equals(pw)) {
						System.out.println("�α��� ����");
						login = true;
						break;
					} else if (PW.equals(pw) == false) {
						System.out.println("�α��� ����, ��й�ȣ�� �ٸ��ϴ�");
					}
				} else if (ID.equals(id) == false) {
					if (PW.equals(pw) == false) {
						System.out.println("�α��� ����, ���̵�� ��й�ȣ�� Ȯ���ϼ���.");
					} else {
						System.out.println("�α��� ����, ���̵� �ٸ��ϴ�.");
					}
				}

			}
			return login;
		}

		public void managemermod() {
			
			
		}
}
