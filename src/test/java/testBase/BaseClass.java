package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;       //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;
import pageObjects.Logout_App;
import pageObjects.Patient_Registartion;

public class BaseClass {
      
	
public Logger logger;    //Log4j
public Properties p;
	
	public static  WebDriver driver;
	
	 @BeforeClass(groups={"Sanity","Regression", "Master"})
	 @Parameters({"os" , "browser"})
	 public void setup(String os , String br) throws InterruptedException, IOException
	{
		 
		 //loading config.prperties file
		 FileReader file=new FileReader("C:\\Imam Selenium\\Web driver\\Billing_Drucare_17_01_2025\\src\\test\\resources\\config.properties");
		 p=new Properties();
		 p.load(file);
		 
		 
		 
		 logger=LogManager.getLogger(this.getClass());
		 switch(br.toLowerCase())
		 {
		 case "chrome" :driver=new ChromeDriver(); break;
		 case "edge" : driver = new EdgeDriver(); break;
		 case "Firefox" : driver= new FirefoxDriver(); break;
		 
		 default : System.out.println("Invaild Browser"); return;
		 }
		 
		 
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get(p.getProperty("appurl")); //Reading url from the Properties file.
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		// Login to the Drucare Application
				 LoginPage lp=new LoginPage(driver);
				 lp.setUsername("jacimam");
				 lp.setPwd("Prod@123");
				 logger.info("********Clicked on Login****************");
				 lp.clickbutton();
				 
				 
				 
				 logger.info("*********Navigating to Registartion Screen****************");
				 Patient_Registartion PR= new Patient_Registartion(driver);
				 PR.Mainmenu();
				 PR.MenuArrow();
				 PR.RegisPage();
		
	
}
	 
	
	 
	 
	//@AfterClass
		 public void testDown() throws InterruptedException
		{
			Logout_App LP=new Logout_App(driver);
			Thread.sleep(6000);
			LP.logout_icon();
			LP.logout_btn();
		}
	
	
	public String captureScreen(String tname) throws IOException{
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		
		
		
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourcefile= takescreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+ "\\screenshot" +tname+"_"+timeStamp;
		File targetFile= new File(targetFilePath);
		
		
		sourcefile.renameTo(targetFile);
		
		return targetFilePath;
		
		
	}
	
	
	
	
}
