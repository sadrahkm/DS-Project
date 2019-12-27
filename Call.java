import java.util.*;

public class Call extends Yal {
    String tellNumber;
    String time;
    String duration;
    String key ;
    static Dictionary<String, Call> dict = new Hashtable<>();

    Call(String tellNumber, String time, String duration){
    this.tellNumber=tellNumber;
    this.time=time;
    this.duration=duration;
    this.key=tellNumber;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[0] , new Call(data.get(i)[0], data.get(i)[1], data.get(i)[2]));
    }

}
