//this program click on Alert button on automationbykrishna.com
package SeleniumAssignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertButton {

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
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Thread.sleep(1000);
		if (driver.switchTo().alert().getText().equals("You must be TechnoCredits student!!"))
			System.out.println("Expected message displayed");
		else
			System.out.println("Expected message not displayed");
		driver.switchTo().alert().accept();
		driver.quit();

	}

}
