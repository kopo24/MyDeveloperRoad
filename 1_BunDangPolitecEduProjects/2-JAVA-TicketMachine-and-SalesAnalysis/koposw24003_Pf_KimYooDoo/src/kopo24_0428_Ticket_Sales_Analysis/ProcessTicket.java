package kopo24_0428_Ticket_Sales_Analysis;

import java.util.ArrayList;

public class ProcessTicket {
	
	ExchangeType et;
	
	// 생성자로서 이 클래스의 객체 pt가 호출될때마다 계산을 하게 됨.
	ProcessTicket(ExchangeType et, ArrayList<ExchangeType> etAL) { 
		
		// 필드명을 제외한 데이터의 첫 번째 줄 금액 값을 먼저 받음 -> 계속 [지금 줄 +1]을 넣기에 첫 번째 값이 들어가 있어야 함
		et.dateprice = etAL.get(0).price;
		
		// 일자가 같은 금액들의 합을 add
		et.incomePerdate = new ArrayList<String>();
		
		for (int i = 0; i < etAL.size(); i++) {
			
			/*
			 * if -> 주간 별 판매 현황 변수 계산
			 * else -> 야간 별 판매 현황 변수 계산
			 */
			if (etAL.get(i).whatTime == ConstValue.MENU_DAYTIME[0]) {
				// 주간권 티켓 총 합
				et.dayTime += etAL.get(i).hwmyTiket;
				
				// 주간권에서 연령대별 티켓 총 합
				if (etAL.get(i).age == ConstValue.AGE_GRADE[0]) et.adult[0] += etAL.get(i).hwmyTiket;
				else if (etAL.get(i).age == ConstValue.AGE_GRADE[1]) et.teenager[0] += etAL.get(i).hwmyTiket;
				else if (etAL.get(i).age == ConstValue.AGE_GRADE[2]) et.child[0] += etAL.get(i).hwmyTiket;
				else if (etAL.get(i).age == ConstValue.AGE_GRADE[3]) et.old[0] += etAL.get(i).hwmyTiket;
				else /*etAL.get(i).age == ConstValue.AGE_GRADE[4]*/et.baby[0] += etAL.get(i).hwmyTiket;
				
				// 주간권 금액의 합
				et.sumprice[0] += etAL.get(i).price;
			} else /*etAL.get(i).whatTime == ConstValue.MENU_DAYTIME[1]*/{
				// 야간권 티켓 총 합
				et.nightTime += etAL.get(i).hwmyTiket;
				
				// 야간권에서 연령대별 티켓 합
				if (etAL.get(i).age == ConstValue.AGE_GRADE[0]) et.adult[1] += etAL.get(i).hwmyTiket;
				else if (etAL.get(i).age == ConstValue.AGE_GRADE[1]) et.teenager[1] += etAL.get(i).hwmyTiket;
				else if (etAL.get(i).age == ConstValue.AGE_GRADE[2]) et.child[1] += etAL.get(i).hwmyTiket;
				else if (etAL.get(i).age == ConstValue.AGE_GRADE[3]) et.old[1] += etAL.get(i).hwmyTiket;
				else /*etAL.get(i).age == ConstValue.AGE_GRADE[4]*/et.baby[1] += etAL.get(i).hwmyTiket;
				
				// 야간권 금액의 합
				et.sumprice[1] += etAL.get(i).price;
			}
			
			// 우대권 판매 총 합
			et.sumUooDae += etAL.get(i).hwmyTiket;
			
			// 우대권 종류별 합
			if (etAL.get(i).UooDae == ConstValue.UOODAE[0]) et.eachUooDae[0] += etAL.get(i).hwmyTiket;
			else if (etAL.get(i).UooDae == ConstValue.UOODAE[1]) et.eachUooDae[1] += etAL.get(i).hwmyTiket;
			else if (etAL.get(i).UooDae == ConstValue.UOODAE[2]) et.eachUooDae[2] += etAL.get(i).hwmyTiket;
			else if (etAL.get(i).UooDae == ConstValue.UOODAE[3]) et.eachUooDae[3] += etAL.get(i).hwmyTiket;
			else /*etAL.get(i).UooDae == ConstValue.UOODAE[4]*/ et.eachUooDae[4] += etAL.get(i).hwmyTiket;
			
			// 일자별 매출 계산
			if (i == (etAL.size() - 1)) { // 마지막 줄이라면 그냥 마지막 날자와 여태까지의 값을 ArrayList에 add
				et.incomePerdate.add(etAL.get(i).ticketdate + "," + et.dateprice);
			} else { // 마지막 줄이 아니라면
				// i번쨰 줄의 날짜가 i+1번째 줄의 날짜와 같지 않다면(== 다르다면)
				if (!(etAL.get(i).ticketdate.equals(etAL.get(i+1).ticketdate))) {
					// i번째 날짜에 콤마를 붙이고 이어서 여태까지의 금액 합을 문자형으로 바꿔 add(대입시 앞부분이 문자열이면 정수는 문자열로 바뀜)
					et.incomePerdate.add(etAL.get(i).ticketdate + "," + et.dateprice);
					// 다음 날짜 금액계산시 첫 번째 금액값을 저장함
					et.dateprice = etAL.get(i+1).price;
				}
				// i번째 줄의 날짜가 i+1번째 줄의 날짜와 같다면
				else et.dateprice += etAL.get(i+1).price; // 현재 금액값과 i+1의 금액값을 합한다.
			}
		}
		
		// 위의 생성자부분에서 정의된 ExchageType의 값들로 이 클래스에서 부른 ExchangeType의 값에 덮어 씌운다.
		this.et = et;
		
	}
	
	/*
	 * 덮어씌운 ExchangeType의 값으로 아래 메소드별 조건에 만족하는 값을 return한다.
	 */
	// [일자,금액합]모양의 문자열이 add되어있는 ArrayList
	public ArrayList<String> incomePerdate() {
		return et.incomePerdate;
	}
	
	// 매개변수에 맞는 우대권 종류별 합을 리턴
	public int eachUooDae(int what) {
		if (what == ConstValue.UOODAE[0]) return et.eachUooDae[0];
		else if (what == ConstValue.UOODAE[1]) return et.eachUooDae[1];
		else if (what == ConstValue.UOODAE[2]) return et.eachUooDae[2];
		else if (what == ConstValue.UOODAE[3]) return et.eachUooDae[3];
		else /*what == ConstValue.UOODAE[4]*/ return et.eachUooDae[4];
	}
	
	// 우대판매티켓 총량 리턴
	public int sumUooDae() {
		return et.sumUooDae;
	}
	
	// 주간권 티켓 판매 총 합 리턴
	public int dayTime() {
		return et.dayTime;
	}
	
	// 야간권 티켓 판매 총 합 리턴
	public int nightTime() {
		return et.nightTime;
	}
	
	// 매개변수에 맞는 성인 티켓 판매 합 리턴 --- 1:주간, 2:야간
	public int AdultTick(int day) {
		if (day == ConstValue.MENU_DAYTIME[0]) return et.adult[0];
		else return et.adult[1];
	}
	
	// 매개변수에 맞는 청소년 티켓 판매 합 리턴 --- 1:주간, 2:야간
	public int TeenTick(int day) {
		if (day == ConstValue.MENU_DAYTIME[0]) return et.teenager[0];
		else return et.teenager[1];
	}
	
	// 매개변수에 맞는 어린이 티켓 판매 합 리턴 --- 1:주간, 2:야간
	public int ChildTick(int day) {
		if (day == ConstValue.MENU_DAYTIME[0]) return et.child[0];
		else return et.child[1];
	}
	
	// 매개변수에 맞는 노인 티켓 판매 합 리턴 --- 1:주간, 2:야간
	public int OldTick(int day) {
		if (day == ConstValue.MENU_DAYTIME[0]) return et.old[0];
		else return et.old[1];
	}
	
	// 매개변수에 맞는 아기 티켓 판매 합 리턴 --- 1:주간, 2:야간
	public int BabyTick(int day) {
		if (day == ConstValue.MENU_DAYTIME[0]) return et.baby[0];
		else return et.baby[1];
	}
	
	// 매개변수에 맞는 티켓 판매 금액의 합 리턴 --- 1:주간, 2:야간
	public int sumPrice(int day) {
		if (day == ConstValue.MENU_DAYTIME[0]) return et.sumprice[0];
		else return et.sumprice[1];
	}
	
}
