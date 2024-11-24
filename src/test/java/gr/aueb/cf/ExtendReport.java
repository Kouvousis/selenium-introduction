package gr.aueb.cf;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExtendReport {

    ExtentReports extent;

    @Test
    public void initialDemos() throws InterruptedException {

        extent.createTest("Coding Factory Test");

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("submit")).click();
        String errorMessage = driver.findElement(By.className("error")).getText();
        System.out.println(errorMessage);
        driver.close();

        extent.flush();
    }

    @BeforeTest
    public void configs() {
        String path = System.getProperty("user.dir", "\\reports\\testIndex.html");
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("CF Web Automation Test Report");
        reporter.config().setDocumentTitle("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Jim Kouvousis");
    }
}
