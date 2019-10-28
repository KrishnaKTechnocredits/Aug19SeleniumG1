//this program click on javascript prompt button on automationbykrishna.com
package SeleniumAssignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptPrompt {

	public static void main(String[] args) throws InterruptedException, IOException {
		String chromePath = "D:\\SeleniumClasses\\Prgrms_Eclipse\\SeleniumFirstProject\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		File file = new File("config.properties");
		FileInputStream fb = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fb);
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("ABCD");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		String msg = "Hello " + prop.getProperty("JavascriptConfirmationName") + "! How are you today?";
		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals(msg))
			System.out.println("Scenario Passed");
		else
			System.out.println("Scenario Failed");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		if (driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText().equals("User cancelled the prompt."))
			System.out.println("Scenario Passed");
		else
			System.out.println("Scenario Failed");
		driver.quit();
	}

}
