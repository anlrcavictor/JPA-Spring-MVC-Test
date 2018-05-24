package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utility {
	
	public static Date convertToDate(String stringDate) {
		Date date=new Date();
		DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		try {
			date=formatter.parse(stringDate);
//			System.out.println(date);
//			System.out.println(formatter.format(date));
			
//			System.out.println("---------------------CALENDAR---------------------------");
//			
//			Calendar c=Calendar.getInstance();
//			c.setTime(date);
//			c.add(Calendar.DATE, 1);
//			System.out.println(c.getTime());
//			date=c.getTime();
//			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	} 

	
	public static String convertFromDateToString(Date date) {
		
		DateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		
		return formatter.format(date);
	}
	
	public static Date SubMonthNow(int Month) {
		
		Date date=new Date();
		
			
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MONTH, -Month);
			date=c.getTime();
			
			return date;
	} 
	
	
	
}
