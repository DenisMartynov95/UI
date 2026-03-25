package Parametrized;

import Expected.SmokeTests.asserts_t6_ExpectedListOfLocales;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class t6_listsOfLocales {

    // Лист локалей для переключения (№6 смоук-кейс)
    private final List<By> listOfLocales = new ArrayList<>();
    // Так как у локаторов меняется всего лишь цифра, от 1 до 28 - делаю цикл
    public List<By> getListOfLocales() {
        for (int i = 1; i < 28; i++) {
            listOfLocales.add(By.xpath("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[" + i +"]"));
        }

        listOfLocales.add(By.xpath("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[1]"));
        return listOfLocales;
    }

    //Метод для сопоставления локатора и ассерта (№6 смоук-кейс)
    public checkListOfLocales() {
        for (int i = 0; i < 28; i++) {
            String actual = listOfLocales.get(i).toString();
            String expected = asserts_t6_ExpectedListOfLocales.asserts_listOfLocales.get(i).toString();


        }
    }


}
