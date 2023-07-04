package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JawwyTV_Page extends PageBase 
   {
	public JawwyTV_Page (WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver , this);
	}
	
	
	@FindBy(xpath = "//div[2]/div")
	public WebElement country_ ;

	@FindBy(xpath = "//div[3]/div/b")
	public WebElement price_ ;
	
	@FindBy(xpath = "//div/div/div[3]/div")
	public WebElement currency_ ;
	
	@FindBy(xpath = "//h4")
	public WebElement Type_ ;
	
	@FindBy(xpath = "//a[2]/span[2]")
	public WebElement country_selected ;
	
	public void Select_Country(String country) {
		
		country_.click();
		
			String country_name = country_selected.getText().trim();
			
			if(country_name.equals(country))
			{
				country_selected.click();	
			}
		}
	
	public boolean Verify_Price (String price)
	{
		boolean con = false ;
		
		if(price_.getText().trim().equals(price))
		{
			con = true;
		}
		
		return con ; 
	}
	
	public boolean Verify_currency (String currency)
	{
		boolean con = false ;
		
		String price= price_.getText().trim();
		String get_curr = currency_.getText().replace("From", "").replace(price, "").trim();
		
		int curr_pos = get_curr.indexOf("/");
	
		
		String curr_name = get_curr.substring(0,curr_pos);
		
		if(curr_name.equals(currency))
		{
			con = true;
		}
		
		return con ; 
	}
	
	public boolean Verify_Type (String type)
	{
		boolean con = false ;
		
		String Type_name = Type_.getText().trim();
		
		if(Type_name.equals(type))
		{
			con = true;
		}
		return con;
	}
	
	
	
}
