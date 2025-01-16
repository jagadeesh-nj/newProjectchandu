package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageClass {
	
	public WebDriver driver;
	
	public HomePageClass(WebDriver driver){
		this.driver =driver;
		
	}
	
	public void Goto() {
		driver.get("https://www.amazon.in/");
	}

	private By searchBox =  By.xpath("//input[@id = 'twotabsearchtextbox']");
	
	public void sendValues(String Value) {
		WebElement seleSearch = driver.findElement(searchBox);
		seleSearch.click();
		seleSearch.sendKeys(Value);
	}

	public void selectFirstDropDownValue() {
		WebElement seleSearch = driver.findElement(searchBox);
		seleSearch.sendKeys(Keys.ARROW_DOWN);
		seleSearch.sendKeys(Keys.ENTER);

	}
	
	
	
	
}
