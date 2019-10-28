//this program click on javascript confirmation button on automationbykrishna.com
package SeleniumAssignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptConfirmationButton {

	public static void main(String[] args) throws InterruptedException {
		String chromePath = "D:\\SeleniumClasses\\Prgrms_Eclipse\\SeleniumFirstProject\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed OK!"))
			System.out.println("Okay button has been clicked");
		else
			System.out.println("Scenarion failed! Okay button has not been clicked");
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("You pressed Cancel!"))
			System.out.println("Cancel button has been clicked");
		else
			System.out.println("Scenarion failed! Cancel button has not been clicked");
		driver.quit();

	}

}
