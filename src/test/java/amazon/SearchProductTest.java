package amazon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.GetstartTest;
import amazon.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchProductTest extends GetstartTest {
	
	@Test
	public void SelectproductTEST() throws Exception {
		
		hpc.sendValues("WashingMAchine");	
		hpc.selectFirstDropDownValue();
		
		
	}
	

}
