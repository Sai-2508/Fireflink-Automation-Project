package ninzaCRm.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of java utility functions
 * @author Penugonda Sai Durga
 */
public class JavaUtility {
	/**
	 * This method capture the current system date and return to the caller 
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		  String date = s.format(d);
		  return date;
     
		
		  
		
	}
	/**
	 * This method will generate random number and return it to the caller
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r = new Random();
		int random= r.nextInt(1000);
		return random ;
	}
	
	
	
	
	

}
