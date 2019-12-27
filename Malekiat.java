import java.util.*;

public class Malekiat extends Yal{
    String sabtAhval;
    String tamalokTime;
    String price;
    String key = sabtAhval;
    static Dictionary<String, Malekiat> dict = new Hashtable<>();

    Malekiat(String sabtAhval, String tamalokTime, String price){
        this.sabtAhval= sabtAhval;
        this.tamalokTime=tamalokTime;
        this.price=price;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[0]+data.get(i)[1] , new Malekiat(data.get(i)[0], data.get(i)[1], data.get(i)[2]));
    }
}
