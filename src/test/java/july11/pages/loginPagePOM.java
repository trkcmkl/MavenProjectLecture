package july11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPagePOM {
	public loginPagePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_name")
	public WebElement user;

	public WebElement username_password;

	@FindBy(id = "bigbutton")
	public WebElement Loginbutton;
	
	public void login(String username, String password) {
		user.sendKeys(username);
		username_password.sendKeys(password);
		Loginbutton.click();
	}

}
