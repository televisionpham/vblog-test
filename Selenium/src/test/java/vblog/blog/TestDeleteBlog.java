package vblog.blog;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vblog.contexts.TestContext;
import vblog.managers.FileReaderManager;
import vblog.pages.BlogDetailsPage;
import vblog.pages.HomePage;

public class TestDeleteBlog {
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
	public void delete_blog_success() throws Exception {
		this.testContext.getWebDriverManager().getDriver()
				.get(FileReaderManager.getInstance().getConfigReader().getApplicatonUrl());
		Thread.sleep(1000);
		this.homePage.clickFirstBlog();
		Thread.sleep(1000);
		this.blogDetailsPage.clickDeleteBlog();
		Thread.sleep(1000);
		// confirm
		this.testContext.getWebDriverManager().getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
		// should to to home page
		Assert.assertEquals(this.testContext.getWebDriverManager().getDriver().getCurrentUrl(),
				FileReaderManager.getInstance().getConfigReader().getApplicatonUrl());
		// should check the deleted blog is not in the list
		Thread.sleep(2000);
	}
}
