package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.OrangeHRM;


public class TestOrangeHRMApp {
	
	WebDriver driver;
	OrangeHRM orangehrm ;
	
	@BeforeClass
	public void loginToApplication()

	{
		WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\003SW7744\\Desktop\\Drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test_OrangeHRM_Loginpage() {
		orangehrm = new OrangeHRM(driver);
		orangehrm.loginToOrangeHrmApplication("admin", "admin123");
		String loginPageMessage = orangehrm.getLoginMessage();
		Assert.assertEquals(loginPageMessage, "Dashboard");
	}

}
