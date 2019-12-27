import java.util.*;

public class Tarakonesh extends Yal {
    String time;
    String number;
    String price;
    String key = number;
    static Dictionary<String, Tarakonesh> dict = new Hashtable<>();

    Tarakonesh(String time, String number, String price){
        this.time= time;
        this.number= number;
        this.price= price;
        this.key= number;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[1] , new Tarakonesh(data.get(i)[0], data.get(i)[1], data.get(i)[2]));
    }

}
