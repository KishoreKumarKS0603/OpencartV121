package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
public static WebDriver driver;
public Logger logger;
public Properties prop;
//public String ChromeDriverLocate;
//public String GeckoDriverLocate;
	
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"OS","browser"})
	public void setup(String OS,String Br) throws IOException {
		
		FileReader File = new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(File);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			String huburl="http://localhost:4444/wd/hub";
			
			DesiredCapabilities cap=new DesiredCapabilities();
			
			
			if(OS.equalsIgnoreCase("Windows")) {
				
				cap.setPlatform(Platform.WIN10);
			}
			
           else if(OS.equalsIgnoreCase("mac")) {
				
				cap.setPlatform(Platform.WIN10);
			}
           else
			{
				System.out.println("No matching os");
				return;
			}
			
			
			
			
			switch(Br) {
			case "Chrome": cap.setBrowserName("chrome");
			break;
			
			case "firefox": cap.setBrowserName("MicrosoftEdge");
			break;
			
			default: System.out.println("No Matching Browser");
			
			}
			
			
			
				 driver = new RemoteWebDriver(new URL(huburl), cap);
		}
			
			/*System.out.println("Grid remote");
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(OS.equalsIgnoreCase("Windows")) {
				
				capabilities.setPlatform(Platform.WIN10);
			}
			
			else if(OS.equalsIgnoreCase("mac")) {
				
				capabilities.setPlatform(Platform.WIN10);
			}
			
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			switch(Br) {
			case "Chrome": capabilities.setBrowserName("chrome");
			System.out.println("Chrome Grid inside");
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\SYS\\Desktop\\Automation\\New\\chromedriver-win64\\chromedriver.exe");
			System.out.println("Chrome Grid");
			break;
			case "firefox": capabilities.setBrowserName("MicrosoftEdge"); 
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\SYS\\Desktop\\Automation\\geckodriver\\geckodriver.exe");
			break;
			default: System.out.println("No Matching Browser");
			}
			
			try {
			    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} catch (Exception e) {
			    e.printStackTrace();
			    logger.error("Failed to initialize RemoteWebDriver", e);
			}
			
			
		}*/
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			
		
		
		switch(Br) 
		{
		case "Chrome" :
			String ChromeDriverLocate =prop.getProperty("ChromeDriverLocation");
			System.setProperty("webdriver.chrome.driver",ChromeDriverLocate);
			driver=new ChromeDriver();
			break;
		
		case "firefox" :
			String GeckoDriverLocate=prop.getProperty("GeckoDriverLocation");
			System.setProperty("webdriver.gecko.driver",GeckoDriverLocate);
			driver=new FirefoxDriver();
			break;
		}
		
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("appURL"));
		System.out.println("appURL");
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	public void teardown() {
		driver.quit();
	}
	
	
public String captureScreen(String tname) throws IOException{
	
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
	TakesScreenshot takesSceenshot = (TakesScreenshot) driver;
	File sourceFile=takesSceenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots"+tname+timeStamp+".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
	return targetFilePath;
}
}
