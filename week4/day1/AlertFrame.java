package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertFrame {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		driver.switchTo().alert().accept();
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println("The result is:" + text);
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		String strdate = date.toString();
		String newDate = strdate.replaceAll(":", "");
		File target = new File("./snaps/frame_" + newDate+".png");
		FileUtils.copyFile(source, target);
		
		

	}

}
