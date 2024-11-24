package gr.aueb.cf;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {

    @Test
    public void AppiumTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Test_phone");
        options.setApp("C:\\Users\\jim\\Downloads\\ApiDemos-debug.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();

        driver.quit();
    }
}
