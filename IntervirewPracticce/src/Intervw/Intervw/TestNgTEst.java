package Intervw.Intervw;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgTEst {
	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("before Class");
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println();
		System.out.println("Before Method");
	}
	@Test(priority = 1 ,enabled = false , invocationCount = 1 , dataProvider = "asdsa")
	public void f() {

		System.out.println("test0");
		
	}
	@Test(priority = 0)
	public void f1() {
		
		System.out.println("test1");
		
	}
	@Test(priority = 3)
	public void f2() {
	
		System.out.println("test2");
		
	}
	@Test(priority = -1)
	public void f3() {
		
		System.out.println("test3");
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method");
		System.out.println();
	}
	
	
	@DataProvider(name="data")
	public void dataprovide() {
		System.out.println("Data provide");
	}
}
