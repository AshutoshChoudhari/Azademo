package Library2Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.events.EventException;

public class UtilityClass 
{
	private static final String TCID = null;



	//Utility class mhade aapan all selenium utility functions like get SC,open Exel,i-frame ext ch mentation 
	// karto and methods always static aste yaat bcz we can call it by classname.methodname and 
	// no need to perform inheritance bcz ya class mhade khup sarya methods aahe so inheritade kel 
	// call karachya aadhi khup jast memory load karavi lagnaar so thats why ststic aahe method
	
	
	
	
	
	// @ Author name:- Ashutosh
	//This method is use to get test data from exel sheet
	//need to pass 2 inputs :- 1.rowIndex 2.cellIndex
	public static String getIDExel(int rowIndex, int cellIndex) throws EventException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\91913\\eclipse-workspace\\ProjectMav\\Testdata\\Exel automation.xlsx");
	    Sheet sht = WorkbookFactory.create(file).getSheet("sheet5");
	    String value = sht.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	
	
	
	// @ Author name:- Ashutosh
	//This method is use to take SC of Fail TC
	// need to pass TCID
	public static void captureSC(WebDriver driver, int TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\91913\\eclipse-workspace\\ProjectMav\\Screenshorts\\testcaseID"+TCID+".jpg");
		org.openqa.selenium.io.FileHandler.copy(source, destination);
	}
	
	public static String getPropertyFiledata(String key) throws IOException
	{
		FileInputStream fil=new FileInputStream("C:\\Users\\91913\\eclipse-workspace\\ProjectMav\\proprrtyFile.properties");
		                                // here we nevigate to Property file
		
		// we have to open properties file using non static method load from properties class
		
		Properties prop=new Properties();
		prop.load(fil);
		String value = prop.getProperty(key);
		return value;
	}





	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
