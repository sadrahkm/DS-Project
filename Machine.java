import java.util.*;

public class Machine extends Node {
    String pelak;
    String personCode;
    String color;
    String model;
    String key;
    static Dictionary<String, Machine> dict = new Hashtable<>();

    Machine(String pelak, String personCode, String model, String color) {
        this.pelak = pelak;
        this.personCode = personCode;
        this.color = color;
        this.model = model;
        this.key = pelak;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put(data.get(i)[0], new Machine(data.get(i)[0], data.get(i)[1], data.get(i)[2], data.get(i)[3]));
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}
