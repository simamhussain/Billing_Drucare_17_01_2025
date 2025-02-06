package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Patient_Registartion extends BasePage {

	public Patient_Registartion(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//button[@id='sidenav-toggler']")
	WebElement side_menu;
	@FindBy(xpath="//li[3]//span[2]//i[1]")
	WebElement Registration_Arrow;
	@FindBy(xpath="//div[normalize-space()='Patient Registration']")
	WebElement Regis_page;
	
	public void Mainmenu() 
	{
		side_menu.click();
	}
	public void MenuArrow()
	{
		Registration_Arrow.click();
	}
	public void RegisPage()
	{
		Regis_page.click();
	}
	
	
}
