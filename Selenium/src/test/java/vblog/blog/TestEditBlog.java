package vblog.blog;

import java.time.LocalDateTime;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vblog.contexts.TestContext;
import vblog.managers.FileReaderManager;
import vblog.pages.BlogDetailsPage;
import vblog.pages.CreateBlogPage;
import vblog.pages.HomePage;

public class TestEditBlog {
	private TestContext testContext;
	private CreateBlogPage createBlogPage;
	private HomePage homePage;
	private BlogDetailsPage blogDetailsPage;

	@BeforeSuite
	public void setupTest() {
		this.testContext = TestContext.getInstance();
		this.createBlogPage = this.testContext.getPageObjectManager().getCreateBlogPage();
		this.homePage = this.testContext.getPageObjectManager().getHomePage();
		this.blogDetailsPage = this.testContext.getPageObjectManager().getBlogDetailsPage();
	}

	@AfterSuite
	public void tearDownTest() {
		this.testContext.getWebDriverManager().closeDriver();
	}

	@Test
	public void edit_blog_success() throws Exception {
		this.testContext.getWebDriverManager().getDriver()
				.get(FileReaderManager.getInstance().getConfigReader().getApplicatonUrl());
		Thread.sleep(1000);
		this.homePage.clickFirstBlog();
		Thread.sleep(1000);
		this.blogDetailsPage.clickEditBlog();
		Thread.sleep(1000);
		String title = "Title (Edited)- " + LocalDateTime.now();
		String content = "Content (Edited) - " + LocalDateTime.now();
		this.createBlogPage.enterTitle(title);
		this.createBlogPage.enterContent(content);		
		this.createBlogPage.clickSubmit();
		Thread.sleep(1000);
		// Should go to blog details page
		this.blogDetailsPage.blogTitleEquals(title);
		this.blogDetailsPage.blogContentEquals(content);
	}
}
