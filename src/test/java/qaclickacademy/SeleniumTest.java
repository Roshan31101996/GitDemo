package qaclickacademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTest {

	@Test(groups={"Smoke"})
	public void BrowserAutomation() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.naukri.com/nlogin/login");
		driver.findElement(By.id("usernameField")).sendKeys("15cse163.giet@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Roshan@7");
		driver.findElement(By.cssSelector("button[data-ga-track='spa-event|login|login|Save']")).click();
		//Thread.sleep(2000);
		
		//click to update
		driver.findElement(By.xpath("//div[@title='Roshan Kumar']")).click();
		//resume headline edit
		driver.findElement(By.xpath("//div[@class='resumeHeadline']/div/div/div/span[@class='edit icon']")).click();
		
		//Thread.sleep(2000);
		
		String resume_headline = driver.findElement(By.id("resumeHeadlineTxt")).getText();
		driver.findElement(By.id("resumeHeadlineTxt")).clear();
		driver.findElement(By.id("resumeHeadlineTxt")).sendKeys(resume_headline);
		driver.findElement(By.xpath("//div[@class='action s12']/button[@type='submit']")).click();
		
		//WebElement pre_logout =  driver.findElement(By.xpath("//li/a/div[@class='mTxt'][contains(text(),'My Naukri')]/parent::a[@target='_blank']"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500)");
		
		
		Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//div[@class='mTxt'][contains(text(),'My Naukri')]"))).build().perform();
		//div[@class='topIcon user']/parent::a[@target='_blank']
		WebElement myNaukri_hover = driver.findElement(By.xpath("//div[@class='topIcon user']/parent::a[@target='_blank']"));
		a.moveToElement(myNaukri_hover).click(driver.findElement(By.xpath("//a[@title='Logout']"))).build().perform();
		
		//driver.findElement(By.linkText("Logout")).isDisplayed();
		//driver.findElement(By.cssSelector("a[title='Logout']")).click();
		
		driver.quit();
		
	}
	
	@Test
	public void elementsUI() {
		System.out.println("elementsUI");
	}
}
