package vblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy(id = "lnk-create-blog")
	private WebElement lnkCreateBlog;
	
	@FindBy(id = "lnk-signout")
	private WebElement lnkSignOut;
	
	@FindBy(xpath = "//span")
	private WebElement firstBlogTitle;
	
	public void clickCreateBlog() {
		lnkCreateBlog.click();
	}
	
	public void clickSignOut() {
		lnkSignOut.click();
	}
	
	public void clickFirstBlog() {
		this.firstBlogTitle.click();
	}
}
