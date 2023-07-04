package TestCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import POM.JawwyTV_Page;

public class Verify_JawwyTV_TCs  extends TestBase  {
	
	public ExtentReports extent;
	public ExtentTest test;
	
	JawwyTV_Page JawwyTV;
	
	

	@Test	
	public void  TC_Verify_JawwyTV() throws IOException, InterruptedException {

		extent = new ExtentReports(System.getProperty("user.dir")+"\\Results\\TC_Verify_JawwyTV.html", true);

		test= extent.startTest("TC_Verify_JawwyTV");

		test.log(LogStatus.INFO, "TC_Verify_JawwyTV");
		
		
		JawwyTV= new JawwyTV_Page(driver);
		
		JawwyTV.Select_Country("UAE");
	
		boolean verify_price = JawwyTV.Verify_Price("10.00");
		
		boolean verify_Currency = JawwyTV.Verify_currency("AED");
		
		boolean verify_Type = JawwyTV.Verify_Type("CLASSIC");
	
		if(verify_price&&verify_Currency&&verify_Type) 
		{
			test.log(LogStatus.PASS, "Subscription Packages – Type & Price and Currency are correct Based on the selected country ");
		}
		else 
		{
			test.log(LogStatus.FAIL, "Subscription Packages – Type & Price and Currency are correct Based on the selected country");
		}
		extent.endTest(test);

		extent.flush();
	}
}
