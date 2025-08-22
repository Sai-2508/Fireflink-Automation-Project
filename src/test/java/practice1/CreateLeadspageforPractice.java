package practice1;

import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.win32.WinBase.THREAD_START_ROUTINE;

import ninzaCRm.genericUtilities.FileUtility;
import ninzaCRm.genericUtilities.WebDriverUtility;
import objectRepository.CreateLeadPage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;

public class CreateLeadspageforPractice {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub

		FileUtility fUtil= new FileUtility();
		WebDriverUtility wUtil= new WebDriverUtility();
		
		String BROWSER= fUtil.readDataFromPropertyFile("browser");
		String URL= fUtil.readDataFromPropertyFile("url");
		String USERNAME=fUtil.readDataFromPropertyFile("username");
		String PASSWORD= fUtil.readDataFromPropertyFile("password");
		
		WebDriver driver= null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}
		wUtil.maximizeWindow(driver);
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Thread.sleep(3000);
		
		LeadsPage lsp= new LeadsPage(driver);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		
		lsp.clickOnCreateLeadBtn();
		
		
		Thread.sleep(3000);
		
		CreateLeadPage cl= new CreateLeadPage(driver);
		Thread.sleep(3000);
		
		cl.createLeadWithCampaign(driver, "ABCD123", "Capgemini", "CDEF", "CAPGEMI", "7687987654", "Good" ,"5","RFCD455");
		
		driver.quit();
		
		
		
		
	}

}
