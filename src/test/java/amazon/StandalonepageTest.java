package amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandalonepageTest {
    
	
    public static void main(String[] args) {
		String productName="Whirlpool 7 Kg 5 Star Royal Fully-Automatic Top Loading Washing Machine (WHITEMAGIC ROYAL 7.0 GENX, Grey, Hard Water Wash, ZPF Technology)";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Washingmachine");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> products =driver.findElements(By.xpath("//div[@class='sg-col-20-of-24 s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 AdHolder sg-col s-widget-spacing-small sg-col-12-of-16']"));
		System.out.println(products);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+productName+"')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		String value=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).getText();
		System.out.println(value);
		WebElement prod = products.stream().filter(product->
		product.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText().contains(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[@class='a-button-text']")).click();
		driver.close();
	}
}
