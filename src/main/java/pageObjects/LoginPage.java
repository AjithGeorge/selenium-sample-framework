package pageObjects;

import helperMethods.ActionsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends ActionsHelper {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "inputUsername")
    WebElement username;

    @FindBy(name = "inputPassword")
    WebElement userPassword;

    @FindBy(className = "signInBtn")
    WebElement signInBtn;

    @FindBy(css = "p.error")
    WebElement error;

    public void goToLandingPage() {
        driver.get("https://rahulshettyacademy.com/locatorspractice");
    }

    public void login(String email, String password) {
        username.sendKeys(email);
        userPassword.sendKeys(password);
        signInBtn.click();
    }

    public String catchLoginError() {
        return (error.getText());
    }


}
