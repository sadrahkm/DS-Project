import java.util.*;

public class Telephone extends Node {
    String personCode;
    String number;
    String operator;
    String key = number;
    static CSVReader test = new CSVReader();
    static ArrayList<String[]> data = test.get("C:\\Users\\Sadra Hakim\\Desktop\\data\\phones.csv");
    public static void showData(){
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                System.out.print(data.get(i)[j] + ",");
            }
            System.out.println();
        }
    }
}
