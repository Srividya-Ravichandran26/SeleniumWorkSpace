package week4.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapAssignment {

	public static void main(String[] args) throws Exception {
		// https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		boolean checkboxSelected = driver.findElement(By.id("chkSelectDateOnly")).isSelected();
		if (checkboxSelected == true) {
			driver.findElement(By.id("chkSelectDateOnly")).click();
		}

		Thread.sleep(2000);

		List<WebElement> trainNo = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[1]"));
		List<WebElement> trainName = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));

		Map<Integer, String> trains = new HashMap<Integer, String>();

		for (int i = 0; i < trainNo.size(); i++) {
			trains.put((Integer.parseInt(trainNo.get(i).getText())), (trainName.get(i).getText()));
		}

//		List<WebElement> trainRows = driver
//				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
////		System.out.println(trainRows.size());
//		for (int i = 1; i <= trainRows.size(); i++) {
//
//			if (!driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]"))
//					.getText().contains("Below trains not departing")) {
//				Integer trainNo = Integer.parseInt(driver
//						.findElement(
//								By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[1]"))
//						.getText());
//				String trainName = driver
//						.findElement(
//								By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]"))
//						.getText();
////				System.out.println(trainNo + ":" + trainName);
//				trains.put(trainNo, trainName);
//			}
//		}

		int maxNo = Integer.MIN_VALUE;
		for (Entry<Integer, String> eachTrain : trains.entrySet()) {
			Integer number = eachTrain.getKey();
			maxNo = Math.max(maxNo, number);
		}

		System.out.println("Train No:" + maxNo);
		for (Entry<Integer, String> eachTrainName : trains.entrySet()) {
			Integer number = eachTrainName.getKey();
			if (number == maxNo) {
				System.out.println("Train Name of Bigger Train No is:" + eachTrainName.getValue());
				break;
			}

		}

	}

}
