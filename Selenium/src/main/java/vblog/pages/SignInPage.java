package vblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase{

	public SignInPage(WebDriver webDriver) {
		super(webDriver); 
	}
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(id = "btn-signin")
	private WebElement btnSignIn;
	
	@FindBy(id = "signup")
	private WebElement lnkSignUp;
	
	public void enterEmail(String email) {
		this.txtEmail.click();
		this.txtEmail.clear();
		this.txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		this.txtPassword.click();
		this.txtPassword.clear();
		this.txtPassword.sendKeys(password);
	}
	
	public void clickSignIn() {
		this.btnSignIn.click();
	}
}
