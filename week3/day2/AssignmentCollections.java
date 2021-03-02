package week3.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentCollections {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("ms", Keys.TAB, Keys.TAB); // From
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("mdu",Keys.TAB);// To
		boolean checkboxSelected = driver.findElement(By.id("chkSelectDateOnly")).isSelected();
		if(checkboxSelected == true)
		{
			driver.findElement(By.id("chkSelectDateOnly")).click();
		}
		Thread.sleep(2000);
		
		List<String> trainNames = new ArrayList<String>();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		for (int i = 1; i <= rows.size(); i++) {
				String values= driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
				trainNames.add(values);	
				
		}
		
		int trainListSize = trainNames.size();		
		Set<String> duplicateValues = new LinkedHashSet<String>(trainNames);
		int trainSetSize = duplicateValues.size();	
		
		if(trainListSize==trainSetSize)
		{
			System.out.println("Both List and Set size is equal. Hence all Train names are unique");
		}
		else
		{
			System.out.println("Duplicate values are present and count is: " + (trainListSize-trainSetSize));
			System.out.println("The List without duplicate values");
			for (String eachValue : duplicateValues) {

				System.out.println(eachValue);
			}
		}
	}

}
