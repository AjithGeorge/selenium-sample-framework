import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.TestBase;

public class AlertsAndDropdownPractice extends TestBase {

    public static void main(String[] args) {
        driver = initializeDriver();

        //Alerts
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        System.out.println(driver.findElement(By.xpath("//header/div/button[1]")).getText());
//        driver.findElement(By.id("alertbtn")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        driver.switchTo().alert().accept();

        //Navigation
//        driver.findElement(By.linkText("Home")).click();
//        driver.navigate().to("https://google.com");
//        driver.navigate().back();

        //DropDowns
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select staticDropdown = new Select(dropdown);
        staticDropdown.selectByIndex(2);
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        staticDropdown.selectByVisibleText("INR");
        System.out.println(staticDropdown.getFirstSelectedOption().getText());
        driver.findElement(By.id("divpaxinfo")).click();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.linkText("Goa (GOI)")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath(("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='COK']"))).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
    }
}
