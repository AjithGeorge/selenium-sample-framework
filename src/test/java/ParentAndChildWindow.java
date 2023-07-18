import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParentAndChildWindow extends TestBase {


    @Test
    public void flipkartCheck() {

        driver.get("http://google.com");
        driver.findElement(By.cssSelector("textarea[title=Search]")).sendKeys("flipkart" + Keys.ENTER);
        var results = driver.findElements(By.xpath("//h3[text()='Flipkart']"));
        results.get(0).click();
        driver.findElement(By.xpath("//button[text()='✕']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Search for products, brands and more']")).sendKeys("laptop" + Keys.ENTER);
        var laptops = driver.findElements(By.cssSelector("div[class='_4rR01T']"));
        System.out.println(laptops);
        System.out.println(laptops.get(0).getText());
        for (WebElement element : laptops) {
            if (element.getText().contains("CHUWI")) {
                element.click();
            }
        }
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        System.out.println(driver.getTitle());
    }


    @Test
    public void parentAndChildWindowHandling() {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
        Set<String> windows = driver.getWindowHandles();
        List<String> windowsList = new ArrayList<>(windows);
        driver.switchTo().window(windowsList.get(1));
        String username = driver.findElement(By.partialLinkText("@rahulshettyacademy.com")).getText();
        driver.switchTo().window(windowsList.get(0));
        driver.findElement(By.cssSelector("[id='username']")).sendKeys(username);

    }
}
