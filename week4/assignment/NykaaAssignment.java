package week4.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable--notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.className("menu-dropdown-icon"))).perform();

		builder.moveToElement(driver.findElement(By.xpath("//a[text()='Popular']"))).perform();

		driver.findElement(By.xpath("//div[@id='brandCont_Popular']//li[5]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowID = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windowID.get(1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (driver.getTitle().contains("L'Oreal Paris")) {
			System.out.println("The Title contains L'Oreal Paris as expected: Title is:" + driver.getTitle());
		} else {
			System.err.println("The Title is not contains L'Oreal Paris:" + driver.getTitle());
		}

		driver.findElement(By.xpath("//div[@class='sort-btn clearfix']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following-sibling::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//label[@for='chk_Shampoo_undefined']//div")).click();

		String filterName = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		if (filterName.contains("Shampoo")) {
			System.out.println("The Filter is applied with Shampoo");
		} else {
			System.err.println("The filter is not applied:" + filterName);
		}

		List<WebElement> resultItemList = driver.findElements(By.xpath("//div[@class='row clearfix']/div"));
		int count = 0;
		for (int i = 1; i < resultItemList.size(); i++) {

			String tagName = driver.findElement(By.xpath("//div[@class='row clearfix']/div[" + i + "]//a/*"))
					.getTagName();
			if (!tagName.equalsIgnoreCase("img")) {
				String shampootext = driver
						.findElement(By.xpath("//div[@class='row clearfix']/div[" + i + "]//a//h2/span")).getText();
				if (shampootext.equalsIgnoreCase("L'Oreal Paris Colour Protect Shampoo")) {
					count++;
					if (count == 2) {
						driver.findElement(By.xpath("//div[@class='row clearfix']/div[" + i + "]//a//h2/span")).click();
						break;
					}
				}
			}
		}

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowID1 = new ArrayList<String>(windowHandles1);

		driver.switchTo().window(windowID1.get(2));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//span[text()='175ml']")).click();

		String mrpRate = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText()
				.replaceAll("\\D", "");
		System.out.println("The MRP rate for 175ml is: " + mrpRate);

		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("AddBagIcon")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		String grandTotal = driver.findElement(By.xpath("//div[@class='first-col']//div")).getText().replaceAll("\\D",
				"");
		System.out.println("The GrandTotal is: " + grandTotal);
		
		builder.moveToElement(driver.findElement(By.xpath("//button[contains(@class,'radius proceed')]"))).click()
				.perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		String billingGrandTotal = driver.findElement(By.xpath("(//div[@class='value']//span)[2]")).getText();
		if (billingGrandTotal.equalsIgnoreCase(grandTotal)) {
			System.out.println("The billing page Grand Total(" + billingGrandTotal
					+ ") is matching with previous page Total(" + grandTotal + ")");

		}

		driver.quit();

	}

}
