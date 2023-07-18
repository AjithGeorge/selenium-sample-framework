import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SelectorPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("https://rahulshettyacademy.com/locatorspractice");
        var elements =driver.findElements(By.id("inputUsernames"));
        driver.findElement(By.id("inputUsername")).sendKeys("John");
        driver.findElement(By.name("inputPassword")).sendKeys("hola");
        driver.findElement(By.className("signInBtn")).click();
        String error = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(error);
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("JohnDoe");
        driver.findElement(By.cssSelector("input[placeholder ='Email']")).sendKeys("john@doe.com");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".go-to-login-btn")));
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("inputUsername")));
        driver.findElement(By.id("inputUsername")).sendKeys("John");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000); //Nothing else works in this case.
        driver.findElement(By.cssSelector(".signInBtn")).click();
        Thread.sleep(1000); //Nothing else works in this case.
        String successMsg = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(successMsg, "You are successfully logged in.");


    }
}
