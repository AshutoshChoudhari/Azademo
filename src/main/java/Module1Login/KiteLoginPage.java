package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage 
//POM class 1
{
	
	
	@FindBy(xpath = "//input[@type='text']")private WebElement UN;
	@FindBy(xpath = "//input[@type='password']")private WebElement PSD;
	@FindBy(xpath = "//button[@type='submit']")private WebElement loginbtn;
	
	
	
	
	public KiteLoginPage(WebDriver driver)        // webdriver -- datatype
	                                       // driver   ----variable
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void inpKiteloginPageUsername(String Uname)     // actionperform.onwhichpage.onwhichelement
	{
		UN.sendKeys(Uname);
	}

	public void inpKiteloginPagePassword(String psd)
	{
		PSD.sendKeys(psd);
	}
	
	public void inpKiteloginloginbtn()
	{
		loginbtn.click();;
	}
}
