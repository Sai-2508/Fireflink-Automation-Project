package practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine
{

	@Test
	public void readData()
	{

		String BROWSER= System.getProperty("browser");
		System.out.println(BROWSER);
		
		String UN= System.getProperty("browser");
		System.out.println(UN);
		
		String PWD= System.getProperty("browser");
		System.out.println(PWD);
	}
}
