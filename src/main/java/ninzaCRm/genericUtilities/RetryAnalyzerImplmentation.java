package ninzaCRm.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplmentation implements IRetryAnalyzer
{

	int count =0;
	int retrycount =3;//Manual Analysis
	public boolean retry(ITestResult result)
	{
		while(count<retrycount)  //recounts=3
		{
			count++;
			return true; //retry retry retry 
		}
		return false;  //stop retry
		
	}
	
}
