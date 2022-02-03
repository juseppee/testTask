package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "passp-field-login")
    private WebElement loginField;

    @FindBy(id = "passp:sign-in")
    private WebElement enterButton;

    @FindBy(id = "passp-field-passwd")
    private WebElement passField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;

    public WebDriver driver;

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void pickLoginBtn(){
        loginBtn.click();
    }

    public void enterLogin(String login){
        loginField.sendKeys(login);
    }

    public void pressEnter() {
        enterButton.click();
    }

    public void enterPassword(String password){
        passField.sendKeys(password);
    }
}
