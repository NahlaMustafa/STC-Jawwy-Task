package TestCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public  WebDriver driver;
	
	
	@BeforeTest

	@Parameters(("browser"))
	public void intiateDriver(@Optional("chrome")  String browserName) {

		if(browserName.equals("chrome")) 
		{
			String chromePath=System.getProperty("user.dir")+"\\Drivers2\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver",chromePath);

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--start-maximized");

		//TestBase.driver = new ChromeDriver(options);
		
			driver = new ChromeDriver(options);
			
			 //driver= new ChromeDriver();
				
		}
		
	

		driver.navigate().to("https://subscribe.jawwy.tv/eg-en");
		
		


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	

	@AfterTest

	public void StopDriver() {
		driver.quit();
	}


}
