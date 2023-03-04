package com.INB.pageFactory;

import org.openqa.selenium.By;



import enums.WaitStrategy;

public final class HomePageRetail extends BasePage {
	
	private final By retailLogout=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a");
	

	
	public RetailLogin clickOnLogout() throws Exception {
		click(retailLogout, WaitStrategy.PRESENCE, "Logout button");
		acceptAlert();
		return new RetailLogin();
		
		
	}
}
