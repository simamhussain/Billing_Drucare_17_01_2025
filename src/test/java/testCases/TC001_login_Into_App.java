package testCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Patient_Registartion;
import testBase.BaseClass;

public class TC001_login_Into_App extends BaseClass {
      
	
	
	
	 @Test (groups={"Sanity", "Master"})
	 public void Verifying_login() 
	 {
		 
		 
		 try {
		/* logger.info("*****************Starting TC001_login_Into_App ****************");
		//Login to the Drucare Application
		 LoginPage lp=new LoginPage(driver);
		 lp.setUsername("jacimam");
		 lp.setPwd("Prod@123");
		 logger.info("********Clicked on Login****************");
		 lp.clickbutton(); */
		 
		 
		 //Navigating to Patient RegistationScreen
			 
			 
		logger.info("*********Navigating to Registartion Screen****************");
		 Patient_Registartion PR= new Patient_Registartion(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 PR.Mainmenu();
		 PR.MenuArrow();
		 PR.RegisPage();
		 }
		 catch(Exception e)
		 {
			 logger.error("Test Failed");
			 logger.debug("Debug logs...");
			 
		 }
		 logger.info("*****************Finished TC001_login_Into_App ****************");
	 }
}
