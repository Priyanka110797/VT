package PracticeBasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
	
		Date d=new Date();
	    System.out.println(d.toString());
	    //Output>>>>>>Thu Apr 02 15:19:58 IST 2026 gives current date and time
	    
	    //to get only Date
	    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
	    String currentDate=sdf.format(d);
	    System.out.println(currentDate);
	    
	    //to get date after 30 days
	    Calendar cal=sdf.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,30);
	    String dateReq=sdf.format(cal.getTime());
	    System.out.println(dateReq);
	    
	    
		

	}

}
