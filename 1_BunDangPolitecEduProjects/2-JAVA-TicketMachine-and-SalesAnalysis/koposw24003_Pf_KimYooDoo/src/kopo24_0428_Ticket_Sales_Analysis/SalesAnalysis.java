package kopo24_0428_Ticket_Sales_Analysis;

import java.util.ArrayList;

public class SalesAnalysis {

	public static void main(String[] args) {
		ArrayList<ExchangeType> etAL = new ArrayList<ExchangeType>();
		ExchangeType et = new ExchangeType();
		DefineExchangeType det = new DefineExchangeType();
		Output outprint = new Output();
		
		// 파일 한 줄씩의 ExchangeType의 값을 ArrayList에 add
		etAL = det.Define(et, etAL);
		
		// ArrayList의 값들을 정제하여 report.csv를 한번 출력
		outprint.Reprot(etAL);
		
		// 이걸 처음에 선언하지 말고!!!!! 바로 위의 etAL의 값이 정의되고나서 선언하자!
		ProcessTicket pt = new ProcessTicket(et, etAL);
		
		// 권종 별 판매현황 출력
		outprint.ForwhatTime(pt);
		
		// 일자별 매출 현황
		outprint.ForDay(pt);
		
		// 우대권 판매 현황
		outprint.ForUooDae(pt);
		
		// 일자별 매출파일 생성
		MakeFile mffd = new MakeFile();
		mffd.HeaderWriteForDate();
		mffd.DataWriteForDate(pt);
		mffd.FileClose();
		
		// 권종별 판매 개수파일 생성
		mffd = new MakeFile(2);
		mffd.HeaderWriteForAge();
		mffd.DataWriteForAge(pt);
		mffd.FileClose();
		
		// 프로그램 종료를 알림
		outprint.EndProgram();
	}
}
