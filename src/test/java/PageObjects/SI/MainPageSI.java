package PageObjects.SI;

import PageObjects.LoginPages.LoginPage;
import PageObjects.MI.MainPageMI;
import PageObjects.ProfilePages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DataGeneration.SmokeTests.t1_RegistrationAccount.*;
import static Other.ColorfulConsole.*;

public class MainPageSI {

    private final WebDriver driver;
    public MainPageSI(WebDriver driver) { this.driver = driver; }

    public final String si_URL = "https://software.informer.com/";

    /*
          Блок для хранения состояний
                                        */
    // Для теста №2 Авторизация - хранится состояние username
    // MainPageSI >>> ProfilePage
    public static String t2_smoke_username;



        /*
                  Блок локаторов
                                      */

    private final By profileUsername = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/div/div/a[@class = 'user_name']");


    // Кнопочки
    private final By btn_goToLogInPage = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/a");
    private final By btn_openProfileMenu = By.xpath(".//div[1]/div/div[4]/div[3]/div/a[1]/img");
    private final By btn_openMIPage = By.xpath(".//aside/div[@class = 'rotation_block desc']/div/a[@class = 'navigation__item']");


        /*
                Блок методов
                                     */
    // Тест №1 Регистрация и авторизация e2e
    // ===MainPageSI=== > LoginPage > SignUpPage > MainPageSI > ProfilePage
    public LoginPage registrationAccount() {
        driver.get(si_URL);
        driver.findElement(btn_goToLogInPage).click();
        return new LoginPage(driver);
    }

    // Тест №1 Регистрация и авторизация e2e
    // MainPageSI > LoginPage > SignUpPage > ===MainPageSI=== > ProfilePage
    public ProfilePage checkAccount() {
        driver.findElement(btn_openProfileMenu).click();

        try {
            String result = driver.findElement(profileUsername).getText();
            if (result.equals(username_generation)) {
                System.out.println(YELLOW + "Промежуточный Ожидаемый результат ВЫПОЛНЕН!" + RESET);
                System.out.println(YELLOW + "Введенный username: " + RESET + BLUE + username_generation + RESET + " найденный username: " + RESET + BLUE + result + RESET);
            }

        } catch (Exception e) {
            System.out.println(RED +"Промежуточный ожидаемый результат ПРОВАЛИЛСЯ!" + RESET);
        }

        // Далее прохожу по тесту на новую страницу
        driver.findElement(btn_openProfileMenu).click();
        return new  ProfilePage(driver);
    }


    // Тест №2 Авторизация
    // Имеется тестовый аккаунт >>> email - martynov.averyan@yandex.ru = password - Qwerty!1
    // ===MainPageSI=== > LoginPage  > MainPageSI > ProfilePage
    // Тест №3 Разлогин
    // ===MainPageSI=== > LoginPage  > MainPageSI > ProfilePage > MainPage
    public LoginPage goToLoginPage() {
        driver.get(si_URL);
        driver.findElement(btn_goToLogInPage).click();
        return new LoginPage(driver);
    }

    // Тест №2 Авторизация
    // MainPageSI > LoginPage  > ===MainPageSI=== > ProfilePage
    // Тест №3 Разлогин
    // MainPageSI > LoginPage  > ===MainPageSI=== > ProfilePage > MainPage
    public ProfilePage checkAuthorization() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(btn_openProfileMenu));

            driver.findElement(btn_openProfileMenu).click();
            t2_smoke_username = driver.findElement(profileUsername).getText();
            System.out.println("Найдено username: " + BLUE + t2_smoke_username + RESET + " занесено в переменную t2_smoke_username");
            if (t2_smoke_username != null) {
                System.out.println(YELLOW + "Перехожу в профиль для окончательной сверки  Username " + RESET);
                driver.findElement(profileUsername).click();
            }
        } catch (Exception e) {
            System.out.println(PURPLE + "Тест упал, либо не была открыта страница, либо не найден username" + RESET);
        }
        return new ProfilePage(driver);
    }

    // Тест №4 Проверка переключения между главными страницами
    // Имеется возможность перейти между страницами двумя способами - кнопками в рабочем поле страницы и кнопками из шапки страницы
    // Вначале проверяю кнопки в рабочем поле > потом в шапке
    // ===MainPageSI=== > MainPageMI  > MainPageSI
    public MainPageMI goToMIPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(btn_openMIPage));

        } catch (Exception e) {
            System.out.println(PURPLE + "Тест упал, кнопка не найдена" + RESET);
        }
        driver.findElement(btn_openMIPage).click();
        return new MainPageMI(driver);
    }


}
