import java.util.*;

public class Person extends Node {
    String key;
    String name;
    String lastName;
    String birthDate;
    String birthPlace;
    String workPlace;
    static CSVReader test = new CSVReader();
    static ArrayList<String[]> data = test.get("E:\\DS project\\src\\data\\people.csv");
    static  Dictionary<String,String> dict = new Hashtable<>();
    public static void make() {
        for (int i = 0; i < data.size(); i++)
            for (int j = 0; j < data.get(i).length; j++)
                dict.put(data.get(i)[2],data.get(i)[j]);
    }
    public static void showData(){
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                System.out.print(data.get(i)[j] + ",");
            }
            System.out.println();
        }
    }
    public void sazmanipeople(String num){
        ArrayList<String> pesonjob=new ArrayList<>();
        pesonjob.add()
        for (int i = 0; i < data.size(); i++)
            for (int j = 0; j < pesonjob.size(); j++)
                if (data.get(i)[5].equals(pesonjob.get(j))){
                    continue;
            }
        }
    }
}
