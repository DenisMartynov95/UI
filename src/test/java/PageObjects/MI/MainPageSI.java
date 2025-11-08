package PageObjects.MI;

import PageObjects.LoginPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageSI {

    private final WebDriver driver;
    public MainPageSI(WebDriver driver) { this.driver = driver; }

    public final String si_mainPage = "https://software.informer.com/";


        /*
                  Блок локаторов
                                      */

    // Для ассерта проверки открывшейся страницы
    private  final By assert_MainSIHeader = By.xpath("/html/body/div[1]/div/div[3]/div[1]/h1");


    // Кнопочки
    private final By btn_goToLogInPage = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/a");


        /*
                Блок методов
                                     */

    // Тест №1 Регистрация (продолжение - корень в MainPAgeSI)
    // MainPageSI > LoginPage > SignUpPage > MainPageSI
    public LoginPage registrationAccount() {
        try {
            driver.findElement(btn_goToLogInPage).click();
            return new LoginPage(driver);

        } catch (Exception e) {
            driver.findElement(assert_MainSIHeader).getText();
            throw new RuntimeException("Ошибка при создании аккаунта", e);
        }
    }






}
