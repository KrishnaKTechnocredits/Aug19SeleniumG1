//This will input fields on Basic Forms on AutomationByKrishna.com
package SeleniumAssignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicForms {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(prop.getProperty("username"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys(prop.getProperty("pwd"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='firstRow']/div[2]//input[@type = 'checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='firstRow']//div[5]/button[@type='submit']")).click();
		Thread.sleep(1000);
		if (driver.switchTo().alert().getText().equals("You successfully clicked on it"))
			System.out.println("Message displayed as expected");
		else
			System.out.println("Message not displayed as expected");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.quit();
	}

}
