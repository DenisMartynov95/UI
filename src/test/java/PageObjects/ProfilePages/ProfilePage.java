package PageObjects.ProfilePages;

import org.openqa.selenium.WebDriver;
import PageObjects.LoginPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Expected.SmokeTests.t1_registrationAccount.EXPECTED_USERNAME;
import static PageObjects.SI.MainPageSI.t2_smoke_username;

public class ProfilePage {


    private final WebDriver driver;
    public ProfilePage(WebDriver driver) { this.driver = driver; }


            /*
                  Блок локаторов
                                      */

    private final By username = By.xpath("/html/body/div[@class = 'wrapper-content']/div/div[@class = 'profile_head']/div[@class = 'main_user_info']/h1");


            /*
                Блок методов
                                     */

    // Тест №1 Регистрация и авторизация e2e
    // MainPageSI > LoginPage > SignUpPage > MainPageSI > ProfilePage
    public boolean t1_checkUsername () {
        return driver.findElement(username).getText().contains(EXPECTED_USERNAME);
    }


    // Тест №2 Авторизация
    // MainPageSI > LoginPage  > MainPageSI > ProfilePage
    public boolean t2_checkUsername () {
        return driver.findElement(username).getText().contains(t2_smoke_username);
    }





}
