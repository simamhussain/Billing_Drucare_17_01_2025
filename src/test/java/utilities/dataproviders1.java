package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataproviders1 {
	
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="C:\\Imam Selenium\\Web driver\\Billing_Drucare_17_01_2025\\testData\\LoginData.xlsx";//  taking xl file from the testdata
		
		UtilitisFile xlsx= new UtilitisFile(path); //creating object for the utility file
		
		int totalrows= xlsx.getRowCount("Sheet1");
		
		int totalcolumns=xlsx.getCellcount("Sheet1" , 1);
		
		String loginData[][]=new  String[totalrows][totalcolumns];//created for two dimenstions array which can story the data 
		
		for(int i=1;i<=totalrows;i++) { //1  // read the data from xl storing in two  deminsional array
			for(int j=0; j<=totalcolumns ;j++) { //0 //i is rows j is column
				
				
				
				loginData[i-1][j] =xlsx.getCellData("Sheet1", i, j); //1,0
			}
		}
		return loginData; // returning two dimension array 
				

}
}

