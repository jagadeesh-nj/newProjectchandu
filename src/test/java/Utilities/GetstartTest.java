package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import amazon.HomePageClass;
import amazon.Landingpage;

public class GetstartTest {
	
	
	
	

//	public WebDriver initializeDriver() throws IOException {
		/*
		 * Properties prop = new Properties(); FileInputStream fis = new
		 * FileInputStream(System.getProperty("user.dir") +
		 * "//src//main//java//amazon//Global.properties"); prop.load(fis);
		 * 
		 * String browserName = System.getProperty("browser");
		 * if(browserName.equalsIgnoreCase("chrome")) {
		 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver(); }
		 */
		
		
		//	return driver;
//	}
	
public WebDriver driver;
public HomePageClass hpc;
	
	@BeforeMethod
	public void launchApplication() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		hpc  =  new  HomePageClass(driver);
		hpc.Goto();
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}

}
