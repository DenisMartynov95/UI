import PageObjects.SI.MainPageSI;
import WebSettings.LaunchBrowsers;
import org.testng.annotations.Test;

public class TestClass extends LaunchBrowsers {

    @Test
    public void smoke_registrationAccount() {
        MainPageSI success = new MainPageSI(driver)
                .registrationAccount()
                .registrationAccount()
                .registrationAccount();

    }


}
