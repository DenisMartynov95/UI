package PageObjects.SI;

import PageObjects.LoginPages.LoginPage;
import PageObjects.ProfilePages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static DataGeneration.SmokeTests.t1_RegistrationAccount.*;
import static Other.ColorfulConsole.*;

public class MainPageSI {

    private final WebDriver driver;
    public MainPageSI(WebDriver driver) { this.driver = driver; }

    public final String si_mainPage = "https://software.informer.com/";


        /*
                  Блок локаторов
                                      */

    private final By profileUsername = By.xpath("/html/body/header/div[1]/div/div[4]/div[3]/div/div/a[@class = 'user_name']");


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

}
