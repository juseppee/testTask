package org.example.Pages;

import org.example.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(className = "textinput__control")
    private WebElement findField;

    @FindBy(xpath = "//*[contains(@class, 'search-input')]//button")
    private WebElement findBtn;

    @FindBy(xpath = "//*[contains(text(), 'Папки')]/../..")
    private WebElement foldersBtn;

    @FindBy(xpath = "//*[contains(text(), 'Входящие')]/parent::div[contains(@class, 'type_option')]")
    private WebElement inboxBtn;

    @FindBy(xpath = "//span[contains(@class, 'mail-MessagesSearch')]/child::span")
    private WebElement amountOfMails;

    @FindBy(className = "mail-ComposeButton-Text")
    private WebElement writeBtn;

    @FindBy(className = "composeYabbles")
    private WebElement receiverField;

    @FindBy(name = "subject")
    private WebElement themeField;

    @FindBy(xpath = "//*[contains(@class, 'cke_contents cke_reset')]/child::div")
    private WebElement textField;

    @FindBy(xpath = "//div[contains(@class,'ControlPanel-Part')]//button")
    private WebElement sendBtn;

    public WebDriver driver;

    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputTheme(String theme){
        findField.sendKeys(theme);
    }

    public void clickFind(){
        findBtn.click();
    }

    public void clickFolders(){
        foldersBtn.click();
    }

    public void pickInbox(){
        inboxBtn.click();
    }

    public String amountOfMails(){
        return amountOfMails.getText();
    }

    public void writeMessage(){
        writeBtn.click();
    }

    public void inputReceiver(String login){
        receiverField.sendKeys(login);
    }

    public void setTheme(String theme){
        themeField.sendKeys(theme);
    }

    public void inputMessage(String message){
        textField.sendKeys(message);
    }

    public void sendMessage(){
        sendBtn.click();
    }
}
