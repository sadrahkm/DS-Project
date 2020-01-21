import java.util.*;

public class Call extends Yal {
    String tellNumber;
    String date;
    String duration;
    String key ;
    static Dictionary<String, Call> dict = new Hashtable<String, Call>();

    Call(Telephone from, Telephone to , String tellNumber, String date, String duration){
        this.from=from;
        this.to= to;
        this.tellNumber=tellNumber;
        this.date=date;
        this.duration=duration;
        this.key=tellNumber;
    }

    public static void make(String path) {
        Telephone callfrpm;
        Telephone callto;
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);

        for (int i = 0; i < data.size(); i++) {
            callfrpm=Telephone.dict.get(data.get(i)[0]);
            callto=Telephone.dict.get(data.get(i)[1]);
            dict.put( data.get(i)[2], new Call(callfrpm, callto, data.get(i)[2], data.get(i)[3], data.get(i)[4]));
        }
    }

}
