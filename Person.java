import java.util.*;

public class Person extends Node {
    String key;
    String name;
    String lastName;
    String birthDate;
    String birthPlace;
    String workPlace;
    static CSVReader test = new CSVReader();
    static ArrayList<String[]> data = test.get("C:\\Users\\Sadra Hakim\\Desktop\\data\\people.csv");

    public static void showData(){
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                System.out.print(data.get(i)[j] + ",");
            }
            System.out.println();
        }
    }
}
