package kopo24_0426_ThemaPark_Tiket_Machine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Processing {
	
	ExchangeType et; // 생성자에서 매개변수로 가져온 et의 내용을 덮어 씌울 예정
	
	Processing(ExchangeType et) { // 생성자. proAL이 들어온다. ExchangeType 변수 사용 가능
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		
		// 티켓발행날짜 저장
		et.ticketdate = sdf.format(date);
		
		sdf = new SimpleDateFormat("yyyy");
		
		// 시스템 년도 - 입력받은 주민 년도 = et.age 초기화
		if (et.juminNum.substring(6, 7).equals("1") || et.juminNum.substring(6, 7).equals("2")) {
			et.age = Integer.parseInt("19" + et.juminNum.substring(0, 2));
			et.age = Integer.parseInt(sdf.format(date)) - et.age;
		} else {
			et.age = Integer.parseInt("20" + et.juminNum.substring(0, 2));
			et.age = Integer.parseInt(sdf.format(date)) - et.age;
		}
		
		et.age += 1; // 한국식 나이
		
		// if문과 et.age 값으로 int[] AGE_GRADE값 뽑아서 et.age 재초기화. (0:대인, 1:청소년, 2:소인, 3:경로, 4:유아)
		if (et.age >= ConstValue.OLD) et.age = ConstValue.AGE_GRADE[3];
		else if (et.age >= ConstValue.ADULT && et.age < ConstValue.OLD) et.age = ConstValue.AGE_GRADE[0];
		else if (et.age >= ConstValue.TEENAGER && et.age < ConstValue.ADULT) et.age = ConstValue.AGE_GRADE[1];
		else if (et.age >= ConstValue.CHILD && et.age < ConstValue.TEENAGER) et.age = ConstValue.AGE_GRADE[2];
		else if (et.age <= ConstValue.BABY) et.age = ConstValue.AGE_GRADE[4];
		
		// et.price = ConstValue.TICKET_PRICE[et.whatTime - 1][et.age]
		et.price = ConstValue.TICKET_PRICE[et.whatTime - 1][et.age];
		
		// 티켓 갯수 곱하기. et.price = et.price * et.hwmyTicket
		et.price *= et.hwmyTiket;
		
		// 우대사항 적용하기. if문으로 UooDae랑 비교해서 et.price *= 선택된 MENU_
		if (et.UooDae == ConstValue.MENU_NOT_THING) et.price = et.price;
		if (et.UooDae == ConstValue.MENU_DISABLED) et.price *= ConstValue.DISABLED;
		if (et.UooDae == ConstValue.MENU_NATIONAL_MERIT) et.price *= ConstValue.NATIONAL_MERIT;
		if (et.UooDae == ConstValue.MENU_MULTI_CHILD) et.price *= ConstValue.MULTI_CHILD;
		if (et.UooDae == ConstValue.MENU_PREGNANT) et.price *= ConstValue.PREGNANT;
		
		this.et = et; // 여기서 덮어씌워진다!! ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		
	}
	
	public String Date() {
		return et.ticketdate;
	}
	
	public String WhatTime() {
		if (et.whatTime == ConstValue.MENU_DAYTIME) return ConstValue.DAYTIME;
		else return ConstValue.NIGHTTIME;
	}
	
	public String Age() {
		if (et.age == ConstValue.AGE_GRADE[0]) return ConstValue.STR_ADULT;
		else if (et.age == ConstValue.AGE_GRADE[1]) return ConstValue.STR_TEENAGER;
		else if (et.age == ConstValue.AGE_GRADE[2]) return ConstValue.STR_CHILD;
		else if (et.age == ConstValue.AGE_GRADE[3]) return ConstValue.STR_OLD;
		else /*(et.age == ConstValue.AGE_GRADE[4])*/ return ConstValue.STR_BABY;
	}
	
	public int Amount() {
		return et.hwmyTiket;
	}
	
	public int Price() {
		return et.price;
	}
	
	public String UooDae() {
		if (et.UooDae == ConstValue.MENU_NOT_THING) return ConstValue.STR_NOT_THING;
		else if (et.UooDae == ConstValue.MENU_DISABLED) return ConstValue.STR_DISABLED;
		else if (et.UooDae == ConstValue.MENU_NATIONAL_MERIT) return ConstValue.STR_NATIONAL_MERIT;
		else if (et.UooDae == ConstValue.MENU_MULTI_CHILD) return ConstValue.STR_MULTI_CHILD;
		else /*(et.UooDae == ConstValue.MENU_PREGNANT)*/ return ConstValue.STR_PREGNANT;
	}
	
}
