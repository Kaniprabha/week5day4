package week5day4;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class W3Schools {
	
	public RemoteWebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void preCondition(String browser, String url) {
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		default:
			driver = new ChromeDriver();
			break;
		
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
			
		}

	
	@Test(dataProvider="fetchData")//CreateLeadRun
	
	public void w3school(String Name, String Mail, String Address, String city, String state, String zip ,String year, String CVV,String month,String creNum, String cardName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement framew3 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
	    driver.switchTo().frame(framew3);
	    
	    driver.findElement(By.id("fname")).sendKeys(Name);
	    driver.findElement(By.id("email")).sendKeys(Mail);
	    driver.findElement(By.id("adr")).sendKeys(Address);
	    driver.findElement(By.id("city")).sendKeys(city);
	    driver.findElement(By.id("state")).sendKeys(state);
	    driver.findElement(By.id("zip")).sendKeys(zip);
	    driver.findElement(By.id("expyear")).sendKeys(year);
	    driver.findElement(By.id("cvv")).sendKeys(CVV);
	    driver.findElement(By.id("expmonth")).sendKeys(month);
	    driver.findElement(By.id("ccnum")).sendKeys(creNum);
	    driver.findElement(By.id("cname")).sendKeys(cardName);
	    driver.close();
		
	}
	
	@DataProvider(name="fetchData")
	public String[][] setData() throws IOException {
		return DataLibrary.readData(); 
		
	}


}

