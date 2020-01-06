import java.awt.event.PaintEvent;
import java.util.*;

public class Person extends Node {
    String key;
    String code;
    String name;
    String lastName;
    String birthDate;
    String birthPlace;
    String workPlace;
    static Dictionary<String, Person> dict = new Hashtable<>();

    Person(String name, String lastName, String code, String birthDate, String birthPlace, String workPlace) {
        this.name = name;
        this.lastName = lastName;
        this.code = code;
        this.key = code;
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
            Person temp = (Person) e.nextElement();
            System.out.println(temp.name + " , " + temp.lastName + " , " + temp.key + " , " + temp.birthDate + " , " + temp.birthPlace);
        }
    }

    static public Dictionary<String, Person> find_Sazmani(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find = new Hashtable<>();
        Enumeration e = dictionary.elements();
        while (e.hasMoreElements()) {
            Person person = (Person) e.nextElement();
            if (person.workPlace.equals("\"گمرک\"") || person.workPlace.equals("\"بندر\"")) {
                dic_find.put(person.key, person);
            }
        }
        return dic_find;
    }
    public boolean is2year(String find) {
        Enumeration e1 = Malekiat.dict.keys();
        Enumeration e2 = Malekiat.dict.elements();
        int Number;
        while (e1.hasMoreElements()) {
            if (e1.nextElement().equals(find)) {
                Number = Integer.parseInt(((Malekiat) e2.nextElement()).tamalokTime.substring(0, 3));
                if (2020 - Number < 2)
                    return true;
            }
        }
        return false;
    }
    public Dictionary<String, Person> find_relationship(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find_relationship = null;
        Enumeration e1 = dictionary.keys();
        Enumeration e2 = Relation.dict.elements();
        while (e1.hasMoreElements()) {
            Relation p = (Relation) e1.nextElement();
            while (e2.hasMoreElements()) {
                if (e2.nextElement().equals(((Person) p.from).key)) {
                    dic_find_relationship.put(((Person) p.to).key, (Person) p.to);
                }
            }
        }
        return dic_find_relationship;
    }

    public Dictionary<String, Person> find_House(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find_House = null;
        Enumeration e1 = House.dict.elements();
        Enumeration e2 = dictionary.keys();
        while (e1.hasMoreElements()) {
            House k = (House) e1.nextElement();
            while (e2.hasMoreElements()) {
                if (e2.nextElement().equals(k.personCode)) {
                    if (is2year(((House) e1.nextElement()).key)) {
                        dic_find_House.put(k.personCode, dict.get(k.personCode));
                    }
                }
            }
        }
        return dic_find_House;
    }

    public Dictionary<String, Person> find_Machine(Dictionary<String, String> dictionary) {
        Dictionary<String, Person> dic_find_Machine = null;
        Enumeration e1 = Machine.dict.elements();
        Enumeration e2 = dictionary.keys();
        while (e1.hasMoreElements()) {
            Machine m = (Machine) e1.nextElement();
            while (e2.hasMoreElements()) {
                if (e2.nextElement().equals(m.personCode)) {
                    if (is2year(((Machine) e1.nextElement()).key)) {
                        dic_find_Machine.put(m.personCode, dict.get(m.personCode));
                    }
                }
            }
        }
        return dic_find_Machine;
    }

    public Dictionary<String, Person> find_smug() {
        Dictionary<String, Person> result = new Hashtable<>();
        Enumeration persons = Person.dict.elements();
        while (persons.hasMoreElements()) {
            Person person = (Person) (persons.nextElement());
            if (person.workPlace.equals("قاچاقچی")) {
                result.put(person.code, person);
            }
        }
        return result;
    }

    public Dictionary<String, Person> personsRelGhachaghchi() {
        Dictionary<String, Person> result = new Hashtable<>();
        Dictionary<String, Person> dict_smug = find_smug();
        Enumeration transactions = Tarakonesh.dict.elements();
        Enumeration enumSmug;
        Person smugPerson;
        BankAccount accountFrom;
        BankAccount accountTo;
        while (transactions.hasMoreElements()) {
            enumSmug = dict_smug.elements();
            accountFrom = (BankAccount) ((Tarakonesh) transactions.nextElement()).from;
            accountTo = (BankAccount) ((Tarakonesh) transactions.nextElement()).to;
            while (enumSmug.hasMoreElements()) {
                smugPerson = (Person) enumSmug.nextElement();
                if (accountFrom.ownerAccount.equals(smugPerson.key)) {
                    result.put(accountTo.accountNum, Person.dict.get(accountTo.accountNum));
                }
            }
        }
        return result;
    }
}
