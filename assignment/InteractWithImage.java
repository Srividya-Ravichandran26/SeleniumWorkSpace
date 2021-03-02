package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		// Go to Home Page
		driver.findElement(By.xpath("//img[contains(@src,'../images/home.png')]")).click();
		System.out.println(
				"The URL for the action of (Click on this image to go home page) is:" + driver.getCurrentUrl());
		driver.navigate().back();

		// Am I Broken Image?
		String image = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"))
				.getAttribute("naturalWidth");
		if (image.equals("0")) {
			System.out
					.println(driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"))
							.getAttribute("outerHTML") + " is broken.");
		}
		//Click me using Keyboard or Mouse
		WebElement imgPath = driver.findElement(By.xpath("//img[contains(@src,'../images/keyboard.png')]"));
		Actions action = new Actions(driver);
		action.moveToElement(imgPath).click().perform();
		System.out.println(
				"The URL for the action of (Click me using Keyboard or Mouse) is:" + driver.getCurrentUrl());
		driver.navigate().back();
	}

}
