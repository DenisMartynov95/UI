package PageObjects.SI;

import PageObjects.LoginPages.LoginPage;
import PageObjects.ProfilePages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageSI {

    private final WebDriver driver;
    public MainPageSI(WebDriver driver) { this.driver = driver; }

    public final String si_mainPage = "https://software.informer.com/";


        /*
                  Блок локаторов
                                      */

    // Кнопочки
    private final By btn_goToLogInPage = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/a");
    private final By btn_openProfileMenu = By.xpath(".//div[1]/div/div[4]/div[3]/div/a[1]/img");

        /*
                Блок методов
                                     */

    // Тест №1 Регистрация (продолжение - корень в MainPAgeSI)
    // MainPageSI > LoginPage > SignUpPage > MainPageSI
    public LoginPage registrationAccount() {
        driver.get(si_mainPage);
        driver.findElement(btn_goToLogInPage).click();
        return new LoginPage(driver);
    }

    public ProfilePage checkAccount() {
        driver.findElement(btn_openProfileMenu).click();

    }

}
