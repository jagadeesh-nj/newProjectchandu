package amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Landingpage {
	
	public WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox1;
	
	@FindBy(id="nav-search-submit-button")
	WebElement submit;
	
	private By addtoCart=By.xpath("//*[@id='a-autoid-3-announce']");
	
	private By searchbox=By.xpath("//*[@id='twotabsearchtextbox']");
	
	private By productlist=By.xpath("//div[@class='sg-col-20-of-24 s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 AdHolder sg-col s-widget-spacing-small sg-col-12-of-16']");
	List<WebElement> products =driver.findElements(productlist);
	
	public void goTo() {
		driver.get("https://www.amazon.in/");
	}
	
	public void Searchproduct(String productname) {
		driver.findElement(searchbox).click();
		driver.findElement(searchbox).sendKeys(productname);
		submit.click();
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = products.stream().filter(product->
		product.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addtoCart).click();
	}


}
