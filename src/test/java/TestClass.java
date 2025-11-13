import PageObjects.SI.MainPageSI;
import WebSettings.LaunchBrowsers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static Expected.SmokeTests.t1_registrationAccount.EXPECTED_USERNAME;

public class TestClass extends LaunchBrowsers {

    @Test
    public void smoke_registrationAccount() {
        boolean checkUsername = new MainPageSI(driver)
                .registrationAccount()
                .registrationAccount()
                .registrationAccount()
                .checkAccount()
                        .checkUsername();
        MatcherAssert.assertThat(EXPECTED_USERNAME,checkUsername);

    }


}
