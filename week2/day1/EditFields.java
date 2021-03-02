package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.inject.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		//Enter Email ID (id=email)
		driver.findElement(By.id("email")).sendKeys("srividyaravichandran26@gmail.com");
		//Append a text and press tab
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/input")).sendKeys("New Text", Keys.TAB);
		//get default text entered
		String defaultValue = driver.findElement(By.name("username")).getAttribute("value");
		if(defaultValue.contains("TestLeaf"))
		{
			System.out.println(defaultValue + " is available as expected");
		}else
			System.out.println("The default value is not available");
		//clear the text
		driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[4]/div/div/input")).clear();		
		//Confirm that edit field is disabled
		boolean expectedValue = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/div/div/input")).isEnabled();
		System.out.println("Is Field enabled to edit? " + expectedValue);

	}

}
