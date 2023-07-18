import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.TestBase;

public class SelectorPracticeWithPageObject extends TestBase {

    @Test(dataProvider = "getCredentials")
    public void LoginWithInvalidCredentials(String username, String password) {
        loginPage.goToLandingPage();
        loginPage.login(username, password);
        String error = loginPage.catchLoginError();
        Assert.assertEquals(error, "* Incorrect username or password!");
    }


    @DataProvider()
    public Object[][] getCredentials() {
        return new Object[][]{{"john@doe.com", "pwd"}, {"jane@doe.com", "psd"}};
    }

}
