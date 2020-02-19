package vblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
	protected WebDriver driver;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected void sendKeys(WebElement webElement, String value) {
		for (int i = 0; i < value.length(); i++) {
			webElement.sendKeys(value.charAt(i) + "");
		}
	}	
}
