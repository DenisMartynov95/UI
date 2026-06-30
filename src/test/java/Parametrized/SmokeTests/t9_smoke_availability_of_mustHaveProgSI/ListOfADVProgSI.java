package Parametrized.SmokeTests.t9_smoke_availability_of_mustHaveProgSI;

import Expected.SmokeTests.asserts_t9_ExpectedListOfADVProgSI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.yaml.snakeyaml.error.YAMLException;

import java.util.ArrayList;
import java.util.List;

import static Other.ColorfulConsole.*;

public class ListOfADVProgSI {
    private final WebDriver driver;
    public ListOfADVProgSI(WebDriver driver) {
        this.driver = driver;
    }


    asserts_t9_ExpectedListOfADVProgSI expected_lists = new asserts_t9_ExpectedListOfADVProgSI();
    public static boolean listOfADV_isEquals = true;
    private final List<String > ListOfMustHaveProgSI = new ArrayList<>();


                    /*
                              Блок методов
                                                  */

    // Метод для автоматического заполнения листа представленными программами, чтобы вручную не делать
    public List<String> fillListOfMustHaveProgSI() {
        for (int i = 1; i != 4; i++) {
            ListOfMustHaveProgSI.add(".//div[1]/div[@class = 'more-apps__container']/div[" + (i) + "]//div[@class = 'more-apps__description']/");
        }
        System.out.println(YELLOW + "Создан список программ в блоке Маст Хэв:" + ListOfMustHaveProgSI.size() + RESET);
        System.out.print(ListOfMustHaveProgSI);
        return  ListOfMustHaveProgSI;
    }


    public void checkListOfMustHave() {
        for (int i = 1; i < ListOfMustHaveProgSI.size(); i++) {
            String actual = String.valueOf(driver.findElement(By.id(ListOfMustHaveProgSI.get(i))));
            String expected = expected_lists.getListOfMustHaveProgSI().get(i);

            if (actual.contains(expected)) {
                System.out.println(YELLOW + "Ожидаемый: " + expected + " совпал с фактическим " + actual + RESET);

            } else {
                listOfADV_isEquals = false;
                System.out.println(RED + "Ожидаемый результат: " + expected + "  не совпал с фактическим: " + actual + RESET);
            }
        }

    }

}
