package TestsData;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class t6_listsOfLocales {

    // Лист ассертов для проверки доступности кнопок локализаций (№6 смоук-кейс)
    private final List<String> listOfLocales = new ArrayList<>();
    public List<By.ByXPath> getListOfLocales() {
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[1]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[2]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[3]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[4]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[5]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[6]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[7]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[8]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[9]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[10]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[11]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[12]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[13]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[14]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[15]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[16]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[17]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[18]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[19]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[20]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[22]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[23]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[24]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[25]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[26]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[27]");
        listOfLocales.add("//div[@class='right']//div[@class='lang_dropdown lang_dropdown2']/a[28]");
        return listOfLocales;
    }
}
