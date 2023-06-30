package kopo24_0422_HwanYulCalculate;

public class ProcessingClass {
	OutputClass oc = new OutputClass();
	
	public void Exchange(ExchangeType et, double hwanyul) {
		et.hwan_jeon_han_don = (int)(et.bat_eun_don/hwanyul); // 환전한 받을 외화
		et.nam_eun_don = et.bat_eun_don / hwanyul - et.hwan_jeon_han_don; // 환전하고 남은 외화(소수점)
		et.bat_eul_nam_eun_don = ((int)( (et.nam_eun_don * hwanyul + 5) / 10)) * 10; // 남은 외화 다시 원으로 환전
		
		OehwaGetsu(et);
		HangukdonGetsu(et);
	}
	
	// KOR
	public void HangukdonGetsu(ExchangeType et) {
		int remain50000 = et.bat_eul_nam_eun_don/50000;
		int remain10000 = et.bat_eul_nam_eun_don%50000/10000;
		int remain5000 = et.bat_eul_nam_eun_don%50000%10000%5000;
		int remain1000 = et.bat_eul_nam_eun_don%50000%10000%5000/1000;
		int remain500 = et.bat_eul_nam_eun_don%50000%10000%5000%1000/500;
		int remain100 = et.bat_eul_nam_eun_don%50000%10000%5000%1000%500/100;
		int remain50 = et.bat_eul_nam_eun_don%50000%10000%5000%1000%500%100/50;
		int remain10 = et.bat_eul_nam_eun_don%50000%10000%5000%1000%500%100%50/10;
		
		oc.HangukdonGetsuPrint(et, remain50000, remain10000, remain5000, remain1000, remain500, remain100, remain50, remain10);
	}
	
	// USD, EUR, JPY
	public void OehwaGetsu(ExchangeType et) {
		
		if ( et.sun_tek_han_menu == 1 ) { // USD
			int remain100 = et.hwan_jeon_han_don/100;
			int remain50 = et.hwan_jeon_han_don%100/50;
			int remain20 = et.hwan_jeon_han_don%100%50/20;
			int remain10 = et.hwan_jeon_han_don%100%50%20/10;
			int remain5 = et.hwan_jeon_han_don%100%50%20%10/5;
			int remain2 = et.hwan_jeon_han_don%100%50%20%10%5/2;
			int remain1 = et.hwan_jeon_han_don%100%50%20%10%5%2/1;
			
			oc.UsdGetsuPrint(et, remain100, remain50, remain20, remain10, remain5, remain2, remain1);
		} else if ( et.sun_tek_han_menu == 2 ) { // EUR
			int remain500 = et.hwan_jeon_han_don/500;
			int remain200 = et.hwan_jeon_han_don%500/200;
			int remain100 = et.hwan_jeon_han_don%500%200/100;
			int remain50 = et.hwan_jeon_han_don%500%200%100/50;
			int remain20 = et.hwan_jeon_han_don%500%200%100%50/20;
			int remain10 = et.hwan_jeon_han_don%500%200%100%50%20/10;
			int remain5 = et.hwan_jeon_han_don%500%200%100%50%20%10/5;
			int remain2 = et.hwan_jeon_han_don%500%200%100%50%20%10%5/2;
			int remain1 = et.hwan_jeon_han_don%500%200%100%50%20%10%5%2/1;
			
			oc.EurGetsuPrint(et, remain500, remain200, remain100, remain50, remain20, remain10, remain5, remain2, remain1);
		} else { // JPY
			int remain10000 = et.hwan_jeon_han_don/10000;
			int remain5000 = et.hwan_jeon_han_don%10000/5000;
			int remain2000 = et.hwan_jeon_han_don%10000%5000/2000;
			int remain1000 = et.hwan_jeon_han_don%10000%5000%2000/1000;
			int remain500 = et.hwan_jeon_han_don%10000%5000%2000%1000/500;
			int remain100 = et.hwan_jeon_han_don%10000%5000%2000%1000%500/100;
			int remain50 = et.hwan_jeon_han_don%10000%5000%2000%1000%500%100/50;
			int remain10 = et.hwan_jeon_han_don%10000%5000%2000%1000%500%100%50/10;
			int remain5 = et.hwan_jeon_han_don%10000%5000%2000%1000%500%100%50%10/5;
			int remain1 = et.hwan_jeon_han_don%10000%5000%2000%1000%500%100%50%10%5/1;
			
			oc.JpyGetsuPrint(et, remain10000, remain5000, remain2000, remain1000, remain500, remain100, remain50, remain10, remain5,remain1);
		}

	}

}
