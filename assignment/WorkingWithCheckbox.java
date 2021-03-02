package week2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// Select the languages that you know?
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input")).click();

		// Confirm Selenium is checked
		boolean selectedCheck = driver
				.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input")).isSelected();
		System.out.println("Is Selenium is checked: " + selectedCheck);

		// DeSelect only checked
		boolean deSelect = driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]"))
				.isSelected();
		if (deSelect == true) {
			driver.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).click();
		}
		System.out.println("Is checkbox is checked after deselected scenario: " + driver
				.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)[2]")).isSelected());

		// Select all below checkboxes

		List<WebElement> list = driver.findElements(
				By.xpath("//label[text()='Select all below checkboxes ']/following::input[@type='checkbox']"));
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isSelected()) {
				list.get(i).click();
			}
		}

	}

}
