package gridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelGrid_Browser {
	public WebDriver driver=null;
 
	@Parameters({"browserName"})
	@Test
 public void launchBrowser(String browser) throws MalformedURLException, InterruptedException{
	 DesiredCapabilities cap=null;
	 if(browser.equalsIgnoreCase("firefox"))
	 cap=DesiredCapabilities.firefox();
	 else if(browser.equalsIgnoreCase("chrome")){
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rupjit\\Desktop\\Desktop\\selenium-java-2.44.0\\chromedriver_win32\\chromedriver.exe");
		cap=DesiredCapabilities.chrome();
	 }
	 cap.setPlatform(Platform.WINDOWS);
	 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	 driver.navigate().to("http://www.google.co.in");
	 Thread.sleep(5000);
	 driver.quit();
 }
}
