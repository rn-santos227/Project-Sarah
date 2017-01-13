package com.project.Doeville.clock;

import java.awt.Color;
import java.awt.Graphics;

import com.project.Doeville.data.BankInformation;
import com.project.Doeville.data.ConStoreStorage;
import com.project.Doeville.data.PaymentRecord;
import com.project.Doeville.data.PharmacyStorage;
import com.project.Doeville.entities.dynamics.Player;
import com.project.Doeville.gfx.Assets;
import com.project.Doeville.utils.FontFactory;

public class GameClock {
	public boolean changeOfMonth, changeOfYear;
	public static String currentMonth, currentDay, currentYear, currentWeekDay, currentHour, currentMinutes, currentDate;
	public static String currentGameTime, currentGameDate, currentTime;
	public static boolean isDark;
	public static boolean isLeapYear;
	private FontFactory ff;
	private String[] months = {
			"January", "February", "March",
			"April", "May", "June",
			"July", "August", "September",
			"October", "November", "December"};
	private String[] w_days = {
			"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	private int year = 2017;
	private long lastTime, timer;
	private int days, hours, minutes;
	private int g_hours, g_minutes, g_seconds;
	private int wIndex, mIndex;
	protected int x, y, time;
	
	public GameClock(int x, int y) {
		this.x = x; this.y = y;
		ff = new FontFactory();
		timer = 0; lastTime = System.currentTimeMillis();
		//Default Starting Time:
		defaultStartingTime();
	}
	
	private void defaultStartingTime() {
		//Default time is 10:00, Default date is JUL 10, 2017
		mIndex = 0; wIndex = 0; 
		currentMonth = months[mIndex];
		currentYear = Integer.toString(year);
		currentWeekDay = w_days[wIndex];
		days = 10; hours = 10; minutes = 0;
		time = 20;
		
		
		if(days < 10) currentDay = "0" + Integer.toString(days);
		else currentDay = Integer.toString(days);
		
		if(hours < 10) currentHour = "0" + Integer.toString(hours);
		else currentHour = Integer.toString(hours);
		
		if(minutes < 30) currentMinutes = "00";
		else currentMinutes = "30";
		
		currentTime = "10:00";
		currentDate = "22 JUL 2017";
	}
	
	private void changeMonth() {
		if(currentMonth.equalsIgnoreCase("September") || currentMonth.equalsIgnoreCase("April") || currentMonth.equalsIgnoreCase("June") || currentMonth.equalsIgnoreCase("November") ) {
			if(days > 30) { changeOfMonth = true; days = 1; currentDay = "0" + Integer.toString(days); mIndex++; currentMonth = months[mIndex]; }
			else return;
		}
		else if(currentMonth.equalsIgnoreCase("February") && !isLeapYear) {
			if(days > 28) { changeOfMonth = true; days = 1; currentDay = "0" + Integer.toString(days); mIndex++; currentMonth = months[mIndex]; }
			else return;
		}
		//Leap Year
		else if(isLeapYear && currentMonth.equalsIgnoreCase("February")) {
			if(days > 29) { changeOfMonth = true; days = 1; currentDay = "0" + Integer.toString(days); mIndex++; currentMonth = months[mIndex]; }
			else return;
		}
		else if (currentMonth.equalsIgnoreCase("December")) {
			if(days > 31) { changeOfMonth = true; changeOfYear = true;
				days = 1; currentDay = "0" + Integer.toString(days); mIndex = 0; currentMonth = months[mIndex]; 
				year++; 
				if(year % 100 == 0) isLeapYear = year % 400 == 0 ? true : false;
				else isLeapYear = year % 4 == 0 ? true : false;
				currentYear = Integer.toString(year);
			} else return;
		}
		else {
			if(days > 31) { changeOfMonth = true; days = 1; currentDay = "0" + Integer.toString(days); mIndex++; currentMonth = months[mIndex]; }
			else return;
		}
	}
	
	public void tick() {
		if(!Player.paused) {
			changeClock();
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			//5 seconds is equal to 1 minute
			if(timer > 5000) {
				timer = 0; 
				g_clockUpdate();
				clockUpdate();
			}
		}
	}
	
	public void g_clockUpdate() {
		g_seconds += 1;
		if(g_seconds >= 60) { g_minutes += 1; g_seconds = 0; }
		if(g_minutes >= 60) { g_hours += 1; g_minutes = 0; g_seconds = 0;}
	}
	
	public void clockUpdate() {
		if(changeOfMonth) {
			PharmacyStorage.updatePharmacyStorage();
			ConStoreStorage.updateConvinienceStore();
			BankInformation.currentBalance += PaymentRecord.salary;
			changeOfMonth = false;
		}
		minutes++;
		if(minutes > 30 && minutes < 60) currentMinutes = "30"; 			
		else if(minutes > 60) { minutes = 0; hours++; currentMinutes = "00";
			if(hours < 10) currentHour = "0" + Integer.toString(hours);
			else currentHour = Integer.toString(hours);
		}
		if(hours > 23) {
			hours = 0; days++; wIndex++; 
			if(wIndex < w_days.length) wIndex = 0;
			currentWeekDay = w_days[wIndex];
			
			if(hours < 10) currentHour = "0" + Integer.toString(hours);
			else currentHour = Integer.toString(hours);
			
			if(days < 10) currentDay = "0" + Integer.toString(days);
			else currentDay = Integer.toString(days);
		}
		
		changeMonth();
		
		currentTime = currentHour + ":" + currentMinutes;
		currentDate =  currentDay + " " + currentMonth.substring(0,3).toUpperCase() + " " + currentYear;
		
		if(!DayNight.indoors) {
			if(hours == 18 && DayNight.alpha <= 0.4f) { DayNight.alpha += 0.01f; }
			else if(hours == 6 && DayNight.alpha >= 0.01f) { DayNight.alpha -= 0.01f; }
			DayNight(hours);
		}
		
		if(hours >= 18 || hours <= 5) isDark = true;
		else isDark = false;
	}
	
	public void changeClock() {
		if((hours == 0 || hours == 12) && minutes <= 30) time = 0;
		else if((hours == 0 || hours == 12) && minutes >= 30) time = 1;
		else if((hours == 1 || hours == 13) && minutes <= 30) time = 2;
		else if((hours == 1 || hours == 13) && minutes >= 30) time = 3;
		else if((hours == 2 || hours == 14) && minutes <= 30) time = 4;
		else if((hours == 2 || hours == 14) && minutes >= 30) time = 5;
		else if((hours == 3 || hours == 15) && minutes <= 30) time = 6;
		else if((hours == 3 || hours == 15) && minutes >= 30) time = 7;
		else if((hours == 4 || hours == 16) && minutes <= 30) time = 8;
		else if((hours == 4 || hours == 16) && minutes >= 30) time = 9;
		else if((hours == 5 || hours == 17) && minutes <= 30) time = 10;
		else if((hours == 5 || hours == 17) && minutes >= 30) time = 11;
		else if((hours == 6 || hours == 18) && minutes <= 30) time = 12;
		else if((hours == 6 || hours == 18) && minutes >= 30) time = 13;
		else if((hours == 7 || hours == 19) && minutes <= 30) time = 14;
		else if((hours == 7 || hours == 19) && minutes >= 30) time = 15;
		else if((hours == 8 || hours == 20) && minutes <= 30) time = 16;
		else if((hours == 8 || hours == 20) && minutes >= 30) time = 17;
		else if((hours == 9 || hours == 21) && minutes <= 30) time = 18;
		else if((hours == 9 || hours == 21) && minutes >= 30) time = 19;
		else if((hours == 10 || hours == 22) && minutes <= 30) time = 20;
		else if((hours == 10|| hours == 22) && minutes >= 30) time = 21;
		else if((hours == 11 || hours == 23) && minutes <= 30) time = 22;
		else if((hours == 11 || hours == 23) && minutes >= 30) time = 23;
	}
	
	public void DayNight(int x) {
		switch(x) {
		case 0: DayNight.alpha = 0.4f; break;
		case 1: DayNight.alpha = 0.4f; break;
		case 2: DayNight.alpha = 0.4f; break;
		case 3: DayNight.alpha = 0.4f; break;
		case 4: DayNight.alpha = 0.4f; break;
		case 5: DayNight.alpha = 0.4f; break;
		case 7: DayNight.alpha = 0.0f; break;
		case 8: DayNight.alpha = 0.0f; break;
		case 9: DayNight.alpha = 0.0f; break;
		case 10: DayNight.alpha = 0.0f; break;
		case 11: DayNight.alpha = 0.0f; break;
		case 12: DayNight.alpha = 0.0f; break;
		case 13: DayNight.alpha = 0.0f; break;
		case 14: DayNight.alpha = 0.0f; break;
		case 15: DayNight.alpha = 0.0f; break;
		case 16: DayNight.alpha = 0.0f; break;
		case 17: DayNight.alpha = 0.0f; break;
		case 19: DayNight.alpha = 0.4f; break;
		case 20: DayNight.alpha = 0.4f; break;
		case 21: DayNight.alpha = 0.4f; break;
		case 22: DayNight.alpha = 0.4f; break;
		case 23: DayNight.alpha = 0.4f; break;
		}
	}
	
	public void render(Graphics g) {	
		g.setFont(ff.clockFont);
		
		g.drawImage(Assets.clockTick[time], x - 35, y - 29, 32, 32, null);
		
		g.setColor(Color.WHITE);
		g.drawString(currentTime, x, y);
		
		g.setFont(ff.calendarFont);
		g.drawString("--------------", x - 35, y + 15);
		
		g.drawImage(Assets.calendarIcon, x - 31, y + 19, 16, 16, null);
		g.drawString(currentDate, x - 10, y + 33);
		
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getG_hours() {
		return g_hours;
	}

	public void setG_hours(int g_hours) {
		this.g_hours = g_hours;
	}

	public int getG_minutes() {
		return g_minutes;
	}

	public void setG_minutes(int g_minutes) {
		this.g_minutes = g_minutes;
	}

	public int getG_seconds() {
		return g_seconds;
	}

	public void setG_seconds(int g_seconds) {
		this.g_seconds = g_seconds;
	}
}
