import Expected.SmokeTests.asserts_t4_checkMainPageSwitch;
import PageObjects.MI.MainPageMI;
import PageObjects.SI.MainPageSI;
import WebSettings.LaunchBrowsers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static Expected.SmokeTests.asserts_t1_registrationAccount.EXPECTED_USERNAME;
import static Other.ColorfulConsole.*;
import static PageObjects.SI.MainPageSI.t2_smoke_username;
import static Parametrized.SmokeTests.t7_t8_smoke_availability_of_categories.ListOfCategories.listOfCategories_isEquals;

public class TestClass extends LaunchBrowsers {

    @Test(description = "#1 Регистрация аккаунта")
    public void smoke_registrationAccount() {
        boolean checkUsername = new MainPageSI(driver)
                .registrationAccount()
                .registrationAccount()
                .registrationAccount()
                .checkAccount()
                        .t1_checkUsername();
        MatcherAssert.assertThat(EXPECTED_USERNAME,checkUsername);
          System.out.println(GREEN + "Смоук-тест №1 прошел успешно!"+RESET);

    }


    @Test(description = "#2 Авторизация аккаунта")
    public void smoke_authorization() {
        boolean checkUsername = new MainPageSI(driver)
                .goToLoginPage()
                .authorization()
                .checkAuthorization()
                        .t2_checkUsername();
        MatcherAssert.assertThat(t2_smoke_username, checkUsername);
        System.out.println(GREEN + "Смоук-тест №2 прошел успешно!" +RESET);
    }

    @Test(description = "#3 Выход из аккаунта")
    public void smoke_logOut() {
        new MainPageSI(driver)
                .goToLoginPage()
                .authorization()
                .checkAuthorization()
                .logOut()
                .checkLogInPageHeader();
        System.out.println(GREEN + "Смоук-тест №3 прошел успешно! Разлогин осуществлен" +RESET);
    }

    @Test(description = "#4 Проверка смены основной страницы")
    public boolean smoke_checkMainPageSwitch() {
        boolean checkMainPageSwitch = new MainPageSI(driver)
                .goToMIPage()
                .checkMiPageIsOpen()
                .checkSiPageIsOpen();
        try {
            MatcherAssert.assertThat(asserts_t4_checkMainPageSwitch.EXPECTED_SI_PAGE_NAME,checkMainPageSwitch);
            System.out.println(GREEN + "Страница Win Informer успешно открыта!" + RESET);
            return true;
        }catch (Exception e){
            System.out.println(PURPLE + "Страница Win Informer не была открыта!" + RESET);
            return false;
        }
    }

    @Test(description = "#5 Работа кнопок по смене баннеров на страницах Win | MAC")
    public void smoke_efficiencyBannersBtn() {
        try {
            new MainPageSI(driver)
                    .checkSIBanners()
                    .checkMIBanners();
            System.out.println(GREEN + "Смоук-тест №5 прошел успешно! Баннеры переключаются!" + RESET);
        } catch (Exception e) {
            System.out.println( PURPLE + "Смоук-тест №5 провалился!" + RESET);
        }
    }

    @Test(description = "#6 Проверка доступных локалей")
    public void smoke_availability_of_locales() {
        try {
            new MainPageSI(driver)
                    .checkListOfLocales();
            System.out.println(GREEN + "Смоук-тест №6 прошел успешно! Все заявленные локализации имеются на страницах SI и MI" + RESET);
        } catch (Exception e) {
            System.out.println( PURPLE + "Смоук-тест №6 провалился!" + RESET);
        }
    }

    @Test(description = "#7 Проверка доступных категорий на странице SI")
    public void smoke_availability_of_categoriesSI(){
            new MainPageSI(driver)
                    .checkListOfCategories();
            if (listOfCategories_isEquals) {
                System.out.println(GREEN + "Смоук-тест №7 прошел успешно! Все заявленные категории имеются на странице SI" + RESET);
            } else {
            System.out.println( PURPLE + "Смоук-тест №7 провалился!" + RESET);
        }
    }

    @Test(description = "#8 Проверка доступных категорий на странице MI")
    public void smoke_availability_of_categoriesMI(){
            new MainPageMI(driver)
                    .checkListOfCategories();
            // Импортировал флаг, который результатирует каждое сравнение отдельно и в случае чего валит тест
            if (listOfCategories_isEquals) {
                System.out.println(GREEN + "Смоук-тест №7 прошел успешно! Все заявленные категории имеются на странице SI" + RESET);
            } else {
            System.out.println( PURPLE + "Смоук-тест №7 провалился!" + RESET);
        }
    }

    @Test(description = "#9 Проверка отображения программ в рекламных блоках")
public void smoke_display_ADVProgSI() {
        new MainPageSI(driver)


    }


}
