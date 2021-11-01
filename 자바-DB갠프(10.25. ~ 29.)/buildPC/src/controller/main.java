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
				System.out.println("# 견적서를 생성합니다.");
				System.out.println("# 견적서 이름을 입력하세요.");
				quoteName = sc.next();
				makeQuote.db.quote.setQuoteName(quoteName);
				makeQuote.choiceCPU();
				makeQuote.choiceMainboard();
				makeQuote.choiceVGA();
				makeQuote.choiceRAM();
				makeQuote.choiceSSD();
				makeQuote.db.insertQuote();
				System.out.println("# 초기화면으로 돌아갑니다.");
				menuWhile();
				break;
			case 2:
				System.out.println("# 조회 및 관리할 견적서를 선택하세요.");
				updateQuote.update.searchQuote();
				updateQuote.inquiryQuote();
			}
		}
	}
}