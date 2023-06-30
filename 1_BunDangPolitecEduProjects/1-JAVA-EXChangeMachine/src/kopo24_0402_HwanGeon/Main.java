package kopo24_0402_HwanGeon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int won, exchangedol, exchangeeur, exchangewon, country; // 받은 원화, 환전해준 달러, 환전해준 유로, 거스러준 원화, 나라 선택
		float EX_RATE, changewon, exchangedolResult, exchangeeurResult; // 환전하고 남은 원화, 환전한 달러 결과값, 환전한 유로 결과값
		Scanner scanwish = new Scanner(System.in);
		Scanner scanEX_RATE = new Scanner(System.in);
		Scanner scanwon = new Scanner(System.in);
		
		System.out.println("환전하려는 돈의 종류를 선택하세요.\n1. USD\t2. EUR");
		country = scanwish.nextInt(); // 1입력시 달러환전, 2입력시 유로환전, 그 외 입력시 에러메세지 출력.
		
		if(country == 1 || country == 2) {
			System.out.println("현재 환율을 입력하세요.");
			EX_RATE = scanEX_RATE.nextFloat(); // 현재의 환율값 입력.
			
			if(country == 1) {
				System.out.print("받은 금액 입력: ");
				won = scanwon.nextInt(); // 받은 금액 입력
				exchangedolResult = won / EX_RATE; // 받은 금액을 환율에 맞춰 환전
				exchangedol = (int)exchangedolResult; // 환전한 달러의 정수부분만 표기
				changewon = (exchangedolResult - exchangedol) * EX_RATE; // 환전한 달러 외의 남은 달러를 다시 원화 환전
				System.out.printf("달러로 환전 결과: %.2f 달러\n", exchangedolResult);
				System.out.println("달러 지급: " + exchangedol + " 달러");
				System.out.println(
						"\t100달러: " + exchangedol/100 + 
						"\n\t50달러: " + exchangedol%100/50 + 
						"\n\t20달러: " + exchangedol%100%50/20 + 
						"\n\t10달러: " + exchangedol%100%50%20/10 + 
						"\n\t5달러: " + exchangedol%100%50%20%10/5 + 
						"\n\t2달러: " + exchangedol%100%50%20%10%5/2 + 
						"\n\t1달러: " + exchangedol%100%50%20%10%5%2/1);
				System.out.printf("원화 거스름: %.2f 원\n", changewon); // 원화 소수점 1의자리에서 반올림 하는 방법.
				exchangewon = (int)(changewon+5) / 10; // 원화 거스름(changewon)에서 +5를 하면, 1의자리가 0~4면 최대 9, 5~9라면 최소10, 그리고 10을 나눈다.
				System.out.println("원화 지급: " + exchangewon * 10 + " 원"); //위의 결과값에서 10을 곱해서 반올림한 결과값을 나타낸다.
				System.out.println(
						"\t1000원: " + exchangewon/100 + 
						"\n\t500원: " + exchangewon%100/50 + 
						"\n\t100원: " + exchangewon%100%50/10 + 
						"\n\t50원: " + exchangewon%100%50%10/5 + 
						"\n\t10원: " + exchangewon%100%50%10%5/1);
			} else {
				System.out.println("받은 금액 입력: ");
				won = scanwon.nextInt(); // 환전할 금액 입력.
				exchangeeurResult = won / EX_RATE; // 받은 금액을 환율에 맞춰 환전
				exchangeeur = (int)exchangeeurResult; // 환전한 유로의 정수부분만 표기
				changewon = (exchangeeurResult - exchangeeur) * EX_RATE; // 환전한 유로 외의 남은 유로를 다시 원화로 환전
				System.out.printf("유로로 환전 결과: %.2f 유로\n", exchangeeurResult);
				System.out.println("유로 지급: " + exchangeeur + " 유로");
				System.out.println(
						"\t500유로: " + exchangeeur/500 + 
						"\n\t200유로: " + exchangeeur%500/200 + 
						"\n\t100유로: " + exchangeeur%500%200/100 + 
						"\n\t50유로: " + exchangeeur%500%200%100/50 + 
						"\n\t20유로: " + exchangeeur%500%200%100%50/20 + 
						"\n\t10유로: " + exchangeeur%500%200%100%50%20/10 + 
						"\n\t5유로: " + exchangeeur%500%200%100%50%20%10/5 +
						"\n\t2유로: " + exchangeeur%500%200%100%50%20%10%5/2 +
						"\n\t1유로: " + exchangeeur%500%200%100%50%20%10%5%2/1);
				System.out.printf("원화 거스름: %.2f 원\n", changewon); // 원화 소수점 1의자리에서 반올림 하는 방법.
				exchangewon = (int)(changewon+5) / 10; // 원화 거스름(changewon)에서 +5를 하면, 1의자리가 0~4면 최대 9, 5~9라면 최소10, 그리고 10을 나눈다.
				System.out.println("원화 지급: " + exchangewon * 10 + " 원"); //위의 결과값에서 10을 곱해서 반올림한 결과값을 나타낸다.
				System.out.println(
						"\t1000원: " + exchangewon/100 + 
						"\n\t500원: " + exchangewon%100/50 + 
						"\n\t100원: " + exchangewon%100%50/10 + 
						"\n\t50원: " + exchangewon%100%50%10/5 + 
						"\n\t10원: " + exchangewon%100%50%10%5/1);
			} 
		} else {
			System.out.println("잘못된 입력입니다. 다시 실행해 주십시오.");
		}
	}

}
