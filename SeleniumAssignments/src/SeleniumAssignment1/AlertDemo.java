//This will input fields on Alert Demo on AutomationByKrishna.com
package SeleniumAssignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		String chromePath = "D:\\SeleniumClasses\\Prgrms_Eclipse\\SeleniumFirstProject\\Resources\\chromedriver.exe";

		File file = new File("config.properties");
		FileInputStream fb = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fb);

		String fName = prop.getProperty("AlertDemoFname");
		String laName = prop.getProperty("AlertDemoLname");
		String cName = prop.getProperty("AlertDemoCompany");
		String msg = fName + " " + "and" + " " + laName + " " + "and" + " " + cName;

		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(fName);
		Thread.sleep(1000);
		WebElement lname = driver.findElement(By.xpath("//input[@id='UserLastName']"));
		lname.sendKeys(laName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(cName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='firstRow']/div[1]/section/div/div[4]/button")).click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		if (alert.getText().equals(msg)) {
			System.out.println("Message '" + msg + "' displayed as expected");
		} else {
			System.out.println("Message '" + msg + "' not displayed as expected");
		}
		driver.switchTo().alert().accept();

		Thread.sleep(1000);
		driver.quit();

	}

}
