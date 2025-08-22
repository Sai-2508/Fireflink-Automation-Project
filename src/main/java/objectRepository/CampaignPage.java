package objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRm.genericUtilities.WebDriverUtility;

public class CampaignPage extends WebDriverUtility
{

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(xpath = "//select[@class='form-control']")
	private WebElement searchDropdown;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchTF;
	
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	public WebElement getSearchDropdown() {
		return searchDropdown;
	}
	
	//Business Library
	
	/**
	 * This method will click on create campaign button
	 * 
	 */

	public void clickOnCreateCampaignBtn() {
		createCampaignBtn.click();

	}
	
	/**
	 * This method will search for campaign info from  drop down and enter data
	 * @param visibleText
	 * @param campaignInfo
	 */
	public void searchAndEnterCampaignData(String visibleText,String campaignInfo)
	{
		handleDropDown(visibleText, searchDropdown);
		searchTF.sendKeys(campaignInfo,Keys.ENTER);
	}

	

	
	
	
	
	
	
	
	
	
}
