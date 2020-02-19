package vblog.managers;

import org.openqa.selenium.WebDriver;

import vblog.pages.BlogDetailsPage;
import vblog.pages.CreateBlogPage;
import vblog.pages.HomePage;
import vblog.pages.SignInPage;

public class PageObjectManager {
	private WebDriver driver;
	private SignInPage signInPage;
	private HomePage homePage;
	private CreateBlogPage createBlogPage;
	private BlogDetailsPage blogDetailsPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage getSignInPage() {
		if (this.signInPage == null) {
			this.signInPage = new SignInPage(this.driver);
		}
		return signInPage;
	}
	
	public HomePage getHomePage() {
		if (this.homePage == null) {
			this.homePage = new HomePage(this.driver);
		}
		return this.homePage;
	}

	public CreateBlogPage getCreateBlogPage() {
		if (this.createBlogPage == null) {
			this.createBlogPage = new CreateBlogPage(driver);
		}
		return createBlogPage;
	}

	public BlogDetailsPage getBlogDetailsPage() {
		if (this.blogDetailsPage == null) {
			this.blogDetailsPage = new BlogDetailsPage(driver);
		}
		return blogDetailsPage;
	}
}
