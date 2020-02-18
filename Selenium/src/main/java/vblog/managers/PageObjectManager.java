package vblog.managers;

import org.openqa.selenium.WebDriver;

import vblog.pages.SignInPage;

public class PageObjectManager {
	private WebDriver driver;
	private SignInPage signInPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage getSignInPage() {
		if (this.signInPage == null) {
			this.signInPage = new SignInPage(this.driver);
		}
		return signInPage;
	}
}
