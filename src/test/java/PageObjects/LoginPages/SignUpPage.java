package PageObjects.LoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private final WebDriver driver;
    public SignUpPage(WebDriver driver) { this.driver = driver; }



        /*
                   Блок локаторов
                                          */

    // Для ассерта проверки открывшейся страницы
    private  final By assert_SignUpHeader = By.xpath("/html/body/div[1]/div[2]/h2");

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





}
