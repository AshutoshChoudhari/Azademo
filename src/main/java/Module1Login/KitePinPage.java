package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KitePinPage
//POM class2
{
	
	@FindBy(xpath = "//input[@type='password']")private WebElement pin;
	@FindBy(xpath = "//button[@type='submit']")private WebElement cntbtn;

	
	
	KitePinPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void inpKitepinPagepin(String PIN)
	{
		pin.sendKeys(PIN);
	}

	public void inpKitepinPagecntnubtn()
	{
		cntbtn.click();;
	}
}
