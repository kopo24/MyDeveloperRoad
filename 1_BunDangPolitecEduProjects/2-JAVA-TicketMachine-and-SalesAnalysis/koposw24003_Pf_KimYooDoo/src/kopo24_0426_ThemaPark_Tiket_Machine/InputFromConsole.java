package kopo24_0426_ThemaPark_Tiket_Machine;

import java.util.Scanner;

public class InputFromConsole {
	
	Scanner sc;
	
	InputFromConsole() {
		sc = new Scanner(System.in);
	}
	
	protected void finalize() {
		sc.close();
	}
	
	 // 주간 야간 선택
	public void selectTime(ExchangeType et) {
		et.whatTime = 0;
		System.out.printf("권종을 선택하세요.\n");
		System.out.printf("1. 주간권\n");
		System.out.printf("2. 야간권\n");
		System.out.printf("-> ");
		et.whatTime = sc.nextInt();
		
		// 입력숫자가 1 또는 2가 아닌 경우
		while (et.whatTime < ConstValue.MENU_DAYTIME || et.whatTime > ConstValue.MENU_NIGHTTIME) {
			System.out.printf("권종을 다시 선택하세요.\n");
			System.out.printf("1. 주간권\n");
			System.out.printf("2. 야간권\n");
			System.out.printf("-> ");
			et.whatTime = sc.nextInt(); // 이걸 문자열(nextLine())으로 받아서 Integer.parse로 하면 개행 넣을 필요 없다.
		}
	}
	
	// 주민번호 입력
	public void inputJuminNum(ExchangeType et) {
		// 처음 주민등록번호 입력 받음
		System.out.printf("주민등록번호를 입력하세요\n");
		System.out.printf("-> ");
		sc.nextLine(); // 주간 야간 선택의 개행 처리
		et.juminNum = sc.nextLine();
		
		// 입력받은 주민등록번호가 13자리가 아닐 경우 계속 재입력
		while (et.juminNum.length() != ConstValue.NOMAL_JUMIN_NUMBER) {
			do {
				System.out.printf("다시 입력해주세요.\n");
				System.out.printf("-> ");
				et.juminNum = sc.nextLine();
				
				// 재입력받은 주민등록번호의 성별구분자가 1~4가 아닐 경우 계속 재입력
			} while (Integer.parseInt(et.juminNum.substring(6, 7)) < ConstValue.MIN_JUMIN_NUMBER
					 || Integer.parseInt(et.juminNum.substring(6, 7)) > ConstValue.MAX_JUMIN_NUMBER);
		}
	}
	
	// 구매할 티켓 갯수 입력
	public void hwmyTicket(ExchangeType et) {
		System.out.printf("몇개를 주문하시겠습니까? (최대 10개)\n");
		System.out.printf("-> ");
		et.hwmyTiket = sc.nextInt();
		
		// 입력숫자가 0~10이 아닌 경우
		while (et.hwmyTiket < ConstValue.MIN_TICKET || et.hwmyTiket > ConstValue.MAX_TICKET) {
			System.out.printf("다시 주문해주세요 (최대 10개)\n");
			System.out.printf("-> ");
			et.hwmyTiket = sc.nextInt();
		}
	}
	
	// 우대사항 선택
	public void UooDae(ExchangeType et) {
		System.out.printf("우대사항을 선택하세요.\n");
		System.out.printf("1. 없음 (나이우대는 자동처리)\n");
		System.out.printf("2. 장애인\n");
		System.out.printf("3. 국가유공자\n");
		System.out.printf("4. 다자녀\n");
		System.out.printf("5. 임산부\n");
		System.out.printf("-> ");
		et.UooDae = sc.nextInt();
		
		// 입력우대메뉴 숫자가 1~5가 아닌 경우
		while (et.UooDae < ConstValue.MENU_NOT_THING || et.UooDae > ConstValue.MENU_PREGNANT) {
			System.out.printf("우대사항을 다시 선택하세요.\n");
			System.out.printf("1. 없음 (나이우대는 자동처리)\n");
			System.out.printf("2. 장애인\n");
			System.out.printf("3. 국가유공자\n");
			System.out.printf("4. 다자녀\n");
			System.out.printf("5. 임산부\n");
			System.out.printf("-> ");
			et.UooDae = sc.nextInt();
		}
	}
	
	// 티켓 지속발행 여부 선택
	public void goOrstop(ExchangeType et) {
		System.out.printf("계속 발권 하시겠습니까?\n");
		System.out.printf("1. 티켓 발권\n");
		System.out.printf("2. 종료\n");
		System.out.printf("-> ");
		et.goOrstop = sc.nextInt();
		
		// 입력메뉴숫자가 1~2가 아닌 경우
		while (et.goOrstop < ConstValue.MENU_MORE_TICKET || et.goOrstop > ConstValue.MENU_NO_THANKS) {
			System.out.printf("잘못 입력하셨습니다.\n");
			System.out.printf("1. 티켓 발권\n");
			System.out.printf("2. 종료\n");
			System.out.printf("-> ");
			et.goOrstop = sc.nextInt();
		}
	}
	
	// 프로그램 재시작, 종료 여부 선택
	public void newOrexit(ExchangeType et) {
		System.out.printf("계속 진행 하시겠습니까?\n");
		System.out.printf("1. 새로운 주문\n");
		System.out.printf("2. 프로그램 종료\n");
		System.out.printf("-> ");
		et.newOrexit = sc.nextInt();
		
		// 입력메뉴숫자가 1~2가 아닌 경우
		while (et.newOrexit < ConstValue.NEW_ORDER || et.newOrexit > ConstValue.EXIT) {
			System.out.printf("잘못 입력하셨습니다.\n");
			System.out.printf("1. 새로운 주문\n");
			System.out.printf("2. 프로그램 종료\n");
			System.out.printf("-> ");
			et.newOrexit = sc.nextInt();
		}
	}
	
}
