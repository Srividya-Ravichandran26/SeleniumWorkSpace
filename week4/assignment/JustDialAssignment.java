package week4.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustDialAssignment {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.justdial.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//div[@class='search-city mnsrchwpr']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Chennai']")).click();

		driver.findElement(By.xpath("//span[text()='Auto care']")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@title='Car Repair']")).click();
		
		driver.findElement(By.xpath("//span[@title='Hyundai']")).click();
		
		driver.findElement(By.xpath("//span[@title='Hyundai Xcent']")).click();
		
		driver.findElement(By.xpath("//span[@title='All Options']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("srchbx")).click();
		driver.findElement(By.id("insrch")).sendKeys("Porur", Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.id("distance")).click();
		driver.findElement(By.xpath("//span[@class='drpwn']/*[text()='1 km']")).click();
		
		List<WebElement> allRating = driver.findElements(By.className("green-box"));
		List<WebElement> allVotes = driver.findElements(By.className("rt_count lng_vote"));
		List<WebElement> allServiceProvider = driver.findElements(By.className("lng_cont_name"));		
		List<WebElement> allPhoneNo = driver.findElements(By.xpath("//p[@class='contact-info ']//b"));
		
		//Phone number text
		List<WebElement> samePhoneNo = driver.findElements(By.xpath("//p[@class='contact-info ']//b/span"));
		List<String> phoneNoChar = new ArrayList<String>();		
		String phoneChar = "";
		
		for (int i = 0; i < samePhoneNo.size(); i++) {			
			phoneChar = phoneChar.concat(driver.findElement(By.xpath("//p[@class='contact-info ']//b/span["+i+"]")).getText());	
			phoneNoChar.add(phoneChar);
		}
		
		//Removing hidden votes
		for (int i = 0; i < allVotes.size(); i++) {
			if(i%2==0) {
				allVotes.remove(i);
			}
		}
		for (WebElement eachValues : allVotes) {
			System.out.println(eachValues.getText());
		}
		
		
//		Map<Integer, String> storeRatings = new HashMap<Integer, String>();
//		
//		for (int j = 0; j < allRating.size(); j++) {
//			
//		}

	}

}
