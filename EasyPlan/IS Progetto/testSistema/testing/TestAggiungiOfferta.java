package testing_sistema;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAggiungiOfferta {

	public static final String PATH="C:\\Users\\franc\\Desktop\\PROGETTO\\chromedriver.exe";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",PATH );
		WebDriver driver = new ChromeDriver();
		
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to("http://localhost:8080/IS_Progetto/Homepage.html");
	      
	      //Maximize the browser
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.xpath("./html/body/nav/div/div[2]/ul/li/a")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin");
	      
	      driver.findElement(By.xpath("/html/body/div[1]/div/form/div[3]/button")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[1]/form/div/button/span")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"nomeOfferta\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"nomeOfferta\"]")).sendKeys("2020/21");
	      
	      driver.findElement(By.xpath("/html/body/form[2]/div[4]/input")).click();
	      
	      //Close the Browser.
	      driver.close();
	}
}
