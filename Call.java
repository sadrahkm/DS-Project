import java.util.*;

public class Call extends Yal {
    String tellNumber;
    String date;
    String duration;
    String key ;
    static Dictionary<String, Call> dict = new Hashtable<>();

    Call(String from, String to , String tellNumber, String date, String duration){
        this.from=from;
        this.to= to;
        this.tellNumber=tellNumber;
        this.date=date;
        this.duration=duration;
        this.key=tellNumber;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put( data.get(i)[2] , new Call(data.get(i)[0], data.get(i)[1], data.get(i)[2],data.get(i)[3],data.get(i)[4]));
    }

}
