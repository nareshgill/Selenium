package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.File;

public class NewTest {
    private WebDriver driver;
    @Test
    public void testEasy() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Demo Guru99 Page"));
    }
    @BeforeTest
    public void beforeTest() {
        /*File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        driver = new FirefoxDriver(firefoxBinary, firefoxProfile);*/

        //System.setProperty("webdriver.gecko.driver","C:\\Users\\abhchauh0\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","/var/jenkins_home/workspace/jenkins-with-selenium/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette",true);
        driver= new FirefoxDriver(capabilities);
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
