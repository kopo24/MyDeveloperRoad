package kopo24_0422_HwanYulCalculate;

public class MoneyChange {
	
	public void Calculate(ExchangeType et) {
		ProcessingClass pc = new ProcessingClass();
		InputFromConsoleClass ifcc = new InputFromConsoleClass();
		MakeFile mf = new MakeFile();
		
		mf.HeaderWrite();
		do {
			ifcc.bateundon(et);
			ifcc.MainMenu(et);
			
			if ( et.sun_tek_han_menu == ConstValueClass.MENU_USD ) { // usd
				pc.Exchange(et, ConstValueClass.HWANYULUSD);
				mf.DataWrite(et);
			} else if ( et.sun_tek_han_menu == ConstValueClass.MENU_EUR ) { // eur
				pc.Exchange(et, ConstValueClass.HWANYULEUR);
				mf.DataWrite(et);
			} else if ( et.sun_tek_han_menu == ConstValueClass.MENU_JPY ) { // jpy
				pc.Exchange(et, ConstValueClass.HWANYULJPY);
				mf.DataWrite(et);
			} else if ( et.sun_tek_han_menu == ConstValueClass.MENU_EXIT ) { // exit
				System.out.printf("Thanks for using. Good Bye\n");
			} else {
				System.out.printf("Error\n");
				ifcc.MainMenu(et);
			}
		} while ( et.sun_tek_han_menu != ConstValueClass.MENU_EXIT );
		mf.FileClose();
	}
	
}
