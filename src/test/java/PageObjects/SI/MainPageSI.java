package PageObjects.SI;

import Expected.SmokeTests.asserts_t4_checkMainPageSwitch;
import PageObjects.LoginPages.LoginPage;
import PageObjects.MI.MainPageMI;
import PageObjects.ProfilePages.ProfilePage;
import Parametrized.SmokeTests.t6_smoke_availability_of_locales.ListsOfLocales;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DataGeneration.SmokeTests.t1_RegistrationAccount.*;
import static Other.ColorfulConsole.*;

public class MainPageSI {

    private WebDriver driver;

    public MainPageSI(WebDriver driver) {
        this.driver = driver;
    }


    /*
        Блок общих настроек для страницы Main Page SI
                                                             */
    public final String si_URL = "https://software.informer.com/";     // Страница для mainPage Software Informer

    private Wait<WebDriver> webDriverWait() {  // Общую настройку для ожидания вывел в метод, чтобы в каждом методе не определять ожидание
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    /*
          Блок для хранения состояний
                                        */
    // Для теста №2 Авторизация - хранится состояние username
    // MainPageSI >>> ProfilePage
    public static String t2_smoke_username;


    /*
                  Блок ассертов
                                           */
    // Для ассерта проверки открывшейся страницы
    private final By assert_SIPage = By.xpath("/html/body/header/div[1]/div/a/img");

    // Для ассерта проверка какой баннер был открыт (баннер №1) отталкиваюсь от радиокнопки, которая показывает какой баннер включен
    // Параметр bullet-active проставляется у обеих кнопок, надо дополнительно смотреть на aria-label
    private final By assert_firstSI_banner = By.xpath("//span[@class='swiper-pagination-bullet swiper-pagination-bullet-active' and @aria-label='Go to slide 1']");
    // Для ассерта проверка какой баннер был открыт (баннер №2) отталкиваюсь от радиокнопки, которая показывает какой баннер включен
    // Параметр bullet-active проставляется у обеих кнопок, надо дополнительно смотреть на aria-label
    private final By assert_secondSI_banner = By.xpath("//span[@class='swiper-pagination-bullet swiper-pagination-bullet-active' and @aria-label='Go to slide 2']");

    /*
                  Блок локаторов
                                              */


    private final By profileUsername = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/div/div/a[@class = 'user_name']");


    // Кнопочки
    private final By btn_goToLogInPage = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/a");
    private final By btn_openProfileMenu = By.xpath(".//div[1]/div/div[4]/div[3]/div/a[1]/img");
    private final By btn_openMIPage = By.xpath(".//aside/div[@class = 'rotation_block desc']/div/a[@class = 'navigation__item']");
    private final By btn_firstBanner = By.xpath("//span[@class='swiper-pagination-bullet' and @aria-label='Go to slide 1']");
    private final By btn_secondBanner = By.xpath("//span[@class='swiper-pagination-bullet' and @aria-label='Go to slide 2']");
    private final By btn_openListOfLocales = By.xpath("//div/div[@class='right']/div[@class='wrapper_lang wrapper_langs']");


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
            System.out.println(RED + "Промежуточный ожидаемый результат ПРОВАЛИЛСЯ!" + RESET);
        }

        // Далее прохожу по тесту на новую страницу
        driver.findElement(btn_openProfileMenu).click();
        return new ProfilePage(driver);
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
    // Вначале проверяю кнопки в рабочем поле
    // ===MainPageSI=== > MainPageMI  > MainPageSI
    public MainPageMI goToMIPage() {
        try {
            driver.get(si_URL);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(btn_openMIPage));

        } catch (Exception e) {
            System.out.println(PURPLE + "Тест упал, кнопка не найдена" + RESET);
        }
        driver.findElement(btn_openMIPage).click();
        return new MainPageMI(driver);
    }


    // Тест №4 Проверка переключения между главными страницами
    // MainPageSI > MainPageMI  > ===MainPageSI===
    public boolean checkSiPageIsOpen() {
        return driver.findElement(assert_SIPage).getAttribute("alt").contains(asserts_t4_checkMainPageSwitch.EXPECTED_SI_PAGE_NAME);
    }

    // Тест №5 Работа кнопок по смене баннеров на страницах Win | MAC
    // ===MainPageSI=== > MainPageMI
    public MainPageMI checkSIBanners() {
        try {
            driver.get(si_URL);
            webDriverWait().until(ExpectedConditions.elementToBeClickable(btn_secondBanner));
        } catch (Exception e) {
            System.out.println(PURPLE + "Тест упал, кнопка баннера не найдена" + RESET);
        }

        driver.findElement(btn_secondBanner).click();
        if (driver.findElement(assert_secondSI_banner).isDisplayed()) {
            System.out.println(YELLOW + "Баннер переключился на №2 " + RESET);
        } else {
            System.out.println(PURPLE + "Тест упал, баннер не был переключен на №2" + RESET);
        }
        driver.findElement(btn_firstBanner).click();
        if (driver.findElement(assert_firstSI_banner).isDisplayed()) {
            System.out.println(YELLOW + "Баннер переключился на №1 " + RESET);
            driver.findElement(btn_openMIPage).click();
            System.out.println(WHITE + "Перехожу на страницу MI для продолжения " + RESET);

        } else {
            System.out.println(PURPLE + "Тест упал, баннер не был переключен на №1" + RESET);
        }
        return new MainPageMI(driver);
    }

    // Тест №6 Доступность локалей для SI страницы
    // ===MainPageSI=== > MainPageMI
    public MainPageMI checkListOfLocales() {
        driver.get(si_URL);
        try {
            ListsOfLocales methods = new ListsOfLocales(driver); // Имплементирую внутренние методы класса, который содержит логику параметризированного теста

            driver.findElement(btn_openListOfLocales).click();
            methods.getListOfLocales();
            methods.checkListOfLocales();

            System.out.println(GREEN + "Перехожу на страницу MI" + RESET);
            driver.findElement(btn_openMIPage).click();
            // На странице MI не должно быть возможности сменить локаль! Поэтому
            if (driver.findElement(btn_openListOfLocales).isDisplayed()) {
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new MainPageMI(driver);
    }


    // Тест №6 Доступность категорий для SI страницы
    // ===MainPageSI===
    public MainPageSI checkListOfCategories() {
        driver.get(si_URL);
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
