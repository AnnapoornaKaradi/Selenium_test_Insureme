package sample.com.assignment.test;
import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
//import org.testng.annotations.Test;


public class AppTest {
	@Test
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-usage");
		 ChromeDriver driver = new ChromeDriver(options);
		
	  String URL="http://54.159.179.154:8081/contact.html";
	  driver.get(URL);
	  driver.manage().window().maximize();
	  driver.findElement(By.id("inputName")).sendKeys("Annu");
	  driver.findElement(By.id("inputNumber")).sendKeys("9188836381");
	  driver.findElement(By.id("inputMail")).sendKeys("annuannu108@gmail.com");
	  driver.findElement(By.id("inputMessage")).sendKeys("Hello All!");
	  String message=driver.findElement(By.id("response")).getText();
	  if(message.equals("Message Sent")) {
		  System.out.println("Script Executed");
	  }
	  else
	  {
		  System.out.println("Script Failed");
	  }
	  TakesScreenshot ss= ((TakesScreenshot)driver);
	  File sshot=ss.getScreenshotAs(OutputType.FILE);
	  try {
		FileHandler.copy(sshot,new File("//home//ubuntu//screenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
}
}

