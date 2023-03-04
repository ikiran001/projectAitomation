package Intervw;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrokenLink {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\IntervirewPracticce\\Resources\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.codesdope.com/practice/java-classes-and-objects/");
		List<WebElement>links= driver.findElements(By.tagName("a"));
		List<String> listOfLinks=new ArrayList<>();			
		for(WebElement lnk: links) {
			String urls=lnk.getAttribute("href");
			listOfLinks.add(urls);
			lin(urls);
		}
	}
	public static void lin(String urle) throws IOException{
		URL url=new URL(urle);
		HttpURLConnection http=(HttpURLConnection) url.openConnection();
		http.connect();
		if(http.getResponseCode()>=400) {
			System.out.println(urle+http.getResponseMessage()+"is broken");
		}
	}

}
