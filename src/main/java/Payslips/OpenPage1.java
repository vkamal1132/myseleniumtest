
package Payslips;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenPage1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vishali/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "http://localhost:8080/employee-payslips/#!/login#employee";
		driver.get(baseUrl);
		String loginpage = driver.getTitle();
		System.out.println(loginpage);
		String expectedTitle = "Employee Payslips";
		assertEquals(expectedTitle, loginpage);

		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys("aaa");
		username.submit();

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		password.submit();

		// click on the Sign in button

		// WebElement Login = driver.findElement(By.name("Login"));
		// Login.click();

	}
}
