package vblog.contexts;

import vblog.managers.PageObjectManager;
import vblog.managers.WebDriverManager;

public class TestContext {
	private static TestContext context = new TestContext();
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	private TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public static TestContext getInstance() {
		return context;
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
