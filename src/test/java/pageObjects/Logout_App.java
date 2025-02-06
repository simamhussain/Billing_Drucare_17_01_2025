package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout_App  extends BasePage{

	public Logout_App(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath="//button[contains(@class, 'dru-ico') or contains(@class, 'nav-selected-bg')]")
	WebElement Logout_icon;
	@FindBy(xpath="//li[normalize-space()='Logout']")
	WebElement logout_btn;

	   
	   public void logout_icon()
		{
			Logout_icon.click();
		}
		public void logout_btn() throws InterruptedException
		{
			logout_btn.click();
			Thread.sleep(5000);
			driver.quit();
		}
}
