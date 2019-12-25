import java.awt.event.PaintEvent;
import java.util.*;

public class Person extends Node {
    String key;
    String name;
    String lastName;
    String birthDate;
    String birthPlace;
    String workPlace;
    Person(String name,String lastName,String key,String birthDate,String birthPlace,String workPlace) {
    this.name=name;
    this.lastName=lastName;
    this.key=key;
    this.birthDate=birthDate;
    this.birthPlace=birthPlace;
    this.workPlace=workPlace;
    }
    static  Dictionary<String,Person> dict = new Hashtable<>();
    public static void make(ArrayList<String[]> data) {
        for (int i = 0; i < data.size(); i++)
                dict.put(data.get(i)[2],new Person(data.get(i)[0],data.get(i)[1],data.get(i)[2],data.get(i)[3],data.get(i)[4],data.get(i)[5]));
    }
    public static void showData(ArrayList<String[]> data){
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
