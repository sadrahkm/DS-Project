import java.awt.event.PaintEvent;
import java.util.*;

public class Person extends Node {
    String key;
    String name;
    String lastName;
    String birthDate;
    String birthPlace;
    String workPlace;
    static Dictionary<String, Person> dict = new Hashtable<>();

    Person(String name, String lastName, String key, String birthDate, String birthPlace, String workPlace) {
        this.name = name;
        this.lastName = lastName;
        this.key = key;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.workPlace = workPlace;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put(data.get(i)[2], new Person(data.get(i)[0], data.get(i)[1], data.get(i)[2], data.get(i)[3], data.get(i)[4], data.get(i)[5]));
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }

/*    public void sazmanipeople(String num) {
        ArrayList<String> pesonjob = new ArrayList<>();
        pesonjob.add()
        for (int i = 0; i < data.size(); i++)
            for (int j = 0; j < pesonjob.size(); j++)
                if (data.get(i)[5].equals(pesonjob.get(j))) {
                    continue;
                }
    }*/
}
