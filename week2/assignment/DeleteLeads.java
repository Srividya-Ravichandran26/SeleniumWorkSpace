package week2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeads extends BaseClass{

	@Test
	public void runDeleteLead() throws Exception {
		driver.findElement(By.linkText("Find Leads")).click();// Find Leads
		driver.findElement(By.xpath("//span[@class='x-tab-strip-inner']/span[text()='Phone']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		List<WebElement> noRecord = driver.findElements(By.xpath("//div[text()='No records to display']"));
		if(noRecord.size()==0) {
			String number = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]//td[contains(@class,'x-grid3-td-formatedPrimaryPhone')]//div")).getText().substring(5, 7);
			driver.findElement(By.xpath("//div[@class='x-tab-panel']//input[@name='phoneNumber']")).sendKeys(number);
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
		}
		else {
			System.out.println("There is not phonenumber presented data to delete.");
		}

	}

}
