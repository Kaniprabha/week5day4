package week5day4;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class RedHat {
    
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
	
	
	@Test(dataProvider="fetchData")
	public void CreateLeadRun(String uName, String pwd, String Email, String phNum) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.id("truste-consent-button")).click();
		driver.findElement(By.id("rh-registration-link")).click();
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("user.attributes.phoneNumber")).sendKeys(phNum);
		
		driver.close();
	}
	
	
	@DataProvider(name="fetchData")
	public String[][] setData() throws IOException {
		return DataLibraryRedHat.readData(); 
		
	}

}
