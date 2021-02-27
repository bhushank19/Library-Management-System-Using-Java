package pojo;

import java.time.LocalDateTime;

public class Date {
	private int day,month,year,sec,minutes,hour;
	public Date() {
		LocalDateTime date= LocalDateTime.now();
		this.day=date.getDayOfMonth();
		this.month=date.getMonthValue();
		this.year=date.getYear();
		this.sec=date.getSecond();
		this.minutes=date.getMinute();
		this.hour=date.getHour();	
	}
	public Date(int day, int month, int year, int sec, int minutes, int hour) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.sec = sec;
		this.minutes = minutes;
		this.hour = hour;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + ", sec=" + sec + ", minutes=" + minutes
				+ ", hour=" + hour + "]";
	}
}
