package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BT_Xpath {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.guru99.com/");
  }
  @Test
  public void TC_02_Login_Empty() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String emailErrorMsg=driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals("This is a require file", emailErrorMsg);
	  String passErrorMsg= driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals("This is a require file", passErrorMsg);
  }
  @Test
  public void TC_03_Login_With_Email_Invalid() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("12345@536744");
//	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String emailErrorMsg=driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals("Pleas enter a vailb email address. For example Johndone@doman.com", emailErrorMsg);
  }
  @Test
  public void TC_04_Login_With_Password_Incorrect() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[contains(text(),'My Account')]")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String passErrorMsg= driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals("Pls enter 6 or more characters. Leading or trailing spaces with be ignored", passErrorMsg);
  }
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
