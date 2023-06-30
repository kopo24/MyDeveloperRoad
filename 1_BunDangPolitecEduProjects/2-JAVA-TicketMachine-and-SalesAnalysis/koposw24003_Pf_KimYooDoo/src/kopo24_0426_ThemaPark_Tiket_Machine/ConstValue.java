package kopo24_0426_ThemaPark_Tiket_Machine;

public class ConstValue {
	
	// InputFromConsole Class에서 권종  선택
	final static int MENU_DAYTIME = 1; // 주간
	final static int MENU_NIGHTTIME = 2; // 야간
	
	final static String DAYTIME = "주간권";
	final static String NIGHTTIME = "야간권";
	
	// 주민등록번호 기본 13자리
	final static int NOMAL_JUMIN_NUMBER = 13;
	final static int MIN_JUMIN_NUMBER = 1;
	final static int MAX_JUMIN_NUMBER = 4;
	
	// 한 번에 구매할 수 있는 티켓 갯수 최대, 최소
	final static int MIN_TICKET = 0;
	final static int MAX_TICKET = 10;
		
	// 이용요금(주야, 나이에 따름)
	final static int[][] TICKET_PRICE = {{56000,47000,44000,44000,0},
										 {46000,40000,37000,37000,0}};
	
	// 나이에 따른 구분(0:대인, 1:청소년, 2:소인, 3:경로, 4:유아)
	final static int[] AGE_GRADE = {0,1,2,3,4};
	
	final static int ADULT = 19; // 어른 19~64
	final static int TEENAGER = 13; // 청소년 13~18
	final static int CHILD = 3; // 소인 3~12
	final static int OLD = 65; // 경로 65~
	final static int BABY = 2; // 아기 ~2
	
	final static String STR_ADULT = "어른";
	final static String STR_TEENAGER = "청소년";
	final static String STR_CHILD = "어린이";
	final static String STR_OLD = "노인";
	final static String STR_BABY = "아기";
	
	// InputFromConsole Class에서 우대사항 선택
	final static int MENU_NOT_THING = 1; // 우대메뉴 0번, 해당사항 없음
	final static int MENU_DISABLED = 2; // 우대메뉴 1번, 장애인
	final static int MENU_NATIONAL_MERIT = 3; // 우대메뉴 2번, 국가유공자
	final static int MENU_MULTI_CHILD = 4; // 우대메뉴 3번, 다자녀
	final static int MENU_PREGNANT = 5; // 우대메뉴 4번, 임산부
	
	final static String STR_NOT_THING = "우대적용 없음"; // 없음
	final static String STR_DISABLED = "장애인"; // 장애인
	final static String STR_NATIONAL_MERIT = "국가유공자"; // 국가유공자
	final static String STR_MULTI_CHILD = "다자녀"; // 다자녀
	final static String STR_PREGNANT = "임산부"; // 임산부
	
	final static double DISABLED = 0.6; // 장애인 할인율 40%
	final static double NATIONAL_MERIT = 0.5; // 국가유공자 할인율 50%
	final static double MULTI_CHILD = 0.8; // 다자녀 할인율 20%
	final static double PREGNANT = 0.85; // 임산부 할인율 15%
	
	// InputFromConsole Class에서 계속 발권 여부  선택
	final static int MENU_MORE_TICKET = 1; // 계속 발행
	final static int MENU_NO_THANKS = 2; // 발행 종료
	
	// 프로그램 종료 여부 선택
	final static int NEW_ORDER = 1; // 새 주문 진행
	final static int EXIT = 2; // 프로그램 종료
	
}
