package com.INB.tests;

import java.util.Map;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.INB.pageFactory.RetailLogin;





public final class TC_RetailLoginLogout extends BaseTest{


	@Test()
	public void loginLogout(Map<String , String> data) throws Exception {


		String title=new RetailLogin().enterUserName(data.get("username")).enterPass(data.get("password")).getCaptchaCode().clickOnLoginBtn()
				.clickOnLogout()
				.getTitle();

		Assertions.assertThat(title)
		.isEqualTo("Login");
	}



	@Test()
	public void test1(Map<String , String> data) throws Exception {


		String title=new RetailLogin().enterUserName(data.get("username")).enterPass(data.get("password")).getCaptchaCode().clickOnLoginBtn()
				.clickOnLogout()
				.getTitle();

		Assertions.assertThat(title)
		.isEqualTo("Login");
	}


}
