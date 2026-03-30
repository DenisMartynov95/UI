package Parametrized.SmokeTests.t6_smoke_availability_of_locales;

import Expected.SmokeTests.asserts_t6_ExpectedListOfLocales;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static Other.ColorfulConsole.*;

public class ListsOfLocales {
    asserts_t6_ExpectedListOfLocales expectedList = new asserts_t6_ExpectedListOfLocales();

    private final WebDriver driver;

    public ListsOfLocales(WebDriver driver) {
        this.driver = driver;
    }

    // Логика получения локалей на странице SI
    private final List<By> listOfLocales = new ArrayList<>();
    // Так как у локаторов меняется всего лишь цифра, от 1 до 28 - делаю цикл, который заполняет массив локаторов
    public List<By> getListOfLocales() {
        for (int i = 0; i != 28; i++) {
            listOfLocales.add(By.xpath("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[" + (i+1) +"]"));
        }
        System.out.println("Сформирован список локаторов локализаций: " + listOfLocales);
        return listOfLocales;
    }

    //Метод для сопоставления локатора и ассерта
    public void checkListOfLocales() {

        for (int i = 0; i != 28; i++) {
            By locator = listOfLocales.get(i);
            String actual = driver.findElement(locator).getText(); //Беру локаторы которые в методе выше и впихиваю значение в actual

            String expected = expectedList.getAsserts_listOfLocales().get(i); //Беру локаторы из ассертового класса и вычленяю их текст
            if (actual.equals(expected)) {
                System.out.println(YELLOW + "Актуальный: " + actual + " совпадает с Ожидаемым: " + expected + RESET);
            } else {
                System.out.println(PURPLE + "Актуальный: " + actual + " НЕ РАВЕН с Ожидаемым: " + expected + RESET);

            }


        }
    }




}
