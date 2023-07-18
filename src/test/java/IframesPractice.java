import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utility.TestBase;

public class IframesPractice extends TestBase {

    @Test
    public void framesPractice() {
        driver.get("http://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        Actions act =new Actions(driver);
        WebElement source =driver.findElement(By.cssSelector("div#draggable"));
        WebElement dest = driver.findElement(By.cssSelector("div#droppable"));
        act.dragAndDrop(source,dest).build().perform();
        driver.switchTo().defaultContent();
    }
}
