package NinzaCrm.CampaignTest;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRm.genericUtilities.BaseClass;
import objectRepository.CampaignPage;
import objectRepository.CreateCampaignPage;
import objectRepository.CreateContactsPage;
import objectRepository.DashBoardPage;

@Listeners(ninzaCRm.genericUtilities.ListenersImplementation.class)
public class CampaignTest  extends BaseClass
{

	@Test(groups = { "Smoke-Suite","Regression2"})
	public void CreateCampaignTest() throws IOException, InterruptedException
	
	{
		
		CampaignPage cp = new CampaignPage(driver);
		CreateCampaignPage CCP = new CreateCampaignPage(driver);
		
		Thread.sleep(2000);
		
		cp.clickOnCreateCampaignBtn();
		//Low level reporting example using
		Reporter.log("Campaign Created Successfully",true);
		
		//Forcefully fails the steps
		//Assert.fail();
		CCP.createCampaign("asdfg365", "3");
		Reporter.log("Campaign Created Successfully",true);
		
		
	
		
	}
	
//	@Test
//	public void sample()
//	{
		
//	}
	
	
	
	
}
