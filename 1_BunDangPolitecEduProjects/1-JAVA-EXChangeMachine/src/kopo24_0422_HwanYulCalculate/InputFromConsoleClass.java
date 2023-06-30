package kopo24_0422_HwanYulCalculate;

import java.util.Scanner;

public class InputFromConsoleClass {
	Scanner sc;
	
	InputFromConsoleClass() {
		sc = new Scanner(System.in);
	}
	
	protected void finalize() {
		sc.close();
	}
	
	public void bateundon(ExchangeType et) {
		System.out.printf("받은 원화 입력 : ");
		et.bat_eun_don = sc.nextInt();
	}
	
	public void MainMenu(ExchangeType et) {
		System.out.printf("# Menu\n");
		System.out.printf("1. USD\n");
		System.out.printf("2. EUR\n");
		System.out.printf("3. JPY\n");
		System.out.printf("0. Exit\n");
		et.sun_tek_han_menu = sc.nextInt();
	}

}
