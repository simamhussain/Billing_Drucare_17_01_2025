package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import pageObjects.Creating_Patient;
import testBase.BaseClass;


public class TC002_Registering_patient extends BaseClass{

	@Test(groups={"Regression"," Master"})
	public void Creating_Firstname() throws InterruptedException
	{
		
		try {
			
		logger.info("********Starting patient Registartion*****");
		Creating_Patient Cp= new Creating_Patient(driver);
		
		Cp.switchToIframeAndClick();
		Thread.sleep(600);
		logger.info("********clicking on   patient Honorific icon*****");
		Cp.selectingHonor_Icon();
		
		logger.info("********Selecting  patient Honorific*****");
		Cp.selecting_honeric();
		logger.info("********Patient first name*****");
		Cp.first_name("Mkl");
		logger.info("********Patient last name*****");
		Cp.last_name("MKLIJK");
		logger.info("********Patient age*****");
		Cp.age("21");
		logger.info("********Patient gender*****");
		Cp.gender();
		Thread.sleep(600);
		logger.info("********clicking on save btn*****");
		Cp.savebutton();
		}
		catch(Exception e)
		{
			 logger.error("Test Failed");
			 logger.debug("Debug logs...");
		}
		 logger.info("*****************Finished TC002_Registarting_patient ****************");
	 
				
	}
	/* public String randomeString() {
		 String generatestring= RandomStringUtils.randomAlphabetic(5);
		 return generatestring;
	 }
	 public String randomeNumberic() {
		 
		 String generatenumber= RandomStringUtils.randomNumeric(3);
		 return generatenumber;
	 } */
	

	
	
}
	
