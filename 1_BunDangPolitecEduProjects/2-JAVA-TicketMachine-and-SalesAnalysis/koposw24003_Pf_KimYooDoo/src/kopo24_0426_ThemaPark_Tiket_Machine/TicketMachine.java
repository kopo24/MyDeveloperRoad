package kopo24_0426_ThemaPark_Tiket_Machine;

import java.util.ArrayList;

public class TicketMachine {
	
	public static void main(String[] args) {
		ArrayList<Processing> proAL = new ArrayList<Processing>();
		InputFromConsole ifc = new InputFromConsole();
		ExchangeType et = new ExchangeType();
		MakeFile mf = new MakeFile();
		Output outprint = new Output();
		
		// 데이터파일 해더 작성
		mf.HeaderWrite();
		do {
			do {
				// add하고서 다른 et를 가리키도록 재생성!
				// 교수님이 개념을 잡아주셔서 해결!
				// add는 ArrayList에 추가, 저장하는 것이 아니라 어느 한 메모리에 그 결과를
				// 만들고 가리키고 있는 것일 뿐.
				et = new ExchangeType();
				
				// 권종 선택, InputFromConsole로 가서 ExchangeType의 int whatTime 초기화
				ifc.selectTime(et);

				// 주민번호 입력, InputFromConsole로 가서 ExchangeType의 String juminNum 초기화
				ifc.inputJuminNum(et);

				// 주문티켓 갯수, InputFromConsole로 가서 ExchangeType의 int howmanyTicket 초기화
				ifc.hwmyTicket(et);

				// 우대사항 선택, InputFromConsole로 가서 ExchangeType의 int UooDae 초기화
				ifc.UooDae(et);

				// 한번 프로그램이 종료 될 때까지, 한 번 돌아간 while의 결과값을 저장 할 배열
				proAL.add(new Processing(et)); // 위에서 초기화된 유동변수 사용

				// 한번 처리한 가격 출력
				outprint.printOne(et);

				//계속 티켓 발행 여부
				ifc.goOrstop(et);

			} while (et.goOrstop == ConstValue.MENU_MORE_TICKET); // 탈출 조건
			
			// 최종 결과창 출력부분
			// Output Class로 ArrayList 전달
			outprint.printList(proAL);

			// 최종 금액 합
			outprint.printSum(proAL, et);
			
			// 데이터파일 작성
			mf.DataWrite(proAL);
			
			// 계속 진행 여부(1새로운 주문, proAL초기화 / 2프로그램 종료)
			ifc.newOrexit(et);
			
			// ArrayList 초기화
			proAL.clear();
			
		} while (et.newOrexit == ConstValue.NEW_ORDER);
		
		// 데이터파일 닫기
		mf.FileClose();
		
		// 프로그램 종료 알리기
		outprint.EndProgram();
	}
}
