package PageObjects.LoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }



        /*
            Блок локаторов
                                     */


    // Для ассертов
    private  final  By assert_LogInHeader = By.xpath("/html/body/div[1]/div[1]/div/h1");

    // Инпуты
    private final By input_email = By.id("si-mail");
    private final By input_password = By.id("si-passwd");
    private final By input_searchProgram = By.id("search_inp");

    // Кнопочки
    private final By btn_goToSignUp = By.xpath("/html/body/div[1]/div[1]/div/form/div[@class = 'wrap_form']/div[@class = 'sign-up__wrapper']/a");
    private final By btn_login = By.id("login");
    private final By btn_forgotPassword = By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div[3]/fieldset/div[3]/div[@class = 'login-input-wrap']/div[@class = 'input-pre clearfix']/span[@class = 'forgot']");
    private final By btn_showPassword = By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div[3]/fieldset/div[2]/div/div/span[@class = 'password-eye hide']");







}
