package Intervw;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;	
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

import dev.failsafe.internal.util.Assert;

public class BrowserLaunching {


	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\IntervirewPracticce\\Resources\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.codesdope.com/practice/java-classes-and-objects/");
		driver.navigate().to("https://www.google.com/");


		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//-------------------------------------------------------------------------------
		driver.findElement(By.tagName("a")).getSize();
		WebElement e= driver.findElement(By.tagName("a"));
		driver.switchTo().alert().sendKeys("Enter code");
		Dimension sizz=e.getSize();
		System.out.println(sizz);
		driver.manage().window().maximize();
		//-------------------------------------------------------------------------------


		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			if(ele.getText().trim().equals("Discussion")) {
				ele.click();

			}
		}


		//_________________________________________________________________________________
		driver.navigate().back();
		driver.navigate().to(driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();

		//-------------------------------------------------------------------------------
		driver.findElement(By.xpath("//input[contains(@class,'signup_password_input')]"));

		//-------------------------------------------------------------------------------
		//explicitly wait
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("asd"))).
		click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//---------------------------------------------------------------------
		Select s=new Select(driver.findElement(By.xpath("adasd")));
		s.selectByIndex(1);
		s.selectByValue("adsa");
		s.selectByVisibleText("asdsa");


		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		//-------------------------------------------------------------------
		driver.switchTo().alert().accept();
		//-------------------------------------------------------------------------------
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(ss, new File("C:\\Users\\Admin\\Desktop\\Resume"));
		//-------------------------------------------------------------------------------	//_______________________________
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(""))).perform();
		ac.doubleClick(e).perform();
		ac.contextClick(e).perform();
		ac.dragAndDrop(e, e);


		//-------------------------------------------------------------------------------
		WebElement frame1=driver.findElement(By.xpath(""));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("rewuiredElement")).click();

		//-------------------------------------------------------------------------------		
		String parentWindow=driver.getWindowHandle();
		Set<String> windowHandle=driver.getWindowHandles();
		for(String windowSt :windowHandle) {
			if(!parentWindow.equals(windowSt)) {
				driver.switchTo().window(windowSt);
				//perform action
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		try {if(false) {
			throw new MyException("something is not right");
		}

		} catch (MyException e2) {
			e2.getMessage();		}
		//******************************************************************************************************
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,250)");
		je.executeScript("arguments[0].SCrollIntoView();", e);
		List<WebElement> a=(List<WebElement>) je.executeScript("document.getElementbyid('asds')");

		driver.switchTo().frame(frame1);	

	}	


	public void findBroken(String url) throws IOException {
		URL abc=new URL(url);
		HttpURLConnection http=(HttpURLConnection)abc.openConnection();
		http.connect();
		if(http.getResponseCode()>=400) {
			System.out.println(http.getResponseMessage()+"is broken link");
		}
	}
	
}


