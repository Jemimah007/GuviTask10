package JavaTask10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class DragAndDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));

		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		WebElement dropped = driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
		String s = drop.getCssValue("color");
		String c = Color.fromString(s).asHex();
		String color = "#777620";
		if (color.equals(c)) {
			System.out.println("The color is matching");
		} else
			System.out.println("The color is not matching");
		boolean droppedstatus = dropped.isDisplayed();
		if (droppedstatus) {
			System.out.println("The text is changed to Dropped");
		} else
			System.out.println("The text is not changed to Dropped");
	}
}