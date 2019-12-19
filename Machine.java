import java.util.*;

public class Machine extends Node {
    String pelak;
    String personCode;
    String color;
    String model;
    String key = pelak;
    static CSVReader test = new CSVReader();
    static ArrayList<String[]> data = test.get("C:\\Users\\Sadra Hakim\\Desktop\\data\\cars.csv");

    public static void showData(){
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                System.out.print(data.get(i)[j] + ",");
            }
            System.out.println();
        }
    }
}
