package week2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeads {

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
		driver.findElement(By.xpath("//div[@class='x-tab-panel']//input[@name='firstName']")).sendKeys("Hari Priya");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String linkValue = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[1]")).getText();
		driver.findElement(By.linkText(linkValue)).click();
		
		System.out.println("The Title of the page is:" + driver.getTitle());
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("CTS Company");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		if (companyName.contains("CTS Company")) {
			System.out.println("Company name is changed and it is appeared as expected:" + companyName);
		}

		driver.close();

	}

}
