package kopo24_0402_HwanGeon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int won, exchangedol, exchangeeur, exchangewon, country; // ���� ��ȭ, ȯ������ �޷�, ȯ������ ����, �Ž����� ��ȭ, ���� ����
		float EX_RATE, changewon, exchangedolResult, exchangeeurResult; // ȯ���ϰ� ���� ��ȭ, ȯ���� �޷� �����, ȯ���� ���� �����
		Scanner scanwish = new Scanner(System.in);
		Scanner scanEX_RATE = new Scanner(System.in);
		Scanner scanwon = new Scanner(System.in);
		
		System.out.println("ȯ���Ϸ��� ���� ������ �����ϼ���.\n1. USD\t2. EUR");
		country = scanwish.nextInt(); // 1�Է½� �޷�ȯ��, 2�Է½� ����ȯ��, �� �� �Է½� �����޼��� ���.
		
		if(country == 1 || country == 2) {
			System.out.println("���� ȯ���� �Է��ϼ���.");
			EX_RATE = scanEX_RATE.nextFloat(); // ������ ȯ���� �Է�.
			
			if(country == 1) {
				System.out.print("���� �ݾ� �Է�: ");
				won = scanwon.nextInt(); // ���� �ݾ� �Է�
				exchangedolResult = won / EX_RATE; // ���� �ݾ��� ȯ���� ���� ȯ��
				exchangedol = (int)exchangedolResult; // ȯ���� �޷��� �����κи� ǥ��
				changewon = (exchangedolResult - exchangedol) * EX_RATE; // ȯ���� �޷� ���� ���� �޷��� �ٽ� ��ȭ ȯ��
				System.out.printf("�޷��� ȯ�� ���: %.2f �޷�\n", exchangedolResult);
				System.out.println("�޷� ����: " + exchangedol + " �޷�");
				System.out.println(
						"\t100�޷�: " + exchangedol/100 + 
						"\n\t50�޷�: " + exchangedol%100/50 + 
						"\n\t20�޷�: " + exchangedol%100%50/20 + 
						"\n\t10�޷�: " + exchangedol%100%50%20/10 + 
						"\n\t5�޷�: " + exchangedol%100%50%20%10/5 + 
						"\n\t2�޷�: " + exchangedol%100%50%20%10%5/2 + 
						"\n\t1�޷�: " + exchangedol%100%50%20%10%5%2/1);
				System.out.printf("��ȭ �Ž���: %.2f ��\n", changewon); // ��ȭ �Ҽ��� 1���ڸ����� �ݿø� �ϴ� ���.
				exchangewon = (int)(changewon+5) / 10; // ��ȭ �Ž���(changewon)���� +5�� �ϸ�, 1���ڸ��� 0~4�� �ִ� 9, 5~9��� �ּ�10, �׸��� 10�� ������.
				System.out.println("��ȭ ����: " + exchangewon * 10 + " ��"); //���� ��������� 10�� ���ؼ� �ݿø��� ������� ��Ÿ����.
				System.out.println(
						"\t1000��: " + exchangewon/100 + 
						"\n\t500��: " + exchangewon%100/50 + 
						"\n\t100��: " + exchangewon%100%50/10 + 
						"\n\t50��: " + exchangewon%100%50%10/5 + 
						"\n\t10��: " + exchangewon%100%50%10%5/1);
			} else {
				System.out.println("���� �ݾ� �Է�: ");
				won = scanwon.nextInt(); // ȯ���� �ݾ� �Է�.
				exchangeeurResult = won / EX_RATE; // ���� �ݾ��� ȯ���� ���� ȯ��
				exchangeeur = (int)exchangeeurResult; // ȯ���� ������ �����κи� ǥ��
				changewon = (exchangeeurResult - exchangeeur) * EX_RATE; // ȯ���� ���� ���� ���� ���θ� �ٽ� ��ȭ�� ȯ��
				System.out.printf("���η� ȯ�� ���: %.2f ����\n", exchangeeurResult);
				System.out.println("���� ����: " + exchangeeur + " ����");
				System.out.println(
						"\t500����: " + exchangeeur/500 + 
						"\n\t200����: " + exchangeeur%500/200 + 
						"\n\t100����: " + exchangeeur%500%200/100 + 
						"\n\t50����: " + exchangeeur%500%200%100/50 + 
						"\n\t20����: " + exchangeeur%500%200%100%50/20 + 
						"\n\t10����: " + exchangeeur%500%200%100%50%20/10 + 
						"\n\t5����: " + exchangeeur%500%200%100%50%20%10/5 +
						"\n\t2����: " + exchangeeur%500%200%100%50%20%10%5/2 +
						"\n\t1����: " + exchangeeur%500%200%100%50%20%10%5%2/1);
				System.out.printf("��ȭ �Ž���: %.2f ��\n", changewon); // ��ȭ �Ҽ��� 1���ڸ����� �ݿø� �ϴ� ���.
				exchangewon = (int)(changewon+5) / 10; // ��ȭ �Ž���(changewon)���� +5�� �ϸ�, 1���ڸ��� 0~4�� �ִ� 9, 5~9��� �ּ�10, �׸��� 10�� ������.
				System.out.println("��ȭ ����: " + exchangewon * 10 + " ��"); //���� ��������� 10�� ���ؼ� �ݿø��� ������� ��Ÿ����.
				System.out.println(
						"\t1000��: " + exchangewon/100 + 
						"\n\t500��: " + exchangewon%100/50 + 
						"\n\t100��: " + exchangewon%100%50/10 + 
						"\n\t50��: " + exchangewon%100%50%10/5 + 
						"\n\t10��: " + exchangewon%100%50%10%5/1);
			} 
		} else {
			System.out.println("�߸��� �Է��Դϴ�. �ٽ� ������ �ֽʽÿ�.");
		}
	}

}
