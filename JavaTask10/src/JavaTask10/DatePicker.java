package JavaTask10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public String baseurl = "https://jqueryui.com/datepicker/";

	WebDriver driver = new ChromeDriver();

	public void openurl() {
		driver.get(baseurl);
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
	}

	public void nextmonth() {
		WebElement table = driver.findElement(By.xpath("//input[@id='datepicker']"));
		table.click();
		WebElement next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));	
		next.click();
	}

	public void datepick() {
		WebElement date = driver.findElement(By.xpath("//a[contains(text(),'22')]"));
		date.click();
		System.out.println("Output = "+date.getText());
		driver.quit();

	}

	public static void main(String[] args) {

		DatePicker picker = new DatePicker();
		picker.openurl();
		picker.nextmonth();
		picker.datepick();

	}

}
