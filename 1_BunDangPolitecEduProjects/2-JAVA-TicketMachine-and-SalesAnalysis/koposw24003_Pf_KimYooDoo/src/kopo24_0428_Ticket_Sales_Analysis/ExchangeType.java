package kopo24_0428_Ticket_Sales_Analysis;

import java.util.ArrayList;

public class ExchangeType {
	/*
	 * ***** DefineExchangeType에서 정의함 *****
	 * ***** ArrayList etAL에 정의된 한 줄씩의 값들을 add한다. *****
	 */
	// 티켓 발권 일자
	String ticketdate;
	
	// 파일에서 한 줄의 주야간 구별숫자를 받음 --- 1:주간, 2:야간
	int whatTime;
	
	// 파일에서 한 줄의 연령구분숫자를 받음 --- 0:성인, 1:청소년, 2:어린이, 3:노인, 4:아기
	int age;
	
	// 파일에서 한줄에 몇장을 구매했는지 받음
	int hwmyTiket;
	
	// 파일에서 한 줄의 금액값을 받음
	int price;
	
	// 파일에서 한 줄의 우대옵션숫자를 받음 --- 0:해당사항 없음, 1:장애인, 2:국가유공자, 3:다자녀, 4:임산부
	int UooDae;
	
	/*
	 * ***** ProcessTicket에서 계산되어 정해짐 *****
	 */
	// 주야간권 총 갯수
	int dayTime;
	int nightTime;
	
	// [0]은 주간, [1]은 야간 연령별 명수 합
	int[] adult = new int[ConstValue.MENU_DAYTIME.length];
	int[] teenager = new int[ConstValue.MENU_DAYTIME.length];
	int[] child = new int[ConstValue.MENU_DAYTIME.length];
	int[] old = new int[ConstValue.MENU_DAYTIME.length];
	int[] baby = new int[ConstValue.MENU_DAYTIME.length];
	
	// [0]은 주간, [1]은 야간 가격의 합
	int[] sumprice = new int[ConstValue.MENU_DAYTIME.length];
	
	// 판매된 우대권 총 합
	int sumUooDae;
	
	// 우대 종류별 합(0:해당사항 없음, 1:장애인, 2:국가유공자, 3:다자녀, 4:임산부)
	int[] eachUooDae = new int[ConstValue.UOODAE.length];
	
	// 일자별 매출 합
	int dateprice;
	
	// [일자]와 [그날 매출]을 문자형으로 콤마 기준으로 add
	ArrayList<String> incomePerdate;
}
