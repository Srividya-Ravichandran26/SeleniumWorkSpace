package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectedMethodVal {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input")).isSelected();
		System.out.println("Is confirm selenium checkbox selected:" + selected);
		
		boolean secondOption = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[1]")).isSelected();
		System.out.println("Is Not Selected checkbox selected:" + secondOption);
		

	}

}
