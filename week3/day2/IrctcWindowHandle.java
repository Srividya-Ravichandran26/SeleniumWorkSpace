package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcWindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.linkText("FLIGHTS")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		List<String> listHandle = new ArrayList<String>(allWindows);
		driver.switchTo().window(listHandle.get(1));
		String emailText = driver.findElement(By.linkText("flights@irctc.co.in")).getText();
		System.out.println(emailText);
		driver.switchTo().window(listHandle.get(0));
		driver.close();
	}

}
