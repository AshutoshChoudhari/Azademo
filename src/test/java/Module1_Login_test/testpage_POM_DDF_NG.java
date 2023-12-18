package Module1_Login_test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library2Files.BasicClass;
import Library2Files.UtilityClass;
import Module1Login.HomePageKite;
import Module1Login.KiteLoginPage;
import Module1Login.KitePinPage;
import POM_with_DDF.KiteHomePage;

public class testpage_POM_DDF_NG extends BasicClass
{
	KiteLoginPage login;
	KitePinPage pin;
	KiteLoginPage home;
	Sheet sht;
	//WebDriver driver;
	HomePageKite usr;
	int TCID;

	
	
	@BeforeClass
	public void openbrowser() throws EncryptedDocumentException, IOException
	{
//		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--disable-notifications");
		
		
		
//		FileInputStream file=new FileInputStream("C:\\Users\\91913\\Desktop\\java selenium\\Exel automation.xlsx");
//	    sht = WorkbookFactory.create(file).getSheet("sheet5");
//		
		Initilizedbrowser(); // can call 1 non static method to another non static method
		
//		System.setProperty("webdriver.chrome.driver",
//		"C:\\Users\\91913\\Desktop\\java selenium\\chromedriver_win32\\chromedriver.exe");
//
//	   driver=new ChromeDriver(option);
//		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		
//		driver.get("https://kite.zerodha.com/");
		
	    login =new KiteLoginPage(driver);
		pin=new KitePinPage(driver);
	    home=new KiteHomePage(driver);
	    usr=new HomePageKite(driver);
		
	}

	@BeforeMethod
	public void loginapp() throws InterruptedException, EncryptedDocumentException, IOException
	{
//		login.inpKiteloginPageUsername(sht.getRow(1).getCell(0).getStringCellValue());
//		login.inpKiteloginPagePassword(sht.getRow(1).getCell(1).getStringCellValue());
//		
//		login.inpKiteloginPageUsername(UtilityClass.getIDExel(1, 0));
//		login.inpKiteloginPagePassword(UtilityClass.getIDExel(1, 1));
		
		login.inpKiteloginPageUsername(UtilityClass.getPropertyFiledata("UN"));
		login.inpKiteloginPagePassword(UtilityClass.getPropertyFiledata("PSD"));
	
		login.inpKiteloginloginbtn();
		
		
		Thread.sleep(3000);
		
		//pin.inpKitepinPagepin(sht.getRow(1).getCell(2).getStringCellValue());
		
		pin.inpKitepinPagepin(UtilityClass.getPropertyFiledata("PIN"));
		pin.inpKitepinPagecntnubtn();
	}

	@Test
	public void verifyuserID() throws EncryptedDocumentException, IOException
	{
	//	home.inpKitehomePageuserid(sht.getRow(1).getCell(3).getStringCellValue());
        
		TCID=101;
		String actual=usr.ttKiteHomePageID();
		//String expected=sht.getRow(1).getCell(3).getStringCellValue();
		String expected=UtilityClass.getPropertyFiledata("ID");
		org.testng.Assert.assertEquals(actual, expected,"not Matched");
		
	}
	
	@AfterMethod
	public void logoutapp(ITestResult result) throws IOException 
	                                          // test result get kara lagte &store it in result obj
	{                                         // by calling ItestResult interface and then compare 
		                                      // it with failure if fail take SC by calling method 
		                                      // from UtilityClass
		
		
		if(result.getStatus()==ITestResult.FAILURE); //getting test result  it always return us fail 
		{
			UtilityClass.captureSC(driver, TCID);
			
		}
		
	}
	
	
	@AfterClass
	
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.close();
	}
}
