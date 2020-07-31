package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class login {
	
	WebDriver driver;
	String baseUrl = "https://www.facebook.com/login/device-based/regular/login";
	
	@BeforeSuite
	public void init() {
		//set up for chrome driver
		 System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver 2");
		 driver = new ChromeDriver();  
	}
	
	@Test
    public void successfulLogin() {
        //open website link
        driver.get(baseUrl);
 
        //enter username and password, click Login button
        driver.findElement(By.id("email")).sendKeys("lesneva@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("P@s$word1!");
        driver.findElement(By.id("loginbutton")).click();
        
        //explicit wait to wait for a user to become logged in
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log Out")));
        
        //assert if the displayed title is for a logged in user 
        Assert.assertEquals(driver.getTitle(), "Facebook");
        
    }
	
	@Test
	public void logout() {
		//open website url
		driver.get(baseUrl);
		
		//perform login
        driver.findElement(By.id("email")).sendKeys("lesneva@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("P@s$word1!");
        driver.findElement(By.id("loginbutton")).click();
        
        //make sure the user is logged in
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log Out")));
        
        //click log out url
        driver.findElement(By.partialLinkText("Log Out")).click();
        
        //assert the displayed title when no user is logged in
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}
	
	@Test
	public void unseccessfulLogin() {
		
		//open website url
		driver.get(baseUrl);
		
		//enter empty username and valid password, click login button
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("P@s$word1!");
        driver.findElement(By.id("loginbutton")).click();
        
        //assert the error message is as expected
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText(), 
        		"The email address or phone number that you've entered doesn't match any account. Sign up for an account.");
	}
	
	

}
