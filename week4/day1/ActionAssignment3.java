package week4.day1;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAssignment3 {

	public static void main(String[] args) throws Exception {
//		1. Load https://www.snapdeal.com/
//			2. Mouse hover on Men's Fashion and Click Loafers
//			3. Mouse hover on the first product and Click on Quick View
//			4. Close all the browsers

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		

		WebElement menFashion = driver
				.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct ']/span[contains(text(),'Men')]"));
		Actions snapDeal = new Actions(driver);

		snapDeal.moveToElement(menFashion).perform();
		driver.findElement(By.linkText("Loafers")).click();

		WebElement image = driver.findElement(By.xpath("//a[@class='dp-widget-link hashAdded']"));
		snapDeal.moveToElement(image).perform();

		driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
		Thread.sleep(1000);

		File source = driver.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		String strdate = date.toString();
		String newDate = strdate.replaceAll(":", "");
		File target = new File("./snaps/snapDeal_" + newDate + ".png");
		FileUtils.copyFile(source, target);

		driver.close();
	}

}
