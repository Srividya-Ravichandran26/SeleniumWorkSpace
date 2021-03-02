package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// url: https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		
		//class: nav-line-2 nav-long-width (Sign In)
		driver.findElement(By.id("nav-link-accountList")).click();			
		//id=ap_email (username)
		driver.findElement(By.id("ap_email")).sendKeys("smilingpriyasree@gmail.com");
		//id=continue (Continue button)
		driver.findElement(By.id("continue")).click();
		

	}

}
