






import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Relation extends Yal {
    String nesbat;
    String nesbatTime;
    static Dictionary<String, Relation> dict = new Hashtable<>();

    Relation(String to, String from, String nesbat, String nesbatTime){
        this.to= to ;
        this.from= from;
        this.nesbat= nesbat;
        this.nesbat= nesbatTime;
        this.key=from+to;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[0]+data.get(i)[1] , new Relation(data.get(i)[0], data.get(i)[1], data.get(i)[2], data.get(i)[3]));
    }


}
