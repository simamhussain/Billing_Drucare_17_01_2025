package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReport implements ITestListener{
	

	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	
	public void onStart(ITestContext testcontext) {
		
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		
		repName = "Test-Report-" + timeStamp +".html";
		
		sparkReporter = new ExtentSparkReporter("C:\\Imam Selenium\\Web driver\\Billing_Drucare_17_01_2025\\reports"+repName);
		
		sparkReporter.config().setDocumentTitle("BillingModule");
		sparkReporter.config().setReportName("DrucareFuntionalTesting");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Drucare");
		extent.setSystemInfo("Module", "Billing");
		extent.setSystemInfo("SubModule", "Patiengt Screen");
		extent.setSystemInfo("Username", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
		
		
		String os =testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		
		String browser =testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		
		List<String> includedGroups =testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"got successfuly executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		
		try {
			String imgPath= new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
			
			}
	    catch(IOException e1){
	    	
	    	
	    	e1.printStackTrace();
	    	
	    }
	}
	    
	
	public void onTestSkipped(ITestResult result)
	{
		test= extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got SKIPPED");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
		
		
		
		//String pathofExtentReport =System.getProperty(" C:\\Imam Selenium\\Web driver\\Billing_Drucare_17_01_2025\\reports"+repName );
		//File extentReport = new File(pathofExtentReport);
		
		    String reportFilePath = "C:\\Imam Selenium\\Web driver\\Billing_Drucare_17_01_2025\\reports"; // Set the correct path
		    if (reportFilePath != null && !reportFilePath.isEmpty()) {
		        try {
		            File reportFile = new File(reportFilePath);
		            Desktop.getDesktop().browse(reportFile.toURI());
		            // Continue with report generation logic
		        } catch (Exception e) {
		            System.out.println("Error while creating the file: " + e.getMessage());
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("Invalid file path: " + reportFilePath);
		    }
		

		
		/*try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}*/
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
