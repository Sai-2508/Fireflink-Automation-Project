//package practice;
//
//import java.time.Duration;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import ninzaCRm.genericUtilities.FileUtility;
//import ninzaCRm.genericUtilities.WebDriverUtility;
//import objectrepository.DashBoardPage;
//import objectrepository.LoginPage;
//
//public class NinzaCrmPurchaseOrder 
//{
//	public static void main (String[] args) throws Throwable  {
//
//		
//
//		WebDriver driver= null;
//
//		FileUtility fu= new FileUtility();
//
//		WebDriverUtility wutill=new WebDriverUtility();
//
//		
//
//		String BROWSER = fu.readDataFromPropertyFile("browser");
//
//		String URL = fu.readDataFromPropertyFile("url");
//
//		String USERNAME = fu.readDataFromPropertyFile("username");
//
//		String PASSWORD = fu.readDataFromPropertyFile("password");
//
//		
//
//		
//
//		//read testScript data from excel file
//
//		
//
//		
//
//		String testcaseName=fu.readDataFromExcel("Sheet1", 1, 1); 
//
//		System.out.println(testcaseName);
//
//		String contact_name=fu.readDataFromExcel("Sheet1", 1, 2);
//
//		String contact_Organization=fu.readDataFromExcel("Sheet1", 1, 3);
//
//		Random r = new Random();
//
//		int random = r.nextInt(99999999);
//
//		String contact_mobile=fu.readDataFromExcel("Sheet1", 1, 4)+random;
//
//		String contact_title=fu.readDataFromExcel("Sheet1", 1, 5);
//
//		String cpgid=fu.readDataFromExcel("Sheet1", 1, 6);
//
//		
//
//		String product_Quantity=fu.readDataFromExcel("Sheet1", 1, 7);
//
//		Random r1 = new Random();
//
//		int random1 = r1.nextInt(999);
//
//		String product_name=fu.readDataFromExcel("Sheet1", 1, 8)+random1;
//
//		//String product_price=row.getCell(9).toString();
//
//		String product_category=fu.readDataFromExcel("Sheet1", 1, 10);
//
//		String product_vendor = fu.readDataFromExcel("Sheet1", 1,11);
//
//		
//
//		//use equalIgnoreCase() because we don't know they are write in lowercase or not
//
//		if (BROWSER.equalsIgnoreCase("edge")){
//
//			
//
//			WebDriverManager.edgedriver().setup();
//
//			driver=new EdgeDriver();
//
//		}
//
//		else {
//
//			driver=new ChromeDriver();
//
//		}
//
//		
//
//		wutill.maximizeWindow(driver);
//
//		driver.get(URL);
//
//		LoginPage lp= new LoginPage(driver);
//
//		lp.logInToApp(USERNAME, PASSWORD);
//
//		
//
//		//driver.findElement(By.name("username")).sendKeys(USERNAME);
//
////		driver.findElement(By.name("password")).sendKeys(PASSWORD);
//
////		driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//
//		DashBoardPage dp=new DashBoardPage(driver);
//
//		dp.contactclick();
//
//		ContactsPage cp=new ContactsPage(driver);
//
//		cp.createContactClick();
//
//		CreateContactPage ccp=new CreateContactPage(driver);
//
//		ccp.createContact(driver, contact_name, contact_Organization, contact_title, contact_mobile, cpgid);
//
//	
//
//		dp.productClick();
//
//		ProductPage pp=new ProductPage(driver);
//
//		wutill.implicitlyWaits(driver);
//
//		pp.AddProductClick();
//
//		AddProductPage adp= new AddProductPage(driver);
//
//		adp.AddProduct(product_Quantity, product_Quantity, product_name, product_category, product_vendor);
//
//		
//
////		driver.findElement(By.xpath("//a[.='Products']")).click();
//
////		Thread.sleep(6000);
//
////		WebElement element = driver.findElement(By.xpath("//span[.='Add Product']"));
//
////		
//
////		element.click();
//
////		
//
////		driver.findElement(By.xpath("//input[@name='productName']")).sendKeys(product_name);
//
////		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(product_Quantity);
//
//////		WebElement element2 = driver.findElement(By.xpath("//input[@name='price']"));
//
//////		element2.clear();
//
//////		element2.sendKeys(product_price);
//
////		WebElement selele1 = driver.findElement(By.xpath("//select[@name='productCategory']"));
//
////		Select s1= new Select(selele1);
//
////		s1.selectByVisibleText(product_category);
//
////		WebElement selele2 = driver.findElement(By.xpath("//select[@name='vendorId']"));
//
////		Select s2= new Select(selele2);
//
////		s2.selectByVisibleText(product_vendor);
//
////		
//
////		driver.findElement(By.xpath("//button[text()='Add']")).click();
//
////		
//
//		
//
//		Thread.sleep(5000);
//
//		driver.quit();
//}
