package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager"); // username
		driver.findElement(By.id("password")).sendKeys("crmsfa");// password
		driver.findElement(By.className("decorativeSubmit")).click();// login
		driver.findElement(By.linkText("CRM/SFA")).click(); // CRM/SFA Link
		driver.findElement(By.linkText("Leads")).click(); // Click Leads link
		driver.findElement(By.linkText("Find Leads")).click();// Find Leads
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Email']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String linkValue = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[3]")).getText();
		System.out.println("Captured First Resulting lead Name: " + linkValue);
		driver.findElement(By.linkText(linkValue)).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if (driver.getTitle().contains("Duplicate Lead"))
			System.out.println("The Title is duplicate Lead");
		else
			System.out.println("The Title is not duplicate Lead");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String leadName = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		if (leadName.contains(linkValue)) {
			System.out.println("Lead name (" + leadName + ") is same as duplicate lead name(" + linkValue + ")");
		}

		driver.close();

	}

}
