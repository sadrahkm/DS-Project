import java.util.*;

public class Malekiat extends Yal{
    String sabtAhval;
    String tamalokTime;
    String price;
    static Dictionary<String, Malekiat> dict = new Hashtable<>();

    Malekiat(String from, String to, String sabtAhval, String tamalokTime, String price){
        this.from= from;
        this.to =to;
        this.sabtAhval= sabtAhval;
        this.tamalokTime=tamalokTime;
        this.price=price;
        this.key=sabtAhval;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[2] , new Malekiat(data.get(i)[0], data.get(i)[1], data.get(i)[2],data.get(i)[3],data.get(i)[4]));
    }
}
