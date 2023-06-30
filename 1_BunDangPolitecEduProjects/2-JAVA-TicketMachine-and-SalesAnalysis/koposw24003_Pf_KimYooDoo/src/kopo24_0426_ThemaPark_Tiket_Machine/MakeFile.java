package kopo24_0426_ThemaPark_Tiket_Machine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MakeFile {
	private BufferedWriter bw;
	private BufferedReader br;
	
	public MakeFile() {
		try {
			File f = new File("Report.csv");
			bw = new BufferedWriter(new FileWriter(f, true)); // f가 잡은 파일에 append 할꺼냐? true
			br = new BufferedReader(new FileReader(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void FileClose() {
		try {
			bw.flush(); // 마지막으로 버퍼에 남은거 다 쓰기(버퍼 비우기)
			bw.close(); // 다른 사람도 사용할 수 있도록 파일을 닫는다.
			br.close(); // 다른 사람도 사용할 수 있도록 파일을 닫는다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void HeaderWrite() {
		try {
			String headtxt = br.readLine();
			if (headtxt == null) {
				headtxt = "날짜,권종,연령구분,수량,가격,우대사항";
				bw.write(headtxt);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DataWrite(ArrayList<Processing> proAL) {
		try {
			for (int i = 0; i < proAL.size(); i++) {
				String writetxt = proAL.get(i).Date() + "," + proAL.get(i).WhatTime() + ","
								  + proAL.get(i).Age() + "," + proAL.get(i).Amount() + ","
								  + proAL.get(i).Price() + "," + proAL.get(i).UooDae();
				
				bw.write(writetxt);
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
