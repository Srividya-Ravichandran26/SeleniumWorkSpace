package week3.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week2.assignment.BaseClass;

public class MergeLeads extends BaseClass{

	@Test
	public void runMergeLead() throws Exception {
		driver.findElement(By.linkText("Merge Leads")).click();// Merge Leads
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();// Click From lead icon

		Set<String> allWindowHandles = driver.getWindowHandles();
		List<String> listHandle = new ArrayList<String>(allWindowHandles);
		driver.switchTo().window(listHandle.get(1));

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();// Click Find Leads button
		Thread.sleep(2000);
		String leadNo = driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[3]//tr[1]/td[1]")).getText();		
		driver.findElement(By.name("id")).sendKeys(leadNo); // Enter Lead No
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();// Click Find Leads button
		Thread.sleep(2000);
		
		String linkValue = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[1]")).getText();
		driver.findElement(By.linkText(linkValue)).click();

		driver.switchTo().window(listHandle.get(0));

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();// Click To lead icon

		Set<String> allWindowHandles2 = driver.getWindowHandles();
		List<String> listHandle2 = new ArrayList<String>(allWindowHandles2);
		driver.switchTo().window(listHandle2.get(1));
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();// Click Find Leads button
		Thread.sleep(2000);
		
		String toLeadNo = driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[4]//tr[1]/td[1]")).getText();
		
		driver.findElement(By.name("id")).sendKeys(toLeadNo); // Enter Lead No
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();// Click Find Leads button
		Thread.sleep(2000);
		String linkValue2 = driver.findElement(By.xpath("//div[@class='x-grid3-body']//tr[1]/td[1]")).getText();
		driver.findElement(By.linkText(linkValue2)).click();

		driver.switchTo().window(listHandle2.get(0));

		driver.findElement(By.className("buttonDangerous")).click();
		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Find Leads")).click();// Find Leads
		driver.findElement(By.name("id")).sendKeys(leadNo);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String noRecordText = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if (noRecordText.equalsIgnoreCase("No records to display")) {
			System.out.println("Successfully Merged");
		}

	}

}
