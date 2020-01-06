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

    public Dictionary<String, Person> find_Machine_or_House(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find_machine_or_house = new Hashtable<>();
        Enumeration houseEnumeration = House.dict.elements();
        Enumeration machineEnumeration = Machine.dict.elements();
        while (houseEnumeration.hasMoreElements() || machineEnumeration.hasMoreElements()) {
            Enumeration e1 = dictionary.keys();
            House H = (House) houseEnumeration.nextElement();
            Machine M = (Machine) machineEnumeration.nextElement();
            while (e1.hasMoreElements()) {
                if (e1.nextElement().equals(H.personCode) && is2year(((House) houseEnumeration.nextElement()).key)) {
                    dic_find_machine_or_house.put(H.personCode, dict.get(H.personCode));
                }
                if (e1.nextElement().equals(M.personCode) && is2year(((Machine) machineEnumeration.nextElement()).key)) {
                    dic_find_machine_or_house.put(M.personCode, dict.get(M.personCode));
                }
            }
        }
        return dic_find_machine_or_house;
    }

    public Dictionary<String, Person> find_relationship(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find_relationship = new Hashtable<>();
        Dictionary<String, Person> dic_find_machine_or_house_for_relationship = new Hashtable<>();
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
        Enumeration houseEnumeration = House.dict.elements();
        Enumeration machineEnumeration = Machine.dict.elements();
        while (houseEnumeration.hasMoreElements() || machineEnumeration.hasMoreElements()) {
            Enumeration relationshipEnumaration = dic_find_relationship.keys();
            House H = (House) houseEnumeration.nextElement();
            Machine M = (Machine) machineEnumeration.nextElement();
            while (relationshipEnumaration.hasMoreElements()) {
                if (relationshipEnumaration.nextElement().equals(H.personCode) && is2year(((House) houseEnumeration.nextElement()).key)) {
                    dic_find_machine_or_house_for_relationship.put(H.personCode, dict.get(H.personCode));
                }
                if (e1.nextElement().equals(M.personCode) && is2year(((Machine) machineEnumeration.nextElement()).key)) {
                    dic_find_machine_or_house_for_relationship.put(M.personCode, dict.get(M.personCode));
                }
            }
        }
        return dic_find_machine_or_house_for_relationship;
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
