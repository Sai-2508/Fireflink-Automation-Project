package ninzaCRm.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * This class consists of generic methods related to webDriver
 * @author Penugonda Sai Durga
 */

public class WebDriverUtility {
	
	//maximize
	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * This method will do the fullscreen
	 * @param driver
	 */
	public void fullscreenWindow(WebDriver driver)
	{
	driver.manage().window().fullscreen();
	
    }
	
	
	
	
	//implicitly wait,explicitly- visible,clickable
	
	//implicitlywait
	
	/**
	 * This method will do the implicitWait for 10sec
	 * @param driver
	 */
	
	public void implicitlyWait( WebDriver driver)
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method performs the explicit wait
	 * @param driver
	 */
	
	public void explicitlyWait(WebDriver driver,WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	
		
	}
	
	
	
	
	
	
	//handle dropdown-listbox
	/**
	 * This method is used to handle the dropdowns buy value
	 * @param value
	 * @param element
	 */
	
	public void handleDropDown(String value,WebElement element)
	{
		
	 Select s = new Select(element);
	 s.selectByValue(value);
		
	}
	
	
	/**
	 * This method is used to handle the dropdown by using the index 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) 
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * This method is used to handle the dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	//actions class-mouseovering,drag and drop,click and hold,release,move by offset,double click,context click
	/**
	 * This method is doing the mouseOvering
	 * @param driver
	 * @param ele
	 */
	
	public void ActionsClassMouseovering(WebDriver driver,WebElement ele )
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	/**
	 * This method click the elements
	 * @param driver
	 * @param ele
	 */
	
	public void ActionsClassclick(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		 act.click().perform();
		
	}
	/**
	 * This method is used to double click the element
	 * @param driver
	 * @param ele
	 */
	public void ActionsClassDoubleClick(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method performs the contextClick
	 * @param driver
	 * @param ele
	 */
	
	public void ActionsClassContextClick(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method perform the drag and drop operations
	 * @param driver
	 * @param src
	 * @param trg
	 */
	public void ActionsClassDragandDrop(WebDriver driver,WebElement src,WebElement trg)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, trg).perform();
		
	}
	/**
	 * This method performs the click and hold
	 * @param driver
	 * @param ele
	 */
	
	public void ActionsclassClickAndHold(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.clickAndHold().perform();
		act.release();
	}
	
	
	
	
	/**
	 * This methos is used to scroll the element by 500 units
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver)
	{
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)","");
	
	}
	
	
	
	//handelframes 
	/**
	 * Handle the frames switch to another frame by using the id
	 * @param driver
	 * @param id
	 */
	
	public void handleframe(WebDriver driver,int id)
	{
		driver.switchTo().frame(id);
	}
	 
	/**
	 * This method is used to switch to another frame by using the value 
	 * @param driver
	 * @param val
	 */
	public void handleframestring(WebDriver driver,String val)
	{
		driver.switchTo().frame(val);
	}
	
	/**
	 * This method is used to switch to another frame by using the index
	 * @param driver
	 * @param index
	 */
	public void handleframeindex(WebDriver driver ,int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to the parent frame
	 * @param driver
	 */
	public void handleframeParentframwe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method is used to switch to the main frame
	 * @param driver
	 */
	
	public void handleframesdefaultcontent(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	
	
	
	//handling alert
	/**
	 * This method performs the alert by using accept
	 * @param driver
	 */
	
	public void handlingalertsUsingAccept(WebDriver driver)
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	/**
	 * This method performs the alert by giving the sendkeys
	 * @param driver
	 * @param keys
	 */
	
	public void handlingalertsUisngsendkeys(WebDriver driver,String keys)
	{
		 driver.switchTo().alert().sendKeys(keys);
	}
	
	/**
	 * This method performs alert by using the dismiss
	 * @param driver
	 */
	public void handlingalertsUsingDismiss(WebDriver driver) {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}
	/**
	 * This method performs the alert by using the gettext()
	 * @param driver
	 */
	
	public void handlealeretsusinggettext(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	
	
	//handles window
	/**
	 * This method is used to get the windowhandles from parent to child
	 * @param driver
	 */
	
	public void WindowHandle(WebDriver driver)
	{
		  String parent = driver.getWindowHandle();
		  	
		   Set<String> child = driver.getWindowHandles();
		   for(String handle:child)
		   {
			   if(handle.equals(parent))
			   {
				   driver.switchTo().window(handle);
				   
			   }
		   }
	}
	/**
	 * This method is to get the windowhandles for each window
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		// Step 1: Capture all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();

		// Step 2: Navigate to each window ID
		for (String winID : allWinIDs) {
			// Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();

			// Step 4: compare the title with required title
			if (actTitle.contains(partialWinTitle)) 
			{
				break;
			}
		}

		}
		
		
		/**
		 * This method is used to get the screenshots and return the path to the caller
		 * @param driver
		 * @param screenShotName
		 * @return
		 * @throws IOException
		 */
		
		
		public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File(".\\Screenshots\\" + screenShotName + ".png");

			
		   FileHandler.copy(src, dst);
			

			return dst.getAbsolutePath(); // for extent reports
		
		
		
		
		
		
		
		}
	
	
	
	
}
