


import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Relation extends Yal {
    String nesbat;
    String nesbatTime;
    static Dictionary<String, Relation> dict = new Hashtable<>();

    Relation(Person to, Person from, String nesbat, String nesbatTime) {
        this.to = to;
        this.from = from;
        this.nesbat = nesbat;
        this.nesbatTime = nesbatTime;
//        this.key = from.code + to.code;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        Person personFrom;
        Person personTo;
        for (int i = 0; i < data.size(); i++) {
            personTo = Person.dict.get(data.get(i)[0]);
            personFrom = Person.dict.get(data.get(i)[1]);
            dict.put(data.get(i)[0] + data.get(i)[1], new Relation(personTo, personFrom, data.get(i)[2], data.get(i)[3]));
        }
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            Relation temp = (Relation) e.nextElement();
            System.out.println(((Person) temp.to).name + " , " + ((Person) temp.from).name + " , " + temp.nesbat + " , " + temp.nesbatTime);
        }
    }
}
