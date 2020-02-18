package vblog.auth;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vblog.contexts.TestContext;
import vblog.managers.FileReaderManager;
import vblog.pages.SignInPage;

public class TestAuth {
	private TestContext testContext;
	private SignInPage signInPage;	

	@BeforeSuite
	public void setUpTest() {
		this.testContext = TestContext.getInstance();
		this.signInPage = this.testContext.getPageObjectManager().getSignInPage();		
	}

	@AfterSuite
	public void tearDownTest() {
		this.testContext.getWebDriverManager().closeDriver();
	}

	@Test
	public void sign_in_success() throws Exception {
		this.testContext.getWebDriverManager().getDriver()
				.get(FileReaderManager.getInstance().getConfigReader().getApplicatonUrl());
		String email = "mot@vanpt.com";
		String password = "123456";		
		this.signInPage.enterEmail(email);
		Thread.sleep(1000);
		this.signInPage.enterPassword(password);
		Thread.sleep(1000);
		this.signInPage.clickSignIn();
		Thread.sleep(5000);
	}
}
