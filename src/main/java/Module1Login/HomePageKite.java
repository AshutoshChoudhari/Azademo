package Module1Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageKite
{
	
	
     @FindBy(xpath ="//span[text()='KXW990']") private WebElement userId;
	
	
     public HomePageKite(WebDriver driver) 
     {
    	 PageFactory.initElements(driver, this);
	}

     public String ttKiteHomePageID()
	{
		String actual = userId.getText();
		return actual;
	}
	

}
