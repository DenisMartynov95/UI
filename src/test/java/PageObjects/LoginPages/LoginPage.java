package PageObjects.LoginPages;

import PageObjects.SI.MainPageSI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Other.ColorfulConsole.*;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }




        /*
            Блок локаторов
                                     */


    // Для ассерта проверки открывшейся страницы
    private final By assert_LogInHeader = By.xpath("/html/body/div[1]/div[1]/div/h1");
    // Для ассерта, при открытии формы авторизации - анимация лоадера, надо дождаться display : none
    private final By assert_loaderAnimation = By.xpath("/html/body/div[1]/div[1]/img");



    // Инпуты
    private final By input_email = By.id("si-mail");
    private final By input_password = By.id("si-passwd");
    private final By input_searchProgram = By.id("search_inp");

    // Кнопочки
    private final By btn_goToSignUp = By.xpath(".//div/form/div[@class = 'wrap_form']/div[@class = 'sign-up__wrapper']/a");
    private final By btn_login = By.id("login");
    private final By btn_forgotPassword = By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div[3]/fieldset/div[3]/div[@class = 'login-input-wrap']/div[@class = 'input-pre clearfix']/span[@class = 'forgot']");
    private final By btn_showPassword = By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div[3]/fieldset/div[2]/div/div/span[@class = 'password-eye hide']");






            /*
                          Блок методов
                                                 */


    // Тест №1 Регистрация (продолжение - корень в MainPAgeSI)
    // MainPageSI > LoginPage  > SignUpPage

    public SignUpPage registrationAccount() {
        // Сначала дождусь открытия страницы для этого сверюсь с локатором
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_goToSignUp));
        // Тест пройдет дальше если проверка была успешной
        driver.findElement(btn_goToSignUp).click();
        return new SignUpPage(driver);
        }


    // Тест №2 Авторизация (продолжение - корень в MainPAgeSI)
    // MainPageSI > LoginPage  > MainPAgeSI
    public MainPageSI authorization() {
        try {
            driver.findElement(input_email).sendKeys("martynov.averyan@yandex.ru");
            System.out.println("Введен почтовый адрес: " + BLUE + " martynov.averyan@yandex.ru" + RESET);

            driver.findElement(input_password).sendKeys("Qwerty!1");
            System.out.println("Введен пароль: " + BLUE + " Qwerty!1" + RESET);

        } catch (Exception e) {
            System.out.println(PURPLE + "Страница не была открыта!" + RESET);
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(btn_login));
        driver.findElement(btn_login).click();
        return new MainPageSI(driver);
    }
}
