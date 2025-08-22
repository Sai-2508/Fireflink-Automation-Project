package practice1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.reporters.jq.Main;

public class LogintoApp

{
     public static void main(String[] args) throws IOException, InterruptedException {
    	 FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
    	 
    	 Properties pobj= new Properties();
    	 
    	 pobj.load(fis);
    	 
       String BROWSER = pobj.getProperty("browser");
        String URL = pobj.getProperty("url");
         String USERNAME = pobj.getProperty("username");
        String PASSWORD = pobj.getProperty("password");
        
        Thread.sleep(3000);
        WebDriver driver = null;
        if(BROWSER.equals("chrome"))
        {
        	driver=new ChromeDriver();
        }
        else if (BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
        else {
			driver= new FirefoxDriver();
		}
        
          driver.findElement(By.name("username")).sendKeys(USERNAME);
		  driver.findElement(By.name("password")).sendKeys(PASSWORD);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[text()='Invoice']")).click();
		  Thread.sleep(2000);
		  driver.quit();
        
	
}
}

