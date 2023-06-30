package kopo24_0422_HwanYulCalculate;

public class OutputClass {
	
	// KOR
	public void HangukdonGetsuPrint(ExchangeType et, int remain50000, int remain10000, int remain5000, int remain1000, int remain500, int remain100, int remain50, int remain10  ) {
		System.out.printf("원화 거스름 : %d\n", et.bat_eul_nam_eun_don);
		System.out.printf("50,000 : %d\n", remain50000);
		System.out.printf("10,000 : %d\n", remain10000);
		System.out.printf("5,000 : %d\n", remain5000);
		System.out.printf("1,000 : %d\n", remain1000);
		System.out.printf("500 : %d\n", remain500);
		System.out.printf("100 : %d \n", remain100);
		System.out.printf("50 : %d\n", remain50);
		System.out.printf("10 : %d\n", remain10);
	}
	
	// USD
	public void UsdGetsuPrint(ExchangeType et, int remain100, int remain50, int remain20, int remain10, int remain5, int remain2, int remain1) {
		System.out.printf("달러 지급 : %d\n", et.hwan_jeon_han_don);
		System.out.printf("100 : %d\n", remain100);
		System.out.printf("50 : %d\n", remain50);
		System.out.printf("20 : %d\n", remain20);
		System.out.printf("10 : %d\n", remain10);
		System.out.printf("5 : %d\n", remain5);
		System.out.printf("2 : %d\n", remain2);
		System.out.printf("1 : %d\n", remain1);
	}
	
	// EUR
	public void EurGetsuPrint(ExchangeType et, int remain500, int remain200, int remain100, int remain50, int remain20, int remain10, int remain5, int remain2, int remain1) {
		System.out.printf("유로 지급 : %d\n", et.hwan_jeon_han_don);
		System.out.printf("500 : %d\n", remain500);
		System.out.printf("200 : %d\n", remain200);
		System.out.printf("100 : %d\n", remain100);
		System.out.printf("50 : %d\n", remain50);
		System.out.printf("20 : %d\n", remain20);
		System.out.printf("10 : %d\n", remain10);
		System.out.printf("5 : %d\n", remain5);
		System.out.printf("2 : %d\n", remain2);
		System.out.printf("1 : %d\n", remain1);
	}
	
	// JPY
	public void JpyGetsuPrint(ExchangeType et, int remain10000, int remain5000, int remain2000, int remain1000, int remain500, int remain100, int remain50, int remain10, int remain5, int remain1) {
		System.out.printf("엔화 지급 : %d\n", et.hwan_jeon_han_don);
		System.out.printf("10,000 : %d\n", remain10000);
		System.out.printf("5,000 : %d\n", remain5000);
		System.out.printf("2,000 : %d\n", remain2000);
		System.out.printf("1,000 : %d\n", remain1000);
		System.out.printf("500 : %d\n", remain500);
		System.out.printf("100 : %d\n", remain100);
		System.out.printf("50 : %d\n", remain50);
		System.out.printf("10 : %d\n", remain10);
		System.out.printf("5 : %d\n", remain5);
		System.out.printf("1 : %d\n", remain1);
	}
	
	
}
