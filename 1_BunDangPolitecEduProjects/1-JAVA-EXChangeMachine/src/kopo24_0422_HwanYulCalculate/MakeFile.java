package kopo24_0422_HwanYulCalculate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MakeFile {
	private BufferedWriter bw;
	private BufferedReader br;
	
	public MakeFile() {
		try {
			File f = new File("C:\\Users\\Yang\\Desktop\\Result.csv");
			bw = new BufferedWriter(new FileWriter(f, true)); // f�� ���� ���Ͽ� append �Ҳ���? true
			br = new BufferedReader(new FileReader(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void FileClose() {
		try {
			bw.flush(); // ���������� ���ۿ� ������ �� ����(���� ����)
			bw.close(); // �ٸ� ����� ����� �� �ֵ��� ������ �ݴ´�.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void HeaderWrite() {
		try {
			String headtxt = br.readLine();
			if (headtxt == null) {
				headtxt = "��¥,ȯ�����,�ݾ�,ȯ�����,�Ž�����";
				bw.write(headtxt);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DataWrite(ExchangeType et) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
			Date date = new Date();

			String guk_ga = "";
			if (et.sun_tek_han_menu == 1) guk_ga = "USD";
			if (et.sun_tek_han_menu == 2) guk_ga = "EUR";
			if (et.sun_tek_han_menu == 3) guk_ga = "JPY";

			String writetxt = sdf.format(date) + "," + guk_ga + "," + et.bat_eun_don + "," + et.hwan_jeon_han_don + "," + et.bat_eul_nam_eun_don;

			bw.write(writetxt);
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
