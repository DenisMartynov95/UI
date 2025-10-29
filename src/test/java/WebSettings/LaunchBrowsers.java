package WebSettings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LaunchBrowsers {
    protected WebDriver driver;

    @Parameters({"browser", "headless", "remote", "gridUrl"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(
            @Optional("CHROME") String browser,
            @Optional("false") String headless,
            @Optional("false") String remote,
            @Optional("http://localhost:4444/wd/hub") String gridUrl
    ) {
        System.out.println("🔧 Launching browser setup...");
        System.out.printf("Browser: %s | Headless: %s | Remote: %s%n", browser, headless, remote);

        driver = DriverFactory.createDriver(
                BrowserType.valueOf(browser.toUpperCase()),
                Boolean.parseBoolean(headless),
                Boolean.parseBoolean(remote),
                gridUrl
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 Browser closed successfully");
        }
    }
}
