package POM;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {

	
	  static  WebDriver driver;
	
	public PageBase ( WebDriver driver) {

		PageFactory.initElements(driver, this);
}


	protected static void EnterText(WebElement txt , String userTxt) {
		txt.click();
		txt.clear();
		txt.sendKeys(userTxt);
	}

	protected static void Click_Button(WebElement button) {
		button.click();
	}
	
	@FindBy(css= ".toast-message")
	public WebElement sucessMsg ;

	public String ToastMessage() 
	{
		String txt = "";
		txt = sucessMsg.getText().trim();
		return txt; 
	}

	
	
	
	
	
	
	
	
	
}
