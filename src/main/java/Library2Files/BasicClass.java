package Library2Files;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicClass //create sept method for open browser jane karun praytek test class mhade 
                       // repeat toch browser open karacha code nahi lihava lagnaar and 
                       // if kahi change so we can change from one location for all test class 
// Baseclass contain code related to open browser only (@parameter cha use karun multi browser pan 
// karu shakto)
{
	
	public WebDriver driver; // yala public karu shakto to increase scope from current pacakge to all package
	
	
	public void Initilizedbrowser() throws IOException
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\91913\\eclipse-workspace\\ProjectMav\\Browsers\\chromedriver.exe");

	  driver=new ChromeDriver(option);
				
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
	//driver.get("https://kite.zerodha.com/");
	driver.get(UtilityClass.getPropertyFiledata("URL"));
				
	}

}
