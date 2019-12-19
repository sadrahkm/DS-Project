import java.util.*;

public class BankAccount extends Node {
    String ownerAccount;
    String Bank;
    String ShebaNum;
    String AccountNum;
    String key = ownerAccount;
    static CSVReader test = new CSVReader();
    static ArrayList<String[]> data = test.get("C:\\Users\\Sadra Hakim\\Desktop\\data\\accounts.csv");

    public static void showData(){
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                System.out.print(data.get(i)[j] + ",");
            }
            System.out.println();
        }
    }
}
