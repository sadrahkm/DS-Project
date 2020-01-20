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
            if (person.workPlace.equals("گمرک") || person.workPlace.equals("بندر")) {
                dic_find.put(person.key, person);
            }
        }
        return dic_find;
    }

    public static boolean is2year(String find) {
        Enumeration e2 = Malekiat.dict.elements();
        while (e2.hasMoreElements()) {
            Malekiat m= (Malekiat) e2.nextElement();
            if (((Person)m.from).code.equals(find)){
                int Number = Integer.parseInt(m.tamalokTime.substring(0, 4));
                if (2020 - Number < 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Dictionary<String, Person> find_Machine_or_House(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find_machine_or_house = new Hashtable<>();
        Enumeration machineEnumeration = Machine.dict.elements();
        Enumeration houseEnumeration = House.dict.elements();
        while (houseEnumeration.hasMoreElements() ) {
            Enumeration e1 = dictionary.elements();
            House H = (House) houseEnumeration.nextElement();
            while (e1.hasMoreElements()) {
               Person p= (Person) e1.nextElement();
                if (p.code.equals(H.personCode) && is2year(H.personCode) ) {
                    dic_find_machine_or_house.put(H.personCode, dict.get(H.personCode));
                }
            }
        }
        while ( machineEnumeration.hasMoreElements()) {
            Enumeration e1 = dictionary.elements();
            Machine M = (Machine) machineEnumeration.nextElement();
            while (e1.hasMoreElements()) {
                Person p= (Person) e1.nextElement();
                if (p.code.equals(M.personCode) && is2year(M.personCode)  ){
                    dic_find_machine_or_house.put(M.personCode, dict.get(M.personCode));
                }
            }
        }
        return dic_find_machine_or_house;
    }

    public static Dictionary<String, Person> find_relationship(Dictionary<String, Person> dictionary) {
        Dictionary<String, Person> dic_find_relationship = new Hashtable<>();
        Enumeration e1 = dictionary.keys();
        Enumeration e2 = Relation.dict.elements();
        while (e1.hasMoreElements()) {
            String p = (String) e1.nextElement();
            while (e2.hasMoreElements()) {
                Relation p2 = (Relation) e2.nextElement();
                if (p.equals(((Person) p2.from).key)) {
                    dic_find_relationship.put(((Person) p2.to).key, (Person) p2.to);
                }
            }
        }
       return dic_find_relationship;
    }

    public static Dictionary<String, Person> find_smug() {
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

    public static Dictionary<String, Person> personsRelGhachaghchi() {
        Dictionary<String, Person> result = new Hashtable<>();
        Dictionary<String, Person> dict_smug = find_smug();
        Enumeration transactions = Tarakonesh.dict.elements();
        Enumeration enumSmug;
        Person smugPerson;
        Tarakonesh tr= (Tarakonesh) transactions.nextElement();
        BankAccount accountFrom=(BankAccount) tr.from;
        BankAccount accountTo= (BankAccount) tr.to;
        while (transactions.hasMoreElements()) {
            enumSmug = dict_smug.elements();
            tr= (Tarakonesh) transactions.nextElement();
            System.out.println(tr.from);
            accountFrom = (BankAccount) tr.from;
            accountTo = (BankAccount) tr.to;
            while (enumSmug.hasMoreElements()) {
                smugPerson = (Person) enumSmug.nextElement();
                System.out.println(accountFrom);
                System.out.println(smugPerson);
                if (accountFrom.ownerAccount.equals(smugPerson.key)) {
                    result.put(accountTo.accountNum, Person.dict.get(accountTo.accountNum));
                }
            }
        }
        return result;
    }
    public Dictionary<String, Person> person_called() {
        Dictionary<String, Person> result = new Hashtable<>();
        Dictionary<String, Person> dict_smug = find_smug();
        Enumeration telephone = Telephone.dict.elements();
        Enumeration call = Call.dict.elements();
        String pId;
        while (call.hasMoreElements()) {
            Enumeration enumsmug = dict_smug.keys();
            Call c = (Call) (call.nextElement());
            while (enumsmug.hasMoreElements()) {
                pId = (String) enumsmug.nextElement();
                if (((Telephone) (c.from)).personCode.equals(pId)) {
                    result.put(((Telephone) (c.to)).personCode, Person.dict.get(((Telephone) (c.to)).personCode));
                }
                if (((Telephone) (c.to)).personCode.equals(pId)) {
                    result.put(((Telephone) (c.from)).personCode, Person.dict.get(((Telephone) (c.from)).personCode));
                }
            }
        }
            return result;
    }
}
