package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionAssignment2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		WebElement optionAppium = driver
				.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[2]"));
		WebElement optionLoad = driver
				.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[4]"));

		Actions dropdown = new Actions(driver);
		dropdown.keyDown(optionAppium, Keys.CONTROL).click(optionLoad).keyUp(Keys.CONTROL).perform();

	}

}
