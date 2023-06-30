package kopo24_0428_Ticket_Sales_Analysis;

import java.util.ArrayList;

public class Output {
	
	// 프로그램 종료시 출력
	public void EndProgram() {
		System.out.printf("매출분석 끝\n");
	}
	
	// 처음 프로그램으로 파일을 읽어들임
	public void Reprot(ArrayList<ExchangeType> etAL) {
		System.out.printf("====================== report.csv ======================\n");
		
		System.out.printf("%s%8s%8s%5s%8s%9s\n", "날짜", "권종", "연령구분", "수량", "가격", "우대사항");
		for (int i = 0; i < etAL.size(); i++) {
			System.out.printf("%s%6d%12d%7d%10d%13d\n", etAL.get(i).ticketdate, etAL.get(i).whatTime,
							  etAL.get(i).age, etAL.get(i).hwmyTiket, etAL.get(i).price, etAL.get(i).UooDae);
		}
		
		System.out.printf("--------------------------------------------------------\n\n\n\n");
	}
	
	// 권종 별 판매현황 출력
	public void ForwhatTime(ProcessTicket pt) {
		System.out.printf("================= 권종 별 판매현황 =================\n");
		
		System.out.printf("%s 총 %d매\n", ConstValue.DAYTIME, pt.dayTime());
		System.out.printf("%s %d매, %s %d매, %s %d매, %s %d매, %s %d매\n",
						  ConstValue.STR_BABY, pt.BabyTick(ConstValue.MENU_DAYTIME[0]),
						  ConstValue.STR_CHILD, pt.ChildTick(ConstValue.MENU_DAYTIME[0]),
						  ConstValue.STR_TEENAGER, pt.TeenTick(ConstValue.MENU_DAYTIME[0]),
						  ConstValue.STR_ADULT, pt.AdultTick(ConstValue.MENU_DAYTIME[0]),
						  ConstValue.STR_OLD, pt.OldTick(ConstValue.MENU_DAYTIME[0]));
		System.out.printf("%s 매출 : %d원\n", ConstValue.DAYTIME, pt.sumPrice(ConstValue.MENU_DAYTIME[0]));
		
		System.out.printf("\n");
		
		System.out.printf("%s 총 %d매\n", ConstValue.NIGHTTIME, pt.nightTime());
		System.out.printf("%s %d매, %s %d매, %s %d매, %s %d매, %s %d매\n",
						  ConstValue.STR_BABY, pt.BabyTick(ConstValue.MENU_DAYTIME[1]),
						  ConstValue.STR_CHILD, pt.ChildTick(ConstValue.MENU_DAYTIME[1]),
						  ConstValue.STR_TEENAGER, pt.TeenTick(ConstValue.MENU_DAYTIME[1]),
						  ConstValue.STR_ADULT, pt.AdultTick(ConstValue.MENU_DAYTIME[1]),
						  ConstValue.STR_OLD, pt.OldTick(ConstValue.MENU_DAYTIME[1]));
		System.out.printf("%s 매출 : %d원\n", ConstValue.NIGHTTIME, pt.sumPrice(ConstValue.MENU_DAYTIME[1]));
		
		System.out.printf("----------------------------------------------------\n\n\n\n");
	}
	
	// 일자별 매출 현황 출력
	public void ForDay(ProcessTicket pt) {
		
		String[] dateNprice;
		System.out.printf("========== 일자별 매출 현황 ==========\n");
		
		for (int i = 0; i < pt.incomePerdate().size(); i++) {
			dateNprice = pt.incomePerdate().get(i).split(",");
			System.out.printf("%s년 %s월 %s일 : 총 매출%10s원\n", dateNprice[0].substring(0, 4),
							  dateNprice[0].substring(4, 6),dateNprice[0].substring(6), dateNprice[1]);
		}
		
		System.out.printf("--------------------------------------\n\n\n\n");
	}
	
	// 우대권 판매 현황 출력
	public void ForUooDae(ProcessTicket pt) {
		
		System.out.printf("====== 우대권 판매 현황 ======\n");
		
		System.out.printf("총 판매 티켓수     :      %02d매\n", pt.sumUooDae());
		System.out.printf("우대 없음          :      %02d매\n", pt.eachUooDae(0));
		System.out.printf("장애인             :      %02d매\n",pt.eachUooDae(1));
		System.out.printf("국가유공자         :      %02d매\n", pt.eachUooDae(2));
		System.out.printf("다자녀             :      %02d매\n", pt.eachUooDae(3));
		System.out.printf("임산부             :      %02d매\n", pt.eachUooDae(4));
		
		System.out.printf("------------------------------\n");
		
	}
	
}
