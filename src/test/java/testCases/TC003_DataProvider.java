package testCases;

import org.testng.annotations.Test;

import pageObjects.Creating_Patient;
import pageObjects.Patient_Registartion;
import testBase.BaseClass;
import utilities.dataproviders1;

public class TC003_DataProvider extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=dataproviders1.class)
	public void verify_registrationDDT(String first_name , String lastname, String ages ) throws InterruptedException {
		
		Creating_Patient Cp= new Creating_Patient(driver);
		
		Cp.switchToIframeAndClick();
		Thread.sleep(500);
		
		Cp.selectingHonor_Icon();
		
		
		Cp.selecting_honeric();
		
		Cp.first_name(first_name);
		
		Cp.last_name(lastname);
		
		Cp.age(ages);
		
		Cp.gender();
		Thread.sleep(500);
		
		Cp.savebutton();
	}
}
