package vblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
	protected WebDriver driver;
	
	public PageBase(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	protected void sendKeys(WebElement webElement, String value) {
		for (int i = 0; i < value.length(); i++) {
			webElement.sendKeys(value.charAt(i) + "");
		}
	}	
}
