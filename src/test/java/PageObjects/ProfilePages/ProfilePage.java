package PageObjects.ProfilePages;

import org.openqa.selenium.WebDriver;
import PageObjects.LoginPages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Expected.SmokeTests.t1_registrationAccount.EXPECTED_USERNAME;

public class ProfilePage {


    private final WebDriver driver;
    public ProfilePage(WebDriver driver) { this.driver = driver; }


            /*
                  Блок локаторов
                                      */

    private final By username = By.xpath("/html/body/div[2]/div/div[1]/div[2]/h1");






            /*
                Блок методов
                                     */

    public boolean checkUsername () {
        return driver.findElement(username).getText().contains(EXPECTED_USERNAME);
    }






}
