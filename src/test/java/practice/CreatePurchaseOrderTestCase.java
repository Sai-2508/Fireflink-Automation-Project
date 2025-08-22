package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchaseOrderTestCase {

	public static void main(String[] args) throws IOException, InterruptedException {
		  WebDriver driver= null;
		//WebDriver driver = null;
  FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\CommonData.properties");
  Properties p = new Properties();
  p.load(fis);
  String browser = p.getProperty("browser");
  String url = p.getProperty("url");
  String USERNAME = p.getProperty("username");
  String PASSWORD = p.getProperty("password");
 
   if(browser.equals("edge"))
   {
	   WebDriverManager.edgedriver().setup();
	   driver=new EdgeDriver();
   }
   else if (browser.equals("firefox")) {
	 
	   driver= new FirefoxDriver();
}
   
  
   driver.manage().window().maximize();
  
   driver.get(url);
   driver.findElement(By.id("username")).sendKeys(USERNAME);
   driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
   driver.findElement(By.xpath("//button[text()='Sign In']")).click();

   
   FileInputStream fiss = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.AutomationFramework\\src\\test\\resources\\testData.xlsx");
   
   Workbook wb = WorkbookFactory.create(fiss);
   Sheet sh = wb.getSheet("Sheet1");
   Row row = sh.getRow(1);
   String ContactName = row.getCell(2).getStringCellValue();
   
   String Organization=row.getCell(3).getStringCellValue();
   String Mobile = row.getCell(4).getStringCellValue();
   String Title=row.getCell(5).getStringCellValue();
   String CampaignId=row.getCell(6).getStringCellValue();
   String Email=row.getCell(7).getStringCellValue();
   String product_name= row.getCell(8).getStringCellValue();
   String Product_Category=row.getCell(9).getStringCellValue();
   String Product_Quantity= row.getCell(10).getStringCellValue();
   String Product_Price=row.getCell(11).getStringCellValue();
   String Purchase_subject= row.getCell(12).getStringCellValue();
  // String Purchase_Duedate=row.getCell(13).getStringCellValue();
   String Purchase_BillingAddress=row.getCell(14).getStringCellValue();
   String Purchase_ShippingAddress= row.getCell(15).getStringCellValue();
   String Purchase_BillingPOBox= row.getCell(16).getStringCellValue();
   String Shiping_poBox= row.getCell(17).getStringCellValue();
   String Billing_city= row.getCell(18).getStringCellValue();
   String city = row.getCell(19).getStringCellValue();
   String Billing_State= row.getCell(20).getStringCellValue();
   String State= row.getCell(21).getStringCellValue();
   String Billingpostalcode=row.getCell(22).getStringCellValue();
  
   
   
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
   driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
   driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(ContactName);
   driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(Organization);
   String mainwin = driver.getWindowHandle();
   driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(Mobile);
   driver.findElement(By.xpath("//input[@name='title']")).sendKeys(Title);
   driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Email);
   driver.findElement(By.xpath("//input[@type='text']/following-sibling::button[@type='button']")).click();
   
//    Set<String> winHan = driver.getWindowHandles();
//    
//    for(String win:winHan)
//    {
//    	if(win.equals(mainwin))
//    	{
//    		driver.switchTo().window(win);
//    	}
//    }
//   driver.manage().window().maximize();
 //  driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(CampaignId);
//   while(true)
//   {
//	   try
//	   {
//		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		   driver.findElement(By.xpath("//td[text()='CAM05313']/following::button[@class='select-btn']")).click();
//		   break;
//	   }
//	   catch (Exception e) {
//		driver.findElement(By.xpath("//button[@id='next-btn']")).click();
//	}
//   }

   Set<String> winHan1 = driver.getWindowHandles();

	for(String win:winHan1) {

		if(!win.equals(mainwin)) {

			driver.switchTo().window(win);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.manage().window().maximize();

			WebElement element = driver.findElement(By.xpath("//input[@id='search-input']"));

			element.click();

			element.sendKeys(CampaignId);

			driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			

		}	

	}

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	driver.switchTo().window(mainwin);

	driver.findElement(By.xpath("//button[text()='Create Contact']")).submit();

	

	driver.findElement(By.xpath("//a[.='Products']")).click();

	Thread.sleep(6000);

	WebElement element = driver.findElement(By.xpath("//span[.='Add Product']"));

	

	element.click();

	

	driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(product_name);

	driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(Product_Quantity);

//	WebElement element2 = driver.findElement(By.xpath("//input[@name='price']"));

//	element2.clear();

//	element2.sendKeys(product_price);

	WebElement selele1 = driver.findElement(By.xpath("//select[@name='productCategory']"));

	Select s1= new Select(selele1);

	s1.selectByVisibleText(Product_Category);

	WebElement selele2 = driver.findElement(By.xpath("//select[@name='vendorId']"));

	//Select s2= new Select(selele2);

//	s2.selectByVisibleText(Product_Vendor);

	

	driver.findElement(By.xpath("//button[text()='Add']")).click();

	

	Thread.sleep(5000);

	driver.quit();

 
   
   
	 
	
	
	


	}

}
