package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeads {

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
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Phone']")).click();
		driver.findElement(By.xpath("//div[@class='x-tab-panel']//input[@name='phoneNumber']")).sendKeys("98");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String linkValue = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[1]")).getText();
		System.out.println("Captured First Resulting lead is: " + linkValue);
		driver.findElement(By.linkText(linkValue)).click();
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.linkText("Find Leads")).click();// Find Leads
		driver.findElement(By.xpath("//div[@class='x-tab-panel']//input[@name='id']")).sendKeys(linkValue);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String noRecordText = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(noRecordText.equalsIgnoreCase("No records to display"))
		{
			System.out.println("Successfully deleted");
		}
		driver.close();

	}

}
