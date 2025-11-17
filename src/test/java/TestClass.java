import PageObjects.SI.MainPageSI;
import WebSettings.LaunchBrowsers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static Expected.SmokeTests.t1_registrationAccount.EXPECTED_USERNAME;
import static Other.ColorfulConsole.GREEN;
import static PageObjects.SI.MainPageSI.t2_smoke_username;

public class TestClass extends LaunchBrowsers {

//    @Test
//    public void smoke_registrationAccount() {
//        boolean checkUsername = new MainPageSI(driver)
//                .registrationAccount()
//                .registrationAccount()
//                .registrationAccount()
//                .checkAccount()
//                        .t1_checkUsername();
//        MatcherAssert.assertThat(EXPECTED_USERNAME,checkUsername);
//          System.out.println(GREEN + "Смоук-тест №1 прошел успешно!");
//
//    }


//    @Test
//    public void smoke_authorization() {
//        boolean checkUsername = new MainPageSI(driver)
//                .goToLoginPage()
//                .authorization()
//                .checkAuthorization()
//                        .t2_checkUsername();
//        MatcherAssert.assertThat(t2_smoke_username, checkUsername);
//        System.out.println(GREEN + "Смоук-тест №2 прошел успешно!");
//    }

    @Test
    public void smoke_logOut() {
        boolean checkUsername = new MainPageSI(driver)
                .goToLoginPage()
                .authorization()
                .checkAuthorization()
                .logOut()


    }

}
