//package com.company;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person.make("src/data/people.csv");
        Machine.make("src/data/cars.csv");
        House.make("src/data/homes.csv");
        BankAccount.make("src/data/accounts.csv");
        Telephone.make("src/data/phones.csv");
        Relation.make("src/data/relationships.csv");
        Malekiat.make("src/data/ownerships.csv");
        Call.make("src/data/calls.csv");
        Tarakonesh.make("src/data/transactions.csv");
/*        Enumeration e1 = Malekiat.dict.elements();
        while (e1.hasMoreElements()){
            System.out.println(((Person)(((Malekiat) e1.nextElement()).from)).name);
        }*/
        Telephone.showData();
        System.out.println("---------------------");
        Person.showData();
        System.out.println("---------------------");
        Machine.showData();
        System.out.println("---------------------");
        House.showData();
        System.out.println("---------------------");
        BankAccount.showData();
        System.out.println("---------------------");
        Relation.showData();
        Person.find_Machine_or_House(Person.dict);
    }

    public static void print(Dictionary<String, Person> dictionary) {
        Enumeration e = dictionary.elements();
        while (e.hasMoreElements()) {
            Person temp = (Person) e.nextElement();
            System.out.println(temp.name + " , " + temp.lastName + " , " + temp.key + " , " + temp.birthDate + " , " + temp.birthPlace);
        }
    }
}
