package ninzaCRm.genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.DashBoardPage;
/**
 * This class is the base class 
 */
import objectRepository.LoginPage;



public class BaseClass
{
	private static final boolean True = true;
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil= new WebDriverUtility();
	public JavaUtility jUtil= new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
 
	@BeforeSuite(alwaysRun = True)
	public void bsConfig()
	{
		System.out.println("=========DB Connection Successful========");
	}
	//@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = True)
	public void bcconfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String  URL= fUtil.readDataFromPropertyFile("url");
		if(BROWSER.equals("edge"))
		   {
			   WebDriverManager.edgedriver().setup();
			   driver=new EdgeDriver();
		   }
		   else if (BROWSER.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			   driver= new FirefoxDriver();
		}
		
		wUtil.maximizeWindow(driver);

		driver.get(URL);

		System.out.println("-------Browser updated----------");
		//For Listeners
		sdriver= driver;

	}

	@BeforeMethod(alwaysRun = True)

	public void bmconfig() throws Throwable {

		String USERNAME = fUtil.readDataFromPropertyFile("username");

		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		LoginPage lp= new LoginPage(driver);

		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("-------------------login successful-----------------------------");

		

	}
		
	
     @AfterMethod(alwaysRun = True)

 	public void amconfig() throws InterruptedException {

 		DashBoardPage dbp=new DashBoardPage(driver);

 		dbp.logoutOfApp(driver);

 		System.out.println("-------------------logout successful------------------------");

 	}

  //   @AfterTest
 	@AfterClass(alwaysRun = True)

 	public void acconfig() {

 		driver.quit();

 		System.out.println("------------Browser closed-------------------");

 	}

 	@AfterSuite(alwaysRun = True)

 	public void asconfig() {

 		System.out.println("-----------db close---------------------------------");

 	}



 }
     
     
	
		

	

