
import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelLogin {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/vishali/Downloads/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://localhost:8080/employee-payslips/#!/login#employee";
		driver.get(baseUrl);
			
		try {
            FileInputStream fStream = new FileInputStream(new File(
                    "C:/Users/vishali/Desktop/Test.xlsx"));
            // Create workbook instance referencing the file created above
            XSSFWorkbook workbook = new XSSFWorkbook(fStream);
            
            XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet

            XSSFRow row = sheet.getRow(1);
            XSSFCell cell1 = row.getCell(0);
            XSSFCell cell2 = row.getCell(1);
            XSSFCell cell3 = row.getCell(2);

            location = cell1.toString();
            activity = cell2.toString();
            order = cell3.toString();

            fStream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

            
		
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
		
		Test.put("2", new Object[] { 1d, "login with valid credentials", "login successful", "Pass" });
	  } 
	catch (Exception ex) {
	   Test.put("2", new Object[] { 1d, "login with valid credentials", "login successful", "Fail" });
	  }
	 
		//Thread.sleep(5000);
		//driver.quit();
	}
