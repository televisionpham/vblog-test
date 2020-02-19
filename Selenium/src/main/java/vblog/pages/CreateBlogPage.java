package vblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBlogPage extends PageBase {

	public CreateBlogPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "title")
	private WebElement txtTitle;
	
	@FindBy(id = "content")
	private WebElement txtContent;
	
	@FindBy(id = "btn-submit")
	private WebElement btnSubmit;
	
	public void enterTitle(String title) {
		this.txtTitle.click();
		this.txtTitle.clear();
		this.sendKeys(this.txtTitle, title);
	}
	
	public void enterContent(String content) {
		this.txtContent.click();
		this.txtContent.clear();
		this.sendKeys(this.txtContent, content);
	}
	
	public void clickSubmit() {
		this.btnSubmit.click();
	}
}
