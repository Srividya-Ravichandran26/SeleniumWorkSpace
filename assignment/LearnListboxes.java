package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		// Select Training program using index
		Select usingIndex = new Select(driver.findElement(By.id("dropdown1")));
		usingIndex.selectByIndex(1);

		// Select Training program using Text
		Select usingText = new Select(driver.findElement(By.xpath("//select[@name='dropdown2']")));
		usingText.selectByVisibleText("Appium");

		// Select training program using Value
		Select usingValue = new Select(driver.findElement(By.id("dropdown3")));
		usingValue.selectByValue("3");

		// Get the number of dropdown options
		Select noOfDropdown = new Select(driver.findElement(By.className("dropdown")));
		System.out.println("The number of dropdown is:" + noOfDropdown.getOptions().size());

		// You can also use sendKeys to select
		driver.findElement(By.xpath("//div[@id='contentblock']//div[5]/select")).click();
		driver.findElement(By.xpath("//div[@id='contentblock']//div[5]/select")).sendKeys(Keys.ARROW_DOWN,
				Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

		// Select your program (MultiSelect)
		Select multiSelect = new Select(driver.findElement(By.xpath("//div[@id='contentblock']//div[6]/select")));
		multiSelect.selectByVisibleText("Selenium");
		multiSelect.selectByValue("4");
	}

}
