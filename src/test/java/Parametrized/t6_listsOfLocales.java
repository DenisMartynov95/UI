package Parametrized;

import Expected.SmokeTests.asserts_t6_ExpectedListOfLocales;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Other.ColorfulConsole.*;

public class t6_listsOfLocales {
    asserts_t6_ExpectedListOfLocales expectedList = new asserts_t6_ExpectedListOfLocales();

    private final WebDriver driver;

    // Лист локалей для переключения (№6 смоук-кейс)
    private final List<By> listOfLocales = new ArrayList<>();

    public t6_listsOfLocales(WebDriver driver) {
        this.driver = driver;
    }

    // Так как у локаторов меняется всего лишь цифра, от 1 до 28 - делаю цикл
    public List<By> getListOfLocales() {
        for (int i = 0; i <= 27; i++) {
            listOfLocales.add(By.xpath("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[" + i +"]"));
        }
        return listOfLocales;
    }

    //Метод для сопоставления локатора и ассерта (№6 смоук-кейс)
    public void checkListOfLocales() {

        for (int i = 0; i <= 27; i++) {
            By locator = listOfLocales.get(i);
            String actual = driver.findElement(locator).getText();

            String expected = expectedList.getAsserts_listOfLocales().get(i);
            if (actual.equals(expected)) {
                System.out.println(YELLOW + "Актуальный: " + actual + " совпадает с Ожидаемым: " + expected + RESET);
            } else {
                System.out.println(PURPLE + "Актуальный: " + actual + " НЕ РАВЕН с Ожидаемым: " + expected + RESET);

            }


        }
    }


}
