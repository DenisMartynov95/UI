package Parametrized.SmokeTests.t7_smoke_availability_of_categories;

import Expected.SmokeTests.asserts_t7_ExpectedListOfCategories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static Other.ColorfulConsole.*;

public class ListOfCategories {

    asserts_t7_ExpectedListOfCategories expectedList = new asserts_t7_ExpectedListOfCategories();

    private final WebDriver driver;
    public ListOfCategories(WebDriver driver) {
        this.driver = driver;
    }


    // Логика получения локалей представленных на странице SI
    // #1 Для начала создаю лист, в который затем буду загружать локаторы
    private final List<By> listOfCategories = new ArrayList<>();
    // #2 Теперь создаю метод для загрузки в лист - локаторов со страницы
    // Чтобы не писать каждый локатор отдельно - сделаю цикл, так как лист индексируется цифрами //li[1]
    public List<By> getListOfCategories() {
        for (int i = 0; i != 16; i++) {
            listOfCategories.add(By.xpath(".//div[1]/aside//ul/li[" + (i+1) + "]"));
        }
        System.out.println("Создан лист локаторов для категорий" + listOfCategories);
        return listOfCategories;
    }

    // #3 Далее логика сопоставления ожидаемого и фактического
    public void checkListOfCategories() {
        for (int i = 0; i < expectedList.getAsserts_listOfCategories().size(); i++ ) {
            // #4 Закладываю актуалочку и ожидаемый в разные переменные
            String actual = driver.findElement(listOfCategories.get(i)).getText();
            String expected = expectedList.getAsserts_listOfCategories().get(i);

            if (actual.equals(expected)){
                System.out.println(YELLOW + "Актуальный: " + actual + " совпадает с Ожидаемым: " + expected + RESET);
            } else {
                System.out.println(PURPLE + "Актуальный: " + actual + " НЕ РАВЕН с Ожидаемым: " + expected + RESET);
                break;
            }
        }
    }




}
