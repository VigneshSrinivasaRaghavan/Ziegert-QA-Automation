package factories;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadPropertyFile;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        WebDriver driver = null;
        String browser = ReadPropertyFile.getValue(ConfigProperties.BROWSER);

        if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        return driver;
    }
}
