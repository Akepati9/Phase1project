package packager;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement SearchIput=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		
		SearchIput.sendKeys("iphone 12");
		
		WebElement Search=driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		
		Search.click();
		
		List<WebElement> iphonemodel = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));         
		List<WebElement> iphoneprice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));                  
		
		System.out.println("Search Results "+ iphonemodel.size());
		
		for(int count=0;count<iphonemodel.size();count++)
		{
				if(iphonemodel.get(count).getText().toLowerCase().contains("iphone 12"))
		{
			System.out.println("iPhone Model :"+iphonemodel.get(count).getText() + "iPhone Price:"+iphoneprice.get(count).getText());
		
			}
		}
		
		driver.close();
	}

}
