package controller;

import java.util.ArrayList;
import java.util.Scanner;
import dao.*;

public class main {
	
	public static void main(String[] args) {
		menuWhile();
	}
	
	public static void menuWhile() {
		menu.menu();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		String quoteName;
		int choice;
		
		choice = sc.nextInt();		
			switch(choice) {
			case 1:
				System.out.println("# �������� �����մϴ�.");
				System.out.println("# ������ �̸��� �Է��ϼ���.");
				quoteName = sc.next();
				makeQuote.db.quote.setQuoteName(quoteName);
				makeQuote.choiceCPU();
				makeQuote.choiceMainboard();
				makeQuote.choiceVGA();
				makeQuote.choiceRAM();
				makeQuote.choiceSSD();
				makeQuote.db.insertQuote();
				System.out.println("# �ʱ�ȭ������ ���ư��ϴ�.");
				menuWhile();
				break;
			case 2:
				System.out.println("# ��ȸ �� ������ �������� �����ϼ���.");
				updateQuote.update.searchQuote();
				updateQuote.inquiryQuote();
			}
		}
	}
}