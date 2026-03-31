package Parametrized.SmokeTests.t9_smoke_availability_of_mustHaveProgSI;

import Expected.SmokeTests.asserts_t9_ExpectedListOfADVProgSI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ListOfADVProgSI {
    private final WebDriver driver;
    public ListOfADVProgSI(WebDriver driver) {
        this.driver = driver;
    }

    asserts_t9_ExpectedListOfADVProgSI expected_lists = new asserts_t9_ExpectedListOfADVProgSI();
    public static boolean listOfADV_isEquals = true;

    private final List<By> ListOfMustHaveProgSI = new ArrayList<>();
    public List<By> getListOfMustHaveProgSI() {
        ListOfMustHaveProgSI.add(By.xpath("//div[2]/a[@title = 'Download 7-Zip']"));
        ListOfMustHaveProgSI.add(By.xpath("//div[2]/div[2]/a[@title = 'Download Free Download Manager']"));
        ListOfMustHaveProgSI.add(By.xpath("//div[3]/div[2]/a[@title = 'Download Slack']"));
        ListOfMustHaveProgSI.add(By.xpath("//div[4]/div[2]/a[@title = 'Download TeamViewer']"));
        return ListOfMustHaveProgSI;
    }

    private final List<By> ListOfAntiVirusProgSI = new ArrayList<>();
    public List<By> getListOfAntiVirusProgSI() {
        ListOfMustHaveProgSI.add(By.xpath("//div[2]/div[1]/div[2]/div[1]/a[@title = 'Download Avast Free Antivirus']"));
        ListOfMustHaveProgSI.add(By.xpath("//div[2]/div[1]/div[2]/div[1]/a[@title = 'Download Toolwiz Time Freeze']"));
        ListOfMustHaveProgSI.add(By.xpath("//div[2]/div[1]/a[@title='Download Kerio Control']"));
        return ListOfAntiVirusProgSI;
    }





}
