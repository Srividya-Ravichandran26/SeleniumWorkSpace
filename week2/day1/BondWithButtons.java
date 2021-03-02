package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButtons {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		//Find position of button (x,y) (id=position)
		System.out.println("Position of the button is:" + driver.findElement(By.id("position")).getLocation());
		
		//Find button color (id=color)
		System.out.println("Button color is:" + driver.findElement(By.id("color")).getCssValue("background-color"));
		
		//Find the height and width (id=size)
		System.out.println("The height and width of the button is:" + driver.findElement(By.id("size")).getSize());
		
		//Click button to travel home page (id=home)
		String urlLink = driver.findElement(By.id("home")).getAttribute("onClick");		
		if(urlLink.contains("home"))
		{
			System.out.println("The URL contains home and URL is:" + urlLink);
		}else
			System.out.println("URL is not contains home");
		
		driver.findElement(By.id("home")).click();
		System.out.println("The URL for the action of (Click button to travel home page) is:" + driver.getCurrentUrl());
		
		
	}

}
