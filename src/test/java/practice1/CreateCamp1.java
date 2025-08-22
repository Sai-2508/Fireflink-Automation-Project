package practice1;

import java.io.IOException;
import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ninzaCRm.genericUtilities.FileUtility;
import ninzaCRm.genericUtilities.WebDriverUtility;
import objectRepository.CampaignPage;
import objectRepository.CreateCampaignPage;
import objectRepository.LoginPage;

public class CreateCamp1 {

	
		@Test
		public void CampTest() throws InterruptedException, IOException
		{

		FileUtility fUtil= new FileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String BROWSER= fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME= fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		 else if (BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();

		 }
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			driver= new EdgeDriver();
		}
		
		wUtil.maximizeWindow(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		CampaignPage cp = new CampaignPage(driver);
		
		Thread.sleep(3000);
		
		cp.clickOnCreateCampaignBtn();
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		
		ccp.createCampaign("QWWER12343", "3");
		
		
		
		
		
		
	}

}
