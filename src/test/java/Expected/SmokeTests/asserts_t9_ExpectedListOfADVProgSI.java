package Expected.SmokeTests;

import java.util.ArrayList;
import java.util.List;

public class asserts_t9_ExpectedListOfADVProgSI {

    private final List<String> ListOfMustHaveProgSI = new ArrayList<>();

    public List<String> getListOfMustHaveProgSI() {
        ListOfMustHaveProgSI.add("7-Zip");
        ListOfMustHaveProgSI.add("Free Download Manage");
        ListOfMustHaveProgSI.add("Slack");
        ListOfMustHaveProgSI.add("TeamViewer");
        return ListOfMustHaveProgSI;
    }


    private final List<String> ListOfAntiVirusProgSI = new ArrayList<>();

    public List<String> getListOfAntiVirusProgSI() {
        ListOfMustHaveProgSI.add("Avast Free Antivirus");
        ListOfMustHaveProgSI.add("Toolwiz Time Freeze");
        ListOfMustHaveProgSI.add("Kerio Control");
        return ListOfAntiVirusProgSI;
    }


}
