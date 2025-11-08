package PageObjects.LoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    // Для ассерта - проверка на то, что профиль появился после регистрации


    // Инпуты
    private final By input_email = By.id("si-mail");
    private final By input_password = By.id("si-passwd");
    private final By input_searchProgram = By.id("search_inp");

    // Кнопочки
    private final By btn_goToSignUp = By.xpath("/html/body/div[1]/div[1]/div/form/div[@class = 'wrap_form']/div[@class = 'sign-up__wrapper']/a");
    private final By btn_login = By.id("login");
    private final By btn_forgotPassword = By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div[3]/fieldset/div[3]/div[@class = 'login-input-wrap']/div[@class = 'input-pre clearfix']/span[@class = 'forgot']");
    private final By btn_showPassword = By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div[3]/fieldset/div[2]/div/div/span[@class = 'password-eye hide']");






            /*
                          Блок методов
                                                 */


    // Тест №1 Регистрация (продолжение - корень в MainPAgeSI)
    // MainPageSI > LoginPage  >

    public SignUpPage registrationAccount() {
        try {
            // Сначала дождусь открытия страницы для этого сверюсь с локатором
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean isCorrect = wait.until(ExpectedConditions.textToBe(assert_LogInHeader, "Log in"));
            if (isCorrect) {
                // Тест пройдет дальше если проверка была успешной
                driver.findElement(btn_goToSignUp);
            }
            return new SignUpPage(driver);
            // Или выброшу сообщение, что страница не та
        } catch (Exception e) {
            driver.findElement(assert_LogInHeader).getText();
            throw new RuntimeException("Держи хеддер страницы которая открыта: " + assert_LogInHeader.toString());
        }
    }




}
