package PageObjects.LoginPages;

import PageObjects.SI.MainPageSI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DataGeneration.SmokeTests.t1_RegistrationAccount.*;

public class SignUpPage {
    private final WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }




        /*
                   Блок локаторов
                                          */

    // Для ассерта проверки открывшейся страницы
    private final By assert_SignUpHeader = By.xpath("/html/body/div[1]/div[2]/h2");
    // Для ассерта, при открытии формы авторизации - анимация лоадера, надо дождаться display : none
    private final By assert_loaderAnimation = By.xpath("/html/body/div[1]/div[1]/img");

    // Инпуты
    private final By input_username = By.xpath("/html/body/div[1]/div[2]/form/div[2]/fieldset/div[1]/div/div[@class = 'input-pre input-name']/input");
    private final By input_email = By.id("MailReg");
    private final By input_password = By.id("si-passwd2");
    private final By input_searchProgram = By.id("search_inp");

    // Кнопочки
    private final By btn_goToLogin = By.xpath("/html/body/div[1]/div[2]/div[@class = 'log-in__wrapper']/a");
    private final By btn_signUp = By.id("login3");
    private final By btn_acceptCapcha = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]");
    private final By btn_showPassword = By.xpath(".//div[2]/fieldset/div[3]/div/div/span[@class = 'password-eye hide']");






            /*
                         Блок методов
                                                 */

    // Тест №1 Регистрация (продолжение - корень в MainPAgeSI)
    // MainPageSI > LoginPage > SignUpPage >

    public MainPageSI registrationAccount() {
        System.out.println("Сгенерирован username: " + username_generation);
        driver.findElement(input_username).sendKeys(username_generation);

        System.out.println("Сгенерирован email: " + username_generation);
        driver.findElement(input_email).sendKeys(email_generation);

        System.out.println("Сгенерирован password: " + username_generation);
        driver.findElement(input_password).sendKeys(password_generation);

        // Пытаемся найти капчу
        WebDriverWait waitCapcha = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            waitCapcha.until(ExpectedConditions.elementToBeClickable(btn_acceptCapcha));
            driver.findElement(btn_acceptCapcha).click();
        } catch (Exception ignored) {
            System.out.println("Капча не появилась — продолжаем регистрацию без неё");
        }

        // Ждём кнопку SignUp
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_signUp));
        driver.findElement(btn_signUp).click();

        return new MainPageSI(driver);


    }
}
