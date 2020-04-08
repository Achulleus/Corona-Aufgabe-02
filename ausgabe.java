package aufgabe2;

import java.io.Console;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

public class ausgabe {
	
	private static int mo = 0;
	private static int di = 1;
	private static int mi = 2;
	private static int don = 3;
	private static int fr = 4;
	private static int sa = 5;
	private static int so = 6;
	private static int jahr;
	private static int monat;
	private static int kalenderwoche;
	private static int tage;
	private static Console con = System.console();
	private static int [] arr = new int[tage];
	
	static void pruefeTage(int jahr, int monat){
		tage=0;
		if (monat== 1||monat==3||monat==5||monat==7||monat==8||monat==10||monat==12){
			tage=31;
		}
		else if (monat==4||monat==6||monat==9){
			tage=30;
		}
		else {
			if (jahr%4==0){
				tage=29;
			}
			else {
				tage=28;
			}
		}
	}
	
	private static void wochentagFinden(int jahr,int monat) {
		LocalDate datum = LocalDate.of(jahr, monat, 1);
		kalenderwoche = datum.get((TemporalField) WeekFields.WEEK_BASED_YEARS);
		if(datum.getDayOfWeek() == DayOfWeek.MONDAY) {
			arr[mo] = 1;
			for(int i = 0; i < arr.length + mo; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
		if(datum.getDayOfWeek() == DayOfWeek.TUESDAY) {
			arr[di] = 1;
			for(int i = 0; i < arr.length + di; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
		if(datum.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
			arr[mi] = 1;
			for(int i = 0; i < arr.length + mi; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
		if(datum.getDayOfWeek() == DayOfWeek.THURSDAY) {
			arr[don] = 1;
			for(int i = 0; i < arr.length + don; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
		if(datum.getDayOfWeek() == DayOfWeek.FRIDAY) {
			arr[fr] = 1;
			for(int i = 0; i < arr.length + fr; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
		if(datum.getDayOfWeek() == DayOfWeek.SATURDAY) {
			arr[sa] = 1;
			for(int i = 0; i < arr.length + sa; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
		if(datum.getDayOfWeek() == DayOfWeek.SUNDAY) {
			arr[so] = 1;
			for(int i = 0; i < arr.length + so; i++) {
				if(arr[i] == i+1)arr[i+1] = i+2;
			}
		}
	}
	
	private static void ausgeben() {
		con.printf("Kalender für "+ monat +" "+ jahr);
		con.printf("Wo	Mo	Di	Mi	Do	Fr	Sa	So");
		for(int i = 0; i < arr.length; i = i+7) {
			System.out.println();
			for(int j = 0; j%7 != 0; j++) {
				if(j==0)con.printf(kalenderwoche +"	 ");
				if(j!=0)con.printf(arr[j] +"  ");
			}
			kalenderwoche = kalenderwoche +1;
		}
	}
	
	private static void jahrMonatBestimmen() {
		String stringJahr = con.readLine("Bitte geben Sie ein Jahr ein: ");
		jahr = Integer.parseInt(stringJahr);
		do {
			String stringMonat = con.readLine("Bitte geben Sie ein Monat ein: ");
			monat = Integer.parseInt(stringMonat);
		}while(monat < 1 || monat > 12);
	}

	public static void main(String[] args) {
		if(con != null) {
			jahrMonatBestimmen();
			pruefeTage(jahr, monat);
			wochentagFinden(jahr,monat);
			ausgeben();
		}else {
			System.out.println("Keine Konsole vorhanden!");
		}
	}
}
