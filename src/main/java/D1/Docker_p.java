package D1;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

public class Docker_p {
	
	WebDriver driver;
	String url="http://10.67.89.41/Automation/HMS/LoginPage.aspx ";
	
	@Before
	public void setUp() throws Exception {
		
		//DesiredCapabilities dcp=DesiredCapabilities.chrome();
		/*DesiredCapabilities dcp=DesiredCapabilities.internetExplorer();
		dcp.setBrowserName("internet explorer");*/
		/*DesiredCapabilities dcp=DesiredCapabilities.chrome();//seleGrid
		dcp.setBrowserName("chrome");//selegrid
		dcp.setPlatform(Platform.WIN10);//seleGrid
*/				
		//dcp.setVersion("63.0.3");
		DesiredCapabilities dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "SeleniumLogOutDocker");
		dcp.setCapability("idleTimeout", 150);
		driver = new RemoteWebDriver(new URL("http://35.196.40.178:4444/wd/hub"),dcp);
		//driver=new RemoteWebDriver(new URL("http://10.76.66.42:4444/wd/hub"), dcp);//selenium grid
		/*System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		Thread.sleep(4000);
		driver.get(url);	
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws Exception {
		Thread.sleep(1000);
		System.out.println("Title:-"+driver.getTitle());
		
		driver.findElement(By.id("txtUserID")).sendKeys("11");
		System.out.println("Entering Username");
		Thread.sleep(100);		
		driver.findElement(By.id("txtPassword")).sendKeys("priya");
		System.out.println("Entering Password");
		Thread.sleep(1000);

		driver.findElement(By.name("btnLogin")).click();
		System.out.println("Click on Login button");
		Thread.sleep(100);
		System.out.println("Login passed");
		driver.findElement(By.id("lbtnLogOut")).click();
		System.out.println("Click on Logout link");
		Cookie cookie = new Cookie("zaleniumTestPassed", "true");
	    driver.manage().addCookie(cookie);
	
	}
	

}
