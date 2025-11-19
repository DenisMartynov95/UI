package PageObjects.ProfilePages;

import PageObjects.SI.MainPageSI;
import org.openqa.selenium.WebDriver;
import PageObjects.LoginPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Expected.SmokeTests.t1_registrationAccount.EXPECTED_USERNAME;
import static Other.ColorfulConsole.*;
import static PageObjects.SI.MainPageSI.t2_smoke_username;

public class ProfilePage {


    private final WebDriver driver;
    public ProfilePage(WebDriver driver) { this.driver = driver; }


    /*
                  Блок локаторов
                                                 */

    private final By username = By.xpath("/html/body/div[@class = 'wrapper-content']/div/div[@class = 'profile_head']/div[@class = 'main_user_info']/h1");

    // Кнопочки
    private final By btn_profileMenu = By.xpath(".//div/a[@class = 'login_user']/img");
    private final By btn_logOut = By.xpath(".//div/a[@class = 'a_logout']");
    private final By btn_goToLogIn = By.xpath(".//div[@class = 'auth-wrap']/a[@class = 'login_btn']");     // Кнопка доступна после выхода из УЗ



    /*
                Блок методов
                                               */

    // Тест №1 Регистрация и авторизация e2e
    // MainPageSI > LoginPage > SignUpPage > MainPageSI > ===ProfilePage===
    public boolean t1_checkUsername () {
        return driver.findElement(username).getText().contains(EXPECTED_USERNAME);
    }


    // Тест №2 Авторизация
    // MainPageSI > LoginPage  > MainPageSI > ===ProfilePage===
    public boolean t2_checkUsername () {
        return driver.findElement(username).getText().contains(t2_smoke_username);
    }

    // Тест №3 Разлогин
    // MainPageSI > LoginPage  > MainPageSI > ===ProfilePage=== > LoginPage
    public LoginPage logOut() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(btn_profileMenu));
        } catch (Exception e) {
            System.out.println(PURPLE + " Не была найдена кнопка открывания меню профиля!" +RESET);
        }

        driver.findElement(btn_profileMenu).click();
        System.out.println(YELLOW + "Разлогиниваюсь!" +RESET);
        driver.findElement(btn_logOut).click();

        // Разлогинились, теперь ищем подтверждение этому
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(btn_goToLogIn));
        } catch (Exception e) {
            System.out.println(PURPLE + " Не была найдена кнопка для перехода на страницу Логина - РАЗЛОГИН НЕ ПРОШЕЛ!" +RESET);
        }

        System.out.println(YELLOW + "Перехожу на страницу Log In" +RESET);
        driver.findElement(btn_goToLogIn).click();
        return new LoginPage(driver);
    }





}
