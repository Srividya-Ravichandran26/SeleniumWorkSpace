package week4.assignment;

import java.util.List;
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
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()='Chennai']")).click();

		driver.findElement(By.xpath("//span[text()='Auto care']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[text()='Car Repair']")).click();

		driver.findElement(By.xpath("//span[text()='Hyundai']")).click();
		driver.findElement(By.xpath("//span[text()='Hyundai Accent']")).click();
		
		driver.findElement(By.id("srchbx")).click();
		driver.findElement(By.xpath("//span[text()='All Options']")).click();
		
		driver.findElement(By.id("insrch")).sendKeys("Porur", Keys.ARROW_DOWN, Keys.ENTER);
		
		driver.findElement(By.id("distance")).click();
		driver.findElement(By.xpath("//span[@class='drpwn']/*[text()='1 km']")).click();
		
		List<WebElement> rating = driver.findElements(By.className("green-box"));
		

	}

}
