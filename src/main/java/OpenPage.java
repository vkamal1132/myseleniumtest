
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Sleeper;
//import org.testng.internal.thread.ThreadUtil;

public class OpenPage {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/vishali/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:8080/employee-payslips/#!/login#employee";
		driver.get(baseUrl);
		String login = driver.getTitle();
		System.out.println(login);
		String expectedTitle = "Employee Payslips";
		assertEquals(expectedTitle, login);

		WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[1]/input"));

		username.sendKeys("aaaa");
		username.submit();
		WebElement password = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[2]/input"));
		password.sendKeys("admin");
		password.submit();

		// click on the Sign in button

		WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/fieldset/div[4]/button"));
		loginbutton.click();
		//Thread.sleep(5000);
		driver.quit();
	}
}