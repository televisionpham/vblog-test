package vblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogDetailsPage extends PageBase {

	public BlogDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "blog-title")
	private WebElement lblBlogTitle;
	
	@FindBy(id = "blog-content")
	private WebElement lblBlogContent;
	
	@FindBy(id = "btn-edit-blog")
	private WebElement btnEditBlog;
	
	@FindBy(id = "btn-delete-blog")
	private WebElement btnDeleteBlog;
	
	@FindBy(id = "txt-comment-content")
	private WebElement txtCommentContent;
	
	@FindBy(id = "btn-submit-comment")
	private WebElement btnSubmitComment;
	
	public boolean blogTitleEquals(String value) {
		return this.lblBlogTitle.getText().equals(value);
	}
	
	public boolean blogContentEquals(String value) {
		return this.lblBlogContent.getText().equals(value);
	}
	
	public void clickEditBlog() {
		this.btnEditBlog.click();
	}
	
	public void clickDeleteBlog() {
		this.btnDeleteBlog.click();
	}
	
	public void enterComment(String value) {
		this.sendKeys(this.txtCommentContent, value);
	}
	
	public void clickSubmitComment() {
		this.btnSubmitComment.click();
	}
}
