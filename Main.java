
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Telephone.showData();
        System.out.println("---------------------");
        Person.showData();
        System.out.println("---------------------");
        Machine.showData();
        System.out.println("---------------------");
        House.showData();
        System.out.println("---------------------");
        BankAccount.showData();
        Dictionary<String,String> dict = new Hashtable<>();
        for (int i = 0; i < Person.data.size(); i++) {
            dict.put(Person.data.get(i)[2],Person.data.get(i)[0]);
        }
        System.out.println(dict.get("57887985047"));
    }
}
