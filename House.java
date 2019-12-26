import java.util.*;

public class House extends Node {
    String personCode;
    String price;
    String codePosti;
    String metraj;
    String address;
    String key = codePosti;
    static Dictionary<String, House> dict = new Hashtable<>();

    House(String personCode, String price, String codePosti, String metraj, String address) {
        this.personCode = personCode;
        this.price = price;
        this.codePosti = codePosti;
        this.metraj = metraj;
        this.address = address;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put(data.get(i)[2], new House(data.get(i)[0], data.get(i)[1], data.get(i)[2], data.get(i)[3], data.get(i)[4]));
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}
