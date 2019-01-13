package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAggiungiCurriculum {

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
	      
	      driver.findElement(By.xpath("/html/body/div[1]/div[2]/a")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"laureaScelta2\"]")).click();
	    
	      driver.findElement(By.xpath("/html/body/div[1]/div[6]/form/button/span")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"nomeCurricula\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"nomeCurricula\"]")).sendKeys("prova");
	      
	      driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/button")).click();
	      
	      //Close the Browser.
	      driver.close();
	}
}
