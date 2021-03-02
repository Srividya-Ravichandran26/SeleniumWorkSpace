package week3.day2;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		String strdate = date.toString();
		String newDate = strdate.replaceAll(":", "");
		File target = new File("./snaps/window_" + newDate+".png");
		FileUtils.copyFile(source, target);
		
		
		
		

	}

}
