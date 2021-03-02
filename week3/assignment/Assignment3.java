package week3.assignment;

import java.io.File;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws Exception {
		Date date = new Date();
		String strdate = date.toString();
		String newDate = strdate.replaceAll(":", "");

		WebDriverManager.chromedriver().setup();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.merge(cap);

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("src")).sendKeys("Koyambedu, Chennai"); // Enter From
		Thread.sleep(2000);
		driver.findElement(By.id("src")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);

		driver.findElement(By.id("dest")).sendKeys("Madurai (All Locations)"); // Enter To
		Thread.sleep(2000);
		driver.findElement(By.id("dest")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER, Keys.TAB);

		// Click date and select next day
		driver.findElement(By.xpath("//div[@class='fl search-box date-box gtm-onwardCalendar']")).click();
		driver.findElement(
				By.xpath("//table[@class='rb-monthTable first last']//tr[3]/td[@class= 'current day']/following::td"))
				.click();

		driver.findElement(By.id("search_btn")).click();// Click search buses
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='close']")).click(); // close unwanted pop up
		driver.findElement(By.xpath("//i[@class='icon-close coach-close']")).click(); // close unwanted pop up

		String busFound = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText(); // Buses No
		System.out.println("Total bus found is: " + busFound.replaceAll("[a-zA-Z]", ""));

		if (driver.findElement(By.xpath("//div[text() = 'View Buses']")).isDisplayed()) {
			driver.findElement(By.xpath("//div[text() = 'View Buses']")).click(); // Expanding View Buses to get all bus
		} // names

		// Get all the buses and print the names
		List<WebElement> busNames = driver.findElements(By.xpath("//div[@class='travels lh-24 f-bold d-color']"));
		Set<String> busNameSet = new LinkedHashSet<String>();
		for (int i = 0; i < busNames.size(); i++) {
			busNameSet.add(busNames.get(i).getText());
		}

		for (String eachValues : busNameSet) {
			System.out.println(eachValues);
		}

		driver.findElement(By.xpath("//div[text() = 'Hide Buses']")).click();// Collapse View Buses

		driver.findElement(By.xpath("//div[text()='View Seats']")).click();// Click View seats of first data
		Thread.sleep(2000);
		// Screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/window" + newDate + ".png");
		FileUtils.copyFile(source, target);

	}

}
