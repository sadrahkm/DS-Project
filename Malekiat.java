import java.util.*;

public class Malekiat extends Yal{
    String sabtAhval;
    String tamalokTime;
    String price;
    static Dictionary<String, Malekiat> dict = new Hashtable<>();

    Malekiat(Person from, Object to, String sabtAhval, String tamalokTime, String price){
        this.from= from;
        this.to =to;
        this.sabtAhval= sabtAhval;
        this.tamalokTime=tamalokTime;
        this.price=price;
        this.key=sabtAhval;
    }

    public static void make(String path) {
        Person personfrom;
        Object to;
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++) {
            personfrom = Person.dict.get(data.get(i)[0]);
            to = Person.dict.get(data.get(i)[1]);
            dict.put(data.get(i)[2], new Malekiat(personfrom, to, data.get(i)[2], data.get(i)[3], data.get(i)[4]));
        }
    }
}
