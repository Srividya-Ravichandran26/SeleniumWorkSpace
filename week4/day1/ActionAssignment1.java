package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAssignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement frameClass = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameClass);

		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		int x = driver.findElement(By.xpath("//li[text()='Item 4']")).getLocation().getX();
		int y = driver.findElement(By.xpath("//li[text()='Item 4']")).getLocation().getY();

		Actions sortable = new Actions(driver);
		sortable.dragAndDropBy(item1, x, y).perform();

	}

}
