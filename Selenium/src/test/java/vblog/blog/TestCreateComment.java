package vblog.blog;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vblog.contexts.TestContext;
import vblog.managers.FileReaderManager;
import vblog.pages.BlogDetailsPage;
import vblog.pages.HomePage;

public class TestCreateComment {
	private TestContext testContext;	
	private HomePage homePage;
	private BlogDetailsPage blogDetailsPage;

	@BeforeSuite
	public void setupTest() {
		this.testContext = TestContext.getInstance();		
		this.homePage = this.testContext.getPageObjectManager().getHomePage();
		this.blogDetailsPage = this.testContext.getPageObjectManager().getBlogDetailsPage();
	}

	@AfterSuite
	public void tearDownTest() {
		this.testContext.getWebDriverManager().closeDriver();
	}

	@Test
	public void create_comment_success() throws Exception {
		this.testContext.getWebDriverManager().getDriver()
				.get(FileReaderManager.getInstance().getConfigReader().getApplicatonUrl());
		Thread.sleep(1000);
		this.homePage.clickFirstBlog();
		Thread.sleep(1000);		
		String comment = "Comment - " + LocalDateTime.now();
		this.blogDetailsPage.enterComment(comment);
		this.blogDetailsPage.clickSubmitComment();
		Thread.sleep(1000);		
		// comment should appears below
		WebElement el = this.testContext.getWebDriverManager().getDriver()
				.findElement(By.xpath("//*[text()='"+ comment  +"']"));
		Thread.sleep(2000);
	}
}
