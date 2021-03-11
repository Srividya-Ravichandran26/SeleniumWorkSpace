package week4.assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraAssignment {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("(//a[text()='Women'])[1]"))).perform();

		driver.findElement(By.linkText("Jackets & Coats")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String totalList = driver.findElement(By.className("title-count")).getText().replaceAll("\\D", "");

		int jacketsCagCount = Integer.parseInt(driver
				.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span[@class='categories-num']"))
				.getText().replaceAll("\\D", ""));
		int coatsCagCount = Integer.parseInt(
				driver.findElement(By.xpath("//input[@value='Coats']/following-sibling::span[@class='categories-num']"))
						.getText().replaceAll("\\D", ""));

		int sum = jacketsCagCount + coatsCagCount;

		if (sum == Integer.parseInt(totalList)) {
			System.out.println("The sum of categories count matches");
			System.out.println("Sum:" + sum);
			System.out.println("Result:" + totalList);
		}

		driver.findElement(By.xpath("(//span[@class='categories-num']/following-sibling::div)[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.className("brand-more")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("MANGO");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div[1]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();

		Thread.sleep(2000);

		List<WebElement> coatsName = driver.findElements(By.xpath("//*[@class='product-productMetaInfo']/h3"));
		for (int i = 0; i < coatsName.size(); i++) {
			if (!coatsName.get(i).getText().equalsIgnoreCase("MANGO")) {
				System.out.println("Coats are not MANGO - iteration---" + i);
			}
		}

		builder.moveToElement(driver.findElement(By.className("sort-sortBy"))).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();

		String price = driver.findElement(By.xpath("(//*[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("First Coat Price is:" + price);

		builder.moveToElement(driver.findElement(By.xpath("(//*[@class='product-discountedPrice'])[1]"))).perform();
		driver.findElement(By.xpath("//span[contains(@class,'product-notWishlistedIcon')]")).click();
		driver.close();

	}

}
