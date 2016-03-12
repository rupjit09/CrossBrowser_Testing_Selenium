package pack1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBase {

	
/*
 * Crossbrowser testing in selenium can be done to execute cases simultaneously on more than one browser in same machine, (if we want 
 * to execute in different machine we have to use grid) in testng.xml file we need to set the parallel attribute to execute the 
 * cases parallely in different browser
 * Set seperate test blocks in testng.xml for seperate browser value passed as parameter and set parallel=tests so that all test 
 * blocks are executed simultaneously
 */
	public WebDriver driver;
	@Parameters({"browserName"})
	@BeforeMethod
	public void launchBrowser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rupjit\\Desktop\\Desktop\\selenium-java-2.44.0\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}else{
			System.out.println("Incorrect browser name passed so launching default browser-Firefox");
			driver=new FirefoxDriver();
		}
	}
	
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}
	
	@Test
	public void goToURL() throws InterruptedException{
		driver.navigate().to("http://www.facebook.com");
		Thread.sleep(5000);
	}
}
