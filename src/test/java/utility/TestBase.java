package utility;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class TestBase extends CommonMethods {

    public static WebDriver driver = initializeDriver();
    public LoginPage loginPage = new LoginPage(driver);


}
