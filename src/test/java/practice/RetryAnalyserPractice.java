package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice
{
@Test(retryAnalyzer = ninzaCRm.genericUtilities.RetryAnalyzerImplmentation.class)
public void sample()
{
	Assert.fail();
	System.out.println("Demo");
}

}

	