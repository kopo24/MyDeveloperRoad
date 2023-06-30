package kopo24_0428_Ticket_Sales_Analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DefineExchangeType {
	
	// 리포트파일에서 읽어들인 ExchangeType 값들을 한 줄씩 읽으면 ArrayList에 add한다. 정의된 ArrayList를 리턴한다
	public ArrayList<ExchangeType> Define(ExchangeType et, ArrayList<ExchangeType> etAL) {
		try {
			File f_read = new File("Report.csv");
			BufferedReader br_read = new BufferedReader(new FileReader(f_read));
			
			// br_read로 읽어들일 파일을 한 줄씩 저장할 곳
			String readtxt;
			
			// 필드명이 들어간 첫 줄을 먼저 읽어서 필요없는 필드명 부터 제거(잡기)
			readtxt = br_read.readLine();
			String[] field_name = readtxt.split(",");
			
			// 한 줄씩 읽어나가면서 ExchangeType클래스 변수들 초기화 후 결과를 ArrayList에 add
			while ((readtxt = br_read.readLine()) != null) {
				
				// 처음엔 어차피 초기화된거고, 두 번째 시행될때마다 대입이 되어있는 et의 값을 초기화하여 ArrayList의 다음 방에 add하게 한다.
				et = new ExchangeType();
				
				// 한 줄에서 콤마를 기준으로 문자열 배열에 넣는다
				String[] field = readtxt.split(",");
				
				// 한 줄의 [날짜]의 값으로 대입된다
				et.ticketdate = field[0];
				
				// 한 줄의 [1:주간, 2:야간]의 값으로 대입된다
				if (field[1].equals(ConstValue.DAYTIME)) et.whatTime = ConstValue.MENU_DAYTIME[0];
				else et.whatTime = ConstValue.MENU_DAYTIME[1];
				
				// 한 줄의 연령구분자[0:어른, 1:청소년, 2:어린이, 3:노인, 4:아기]의 값으로 대입된다.
				if (field[2].equals(ConstValue.STR_ADULT)) et.age = ConstValue.AGE_GRADE[0];
				else if (field[2].equals(ConstValue.STR_TEENAGER)) et.age = ConstValue.AGE_GRADE[1];
				else if (field[2].equals(ConstValue.STR_CHILD)) et.age = ConstValue.AGE_GRADE[2];
				else if (field[2].equals(ConstValue.STR_OLD)) et.age = ConstValue.AGE_GRADE[3];
				else et.age = ConstValue.AGE_GRADE[4];
				
				// 한 줄의 티켓구매수량이 대입된다.
				et.hwmyTiket = Integer.parseInt(field[3]);
				
				// 한 줄의 금액값이 대입된다.
				et.price = Integer.parseInt(field[4]);
				
				// 한 줄의 우대구분자[0:해당사항 없음, 1:장애인, 2:국가유공자, 3:다자녀, 4:임산부]의 값이 대입된다
				if (field[5].equals(ConstValue.STR_UOODAE[0])) et.UooDae = ConstValue.UOODAE[0];
				else if (field[5].equals(ConstValue.STR_UOODAE[1])) et.UooDae = ConstValue.UOODAE[1];
				else if (field[5].equals(ConstValue.STR_UOODAE[2])) et.UooDae = ConstValue.UOODAE[2];
				else if (field[5].equals(ConstValue.STR_UOODAE[3])) et.UooDae = ConstValue.UOODAE[3];
				else et.UooDae = ConstValue.UOODAE[4];
				
				// 대입된 ExchangeType을 ArrayList etAL에 add한다.
				etAL.add(et);
			}
			br_read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 최종 완성된 ArrayList를 리턴한다
		return etAL;
	}
	
}
