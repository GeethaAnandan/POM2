package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM {

	WebDriver driver;
	
	@FindBy(xpath="//div/input[@name='username']")
	WebElement orangeHrmUserName;
	
	@FindBy(xpath="//div/input[@name='password']")
	WebElement orangeHrmPassword;
	
	@FindBy(xpath="//div/button[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//div/div/span/h6")
	WebElement title;
	
	public OrangeHRM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//get the user name from HomePage
	public void setUserName(String strUserName) {
		orangeHrmUserName.sendKeys(strUserName);
	}
	
	//set password in textbox
	public void setPasssword(String strPasswprd) {
		orangeHrmPassword.clear();
		orangeHrmPassword.sendKeys(strPasswprd);
	}
	
	//Click on login button
	public void clickLogin() {
		LoginBtn.click();
	}
	
	public String getLoginMessage() {
		return title.getText();
	}
	public void loginToOrangeHrmApplication(String strUserName, String strPasswprd) {
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPasssword(strPasswprd);
		//click login button
		this.clickLogin();
	}
	//get the me
}
