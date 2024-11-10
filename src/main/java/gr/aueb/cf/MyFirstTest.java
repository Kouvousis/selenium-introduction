package gr.aueb.cf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");  // opens the url
        driver.manage().window().maximize();    // maximize the browser

        driver.findElement(By.name("search")).click();
        //Thread.sleep(3000);
        driver.findElement(By.name("search")).sendKeys("Macbook");
        //Thread.sleep(3000);
        driver.findElement(By.className("btn-default")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("MacBook"))
                .click();
        driver.findElement(By.id("input-quantity")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("input-quantity")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("input-quantity")).sendKeys("2");
        Thread.sleep(2000);
        driver.close();

    }
}
