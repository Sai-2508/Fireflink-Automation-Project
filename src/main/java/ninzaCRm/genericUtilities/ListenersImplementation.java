package ninzaCRm.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ItestListener of 	TestNg
 * @author Penugonda Sai Durga
 */
public class ListenersImplementation  implements ITestListener
{
	 	ExtentReports report;
	 	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		 String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Test Execution Started--------");
		
		//Intimate extent Reports for @test start
	 test	= report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Test Execution Success--------");
		
		//Log the status  of @Test as Pass in extent Report
		test.log(Status.PASS, methodname+"------Test Execution pass--------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Test Execution fails--------");
		
		
		//Log the status  of @Test as Pass in extent Report
				test.log(Status.FAIL, methodname+"------Test Execution Fail--------");
					
				
		//capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		
		//capture the screenshot
		JavaUtility j = new JavaUtility();
		WebDriverUtility w = new WebDriverUtility();
		
		//screenshotname-methodname+date and time
		String screenshotname =methodname+j.getSystemDate();
		try {
		String path = w.captureScreenShot(BaseClass.sdriver, screenshotname);
		
		//Attach screenshot to report
		test.addScreenCaptureFromPath(path);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------Test Execution skipped--------");
		
		//Log the skip status
		test.log(Status.SKIP, methodname+"------Test Execution skipped--------");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		test.log(Status.WARNING, result.getThrowable());
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		String methodname = result.getMethod().getMethodName();
//		System.out.println(methodname+"------suite Execution Failedwithin suceessPercentage--------");
//	}


//	public void onTestFailedWithTimeout(ITestResult result) {
//		String methodname = result.getMethod().getMethodName();
//		System.out.println(methodname+"------suite Execution FailedwithTimeout--------");
//	}

	@Override
	public void onStart(ITestContext context) {
		
		
		System.out.println("------suite Execution Started--------");
		
		//Extent Reoprt Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Extent-Reports"+new JavaUtility().getSystemDate()+".html");
				esr.config().setDocumentTitle("Ninza CRM Automation Report");
		
		         esr.config().setTheme(Theme.DARK);
		         esr.config().setReportName("Web Automation Execution Report ");
		         report= new ExtentReports();
		         report.attachReporter(esr);
		         report.setSystemInfo("Base Browser", "Microsoft Edge");
		         report.setSystemInfo("Base Url","Test Env" );
		         report.setSystemInfo("Base Platform", "Windows");
		         report.setSystemInfo("Report Name", "Penugonda Sai Durga");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("------suite Execution Finish--------");
		
		//Report Generation
		report.flush();
		
		
	}

	
}
