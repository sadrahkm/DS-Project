import java.util.*;

public class House extends Node {
    String personCode;
    String price;
    String codePosti;
    String metraj;
    String address;
    String key = codePosti;
    static CSVReader test = new CSVReader();
    static ArrayList<String[]> data = test.get("C:\\Users\\Sadra Hakim\\Desktop\\data\\homes.csv");
    public static void showData(){
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                System.out.print(data.get(i)[j] + ",");
            }
            System.out.println();
        }
    }
}
