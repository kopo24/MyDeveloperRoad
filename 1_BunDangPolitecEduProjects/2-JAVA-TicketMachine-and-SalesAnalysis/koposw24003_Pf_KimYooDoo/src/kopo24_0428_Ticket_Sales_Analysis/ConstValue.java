package kopo24_0428_Ticket_Sales_Analysis;

public class ConstValue {
	
	// 0 -> 1.주간, 1 -> 2.야간
	final static int[] MENU_DAYTIME = {1,2};
	
	final static String DAYTIME = "주간권";
	final static String NIGHTTIME = "야간권";
	
	// 나이에 따른 구분(0:대인, 1:청소년, 2:소인, 3:경로, 4:유아)
	final static int[] AGE_GRADE = {0,1,2,3,4};
	
	final static String STR_ADULT = "어른";
	final static String STR_TEENAGER = "청소년";
	final static String STR_CHILD = "어린이";
	final static String STR_OLD = "노인";
	final static String STR_BABY = "아기";
	
	/*
	 * [0] : 1, 해당사항 없음
	 * [1] : 2, 장애인
	 * [2] : 3, 국가유공자
	 * [3] : 4, 다자녀
	 * [4] : 5, 임산부
	 */
	final static int[] UOODAE = {1,2,3,4,5};
	
	final static String[] STR_UOODAE = {"우대적용 없음","장애인",
										"국가유공자","다자녀","임산부"};
}
