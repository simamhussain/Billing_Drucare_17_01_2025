package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[@id='UserName']") 
	WebElement loc_username;
	@FindBy(xpath="//input[@placeholder='Enter your password']") 
	WebElement loc_pwd;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loc_btn;
	
	
	public void setUsername(String user)
	{
		loc_username.sendKeys(user);
	}
	public void setPwd(String Pwds) 
	{
		loc_pwd.sendKeys(Pwds);
	}
	public void clickbutton()
	{
		loc_btn.click();
	}

}
