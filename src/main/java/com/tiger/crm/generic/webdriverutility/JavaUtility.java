package com.tiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random randomInt=new Random();
		int randomNum=randomInt.nextInt(5000);
		return randomNum;
	}
	
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String date=sdf.format(d);
		return date;
		
	}
	
	public String getRequiredDate(int days) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		sdf.format(d);
		Calendar c=sdf.getCalendar();
		c.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sdf.format(c.getTime());
		return reqDate;
	}
}
