package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Creating_Patient extends BasePage{

	public Creating_Patient(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	


	    
	    // Find Honorific Icon element inside iframe
	    @FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[2]")
	    WebElement Honorific_Icon;
	    
	    // Find Mr Honor element inside iframe
	    @FindBy(xpath = "//span[normalize-space()='Mr.']")
	    WebElement Mr_Honor;
	    
	    @FindBy(xpath = "//input[@placeholder='Enter First Name']")
	    WebElement First_name;
	    @FindBy(xpath = "//input[@placeholder='Enter Last Name']")
	    WebElement last_name;
	    @FindBy(xpath = "//input[@id='ageYears']")
	    WebElement ageyear;
	    @FindBy(xpath = "//label[normalize-space()='Male']")
	    WebElement Gender;
	    @FindBy(xpath = "//button[normalize-space()='Save']")
	    WebElement savebtn;
 
	    
	    // Method to switch to iframe and click Honorific icon
	    public void switchToIframeAndClick() {
	    	 WebElement frame1 =driver.findElement(By.xpath("//iframe[@src='https://in.dru.care/registration/#/patient-registration']"));
	 		
	 		driver.switchTo().frame(frame1);
	 		
	    }

	   
	    public void selectingHonor_Icon() {
	    	
	    	Honorific_Icon.click();
	      
	    }

	   public void selecting_honeric()
	   {
		   Mr_Honor.click();
	   }
	   public void first_name(String name)
	   {
		   First_name.sendKeys(name);
	   }
	   public void last_name(String lastname)
	   {
		  last_name.sendKeys(lastname);
	   }
	   public void age(String years)
	   
	   {
		   ageyear.sendKeys(years);
		   
	   }
	   public void gender()
	   {
		   Gender.click();
	   }
	   public void savebutton()
	   {
		   savebtn.click();
	   }
}
