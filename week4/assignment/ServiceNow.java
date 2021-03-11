package week4.assignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev68594.service-now.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.switchTo().frame("gsft_main");

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("filter")))).sendKeys("incident");

		driver.switchTo().frame("gsft_main");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("add_icon"))));
		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.textToBe(By.xpath("//div[@data-id='b55b4ab0c0a80009007a9c0f03fb4da9']//div[1]"),
				"All"));
		driver.findElement(By.xpath("//div[@data-id='b55b4ab0c0a80009007a9c0f03fb4da9']//div[1]")).click();

		driver.switchTo().frame("gsft_main");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sysverb_new")))).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sys_display.incident.caller_id"))))
				.sendKeys("Te");

		Thread.sleep(2000);
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		driver.findElement(By.id("incident.short_description")).sendKeys("Incidient Automation Short Desc");

		String incidentNo = driver.findElement(By.id("incident.number")).getAttribute("value");

		driver.findElement(By.id("sysverb_insert")).click();

		driver.findElement(By.xpath("//*[@class='input-group']/input[@placeholder='Search']")).sendKeys(incidentNo,
				Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(incidentNo))));

		String searchResult = driver.findElement(By.xpath("//table[@id='incident_table']//tr[1]/td[3]")).getText();

		if (searchResult.equalsIgnoreCase(incidentNo)) {
			System.out
					.println("The incident is created successfully and able to find the incident in the search page.");
			System.out.println("Incident No is:" + searchResult);
		}

	}

}
