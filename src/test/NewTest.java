package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
//khai bao driver
     
	WebDriver driver;
	@BeforeClass
  public void beforeClass() {
		driver = new FirefoxDriver();
		//wait cho page duoc loat thanh cong.
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//maximize brower len full screen
			driver.manage().window().maximize();
			//get ULR cua app
			driver.get("http://live.guru99.com/");
  }
  @Test
  public void TC_01_CheckTitle() {
	  String homePageTitle ="Home page";
	 Assert.assertEquals("Home page", homePageTitle);
	 
  }
  @Test
  public void TC_02_CheckURL() {
	  String homePageTitle = driver.getCurrentUrl();
	  Assert.assertEquals("http://live.guru99.com/", homePageTitle);
	 
	  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
