package week2.assignment;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println("The number of rows are:" + rows.size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td"));
		System.out.println("The number of column are:" + cols.size());

		// The Progress value of (Learn to interact with Elements)
		for (int i = 2; i <= rows.size(); i++) {
			List<WebElement> columnSize = driver.findElements(By.xpath("//table[@id='table_id']//tr[" + i + "]/td"));
			for (int j = 1; j < columnSize.size(); j++) {
				WebElement columnValue = driver
						.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[" + j + "]"));
				if (columnValue.getText().equalsIgnoreCase("Learn to interact with Elements")) {
					String progressValue = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]"))
							.getText();
					System.out.println("The Progress value of (Learn to interact with Elements) is:" + progressValue);
					break;
				}

			}
		}

		// Check Vital task for the least completed progress

		for (int j = 2; j <= rows.size(); j++) {

			String progressData = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + j + "]/td[2]"))
					.getText();
			if (progressData.equalsIgnoreCase("30%")) {
				driver.findElement(By.xpath("//table[@id='table_id']//tr["+j+"]/td[3]/input[@name='vital']")).click();
			}
		}

	}

}
