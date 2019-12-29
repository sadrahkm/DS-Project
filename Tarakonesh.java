import java.util.*;

public class Tarakonesh extends Yal {
    String number;
    String time;
    String price;
    static Dictionary<String, Tarakonesh> dict = new Hashtable<>();

    Tarakonesh(String from, String to ,  String number, String time, String price){
        this.from= from;
        this.to = to;
        this.number= number;
        this.time= time;
        this.price= price;
        this.key= number;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[2] , new Tarakonesh(data.get(i)[0], data.get(i)[1], data.get(i)[2],data.get(i)[3],data.get(i)[4]));
    }

}
