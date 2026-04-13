package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login {
    WebDriver driver;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "SubmitLogin")
    WebElement loginButton;

    public Login(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.submit();
    }
}
