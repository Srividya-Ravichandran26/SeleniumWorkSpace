package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithRadioButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		// Are you enjoying the classes? - Answer yes
		driver.findElement(By.id("yes")).click();

		// Find default selected radio button
		boolean unSelectedRadio = driver.findElement(By.xpath("//label[@for='Unchecked']")).isSelected();
		System.out.println("Is (UnChecked) radio is selected by default?:" + unSelectedRadio);

		boolean selectedRadio = driver.findElement(By.xpath("//label[@for='Unchecked']/following::input")).isSelected();
		System.out.println("Is (Checked) radio is selected by default?:" + selectedRadio);

		// Select your age group (Only if choice wasn't selected)
		boolean ageGrp = driver.findElement(By.xpath("(//input[@name='age'])[2]")).isSelected();
		if (ageGrp != true) {
			driver.findElement(By.xpath("(//input[@name='age'])[2]")).click();
		} else {
			System.out.println("Your age group is selected by default");
		}

	}

}
