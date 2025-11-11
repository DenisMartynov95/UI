package WebSettings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver createDriver(BrowserType browser, boolean headless, boolean isRemote, String gridUrl) {
        try {
            switch (browser) {
                case FIREFOX:
                    return createFirefoxDriver(headless, isRemote, gridUrl);
                case CHROME:
                default:
                    return createChromeDriver(headless, isRemote, gridUrl);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("⚠️ Invalid Selenium Grid URL: " + e.getMessage());
        }
    }

    private static WebDriver createChromeDriver(boolean headless, boolean isRemote, String gridUrl) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions cOpts = new ChromeOptions();
        cOpts.addArguments("--no-sandbox");
        cOpts.addArguments("--disable-dev-shm-usage");
        cOpts.addArguments("--remote-allow-origins=*");
        cOpts.addArguments("--disable-gpu");
        cOpts.addArguments("--disable-notifications");
        cOpts.addArguments("--disable-infobars");
        cOpts.addArguments("--start-maximized");
        cOpts.addArguments("--disable-dev-shm-usage");
        cOpts.addArguments("--disable-features=NetworkServiceInProcess");
        cOpts.addArguments("--disable-background-networking");
        cOpts.addArguments("--disable-client-side-phishing-detection");
        cOpts.addArguments("--no-first-run");


        if (headless) cOpts.addArguments("--headless=new");

        if (isRemote) {
            System.out.println("🌐 Running in remote mode (Grid)...");
            return new RemoteWebDriver(new URL(gridUrl), cOpts);
        }
        System.out.println("💻 Running Chrome locally...");
        return new ChromeDriver(cOpts);
    }

    private static WebDriver createFirefoxDriver(boolean headless, boolean isRemote, String gridUrl) throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions fOpts = new FirefoxOptions();
        fOpts.addArguments("--width=1920", "--height=1080");
        if (headless) fOpts.addArguments("--headless");

        if (isRemote) {
            System.out.println("🌐 Running in remote mode (Grid)...");
            return new RemoteWebDriver(new URL(gridUrl), fOpts);
        }
        System.out.println("💻 Running Firefox locally...");
        return new FirefoxDriver(fOpts);
    }
}
