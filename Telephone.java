import java.util.*;

public class Telephone extends Node {
    String personCode;
    String number;
    String operator;
    String key;
    static CSVReader test = new CSVReader();
    static Dictionary<String, Telephone> dict = new Hashtable<>();

    Telephone(String personCode, String number, String operator) {
        this.personCode = personCode;
        this.number = number;
        this.operator = operator;
        this.key = number;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put(data.get(i)[0], new Telephone(data.get(i)[0], data.get(i)[1], data.get(i)[2]));
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            Telephone temp = (Telephone) e.nextElement();
            System.out.println(temp.personCode +" , "+temp.number +" , "+temp.operator  );
        }
    }
}
