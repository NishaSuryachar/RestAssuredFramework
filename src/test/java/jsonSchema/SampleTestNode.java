package jsonSchema;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTestNode {
	
	RemoteWebDriver driver;
    @Parameters("browser")
	@BeforeClass
	public void samnpleTest(String BROWSER) throws MalformedURLException
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		if(BROWSER.equals("edge"))
		{
			cap.setBrowserName("edge");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(BROWSER.equals("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444"),cap);
	}
	@Test
	public void runTest() 
	{
		driver.get("https://www.flipkart.com/");
	
	}
}
