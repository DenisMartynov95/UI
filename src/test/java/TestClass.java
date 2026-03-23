import Expected.SmokeTests.t4_checkMainPageSwitch;
import PageObjects.SI.MainPageSI;
import WebSettings.LaunchBrowsers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static Expected.SmokeTests.t1_registrationAccount.EXPECTED_USERNAME;
import static Other.ColorfulConsole.*;
import static PageObjects.SI.MainPageSI.t2_smoke_username;

public class TestClass extends LaunchBrowsers {

//    @Test(description = "#1 Регистрация аккаунта")
//    public void smoke_registrationAccount() {
//        boolean checkUsername = new MainPageSI(driver)
//                .registrationAccount()
//                .registrationAccount()
//                .registrationAccount()
//                .checkAccount()
//                        .t1_checkUsername();
//        MatcherAssert.assertThat(EXPECTED_USERNAME,checkUsername);
//          System.out.println(GREEN + "Смоук-тест №1 прошел успешно!"+RESET);
//
//    }


//    @Test(description = "#2 Авторизация аккаунта")
//    public void smoke_authorization() {
//        boolean checkUsername = new MainPageSI(driver)
//                .goToLoginPage()
//                .authorization()
//                .checkAuthorization()
//                        .t2_checkUsername();
//        MatcherAssert.assertThat(t2_smoke_username, checkUsername);
//        System.out.println(GREEN + "Смоук-тест №2 прошел успешно!" +RESET);
//    }

//    @Test(description = "#3 Выход из аккаунта")
//    public void smoke_logOut() {
//        new MainPageSI(driver)
//                .goToLoginPage()
//                .authorization()
//                .checkAuthorization()
//                .logOut()
//                .checkLogInPageHeader();
//        System.out.println(GREEN + "Смоук-тест №3 прошел успешно! Разлогин осуществлен" +RESET);
//    }

//    @Test(description = "#4 Проверка смены основной страницы")
//    public boolean smoke_checkMainPageSwitch() {
//        boolean checkMainPageSwitch = new MainPageSI(driver)
//                .goToMIPage()
//                .checkMiPageIsOpen()
//                .checkSiPageIsOpen();
//        try {
//            MatcherAssert.assertThat(t4_checkMainPageSwitch.EXPECTED_SI_PAGE_NAME,checkMainPageSwitch);
//            System.out.println(GREEN + "Страница Win Informer успешно открыта!" + RESET);
//            return true;
//        }catch (Exception e){
//            System.out.println(PURPLE + "Страница Win Informer не была открыта!" + RESET);
//            return false;
//        }
//    }

    @Test(description = "#5 Работа кнопок по смене баннеров на страницах Win | MAC")
    public String smoke_efficiencyBannersBtn() {
         String checkBannersSwitch = new MainPageSI(driver)
                .checkSIBanners()
                .checkMIBanners();


        return checkBannersSwitch;
    }


}
