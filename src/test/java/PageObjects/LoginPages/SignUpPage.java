package PageObjects.LoginPages;

import PageObjects.SI.MainPageSI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private final WebDriver driver;
    public SignUpPage(WebDriver driver) { this.driver = driver; }




        /*
                   Блок локаторов
                                          */

    // Для ассерта проверки открывшейся страницы
    private  final By assert_SignUpHeader = By.xpath("/html/body/div[1]/div[2]/h2");
    // Для ассерта, при открытии формы авторизации - анимация лоадера, надо дождаться display : none
    private final By assert_loaderAnimation = By.xpath("/html/body/div[1]/div[1]/img");

    // Инпуты
    private final By input_username = By.id("/html/body/div[1]/div[2]/form/div[2]/fieldset/div[1]/div/div[@class = 'input-pre input-name']/input");
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
        // Сначала дождусь открытия страницы для этого сверюсь с локатором
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(input_username));
        // Тест пройдет дальше если проверка была успешной
        driver.findElement(input_username).sendKeys("test");
        driver.findElement(input_email).sendKeys("test@mail.ru");
        driver.findElement(input_password).sendKeys("Usad123");
        driver.findElement(btn_acceptCapcha);
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(btn_signUp));
        driver.findElement(btn_signUp);
        return new MainPageSI(driver);

    }


}
