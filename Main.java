//package com.company;

import javafx.css.CssParser;

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
        System.out.println("Sazmani");
        print(Person.find_Sazmani(Person.dict));
        System.out.println("*****");
        Dictionary<String, Person> dic_find_House = Person.find_Machine_or_House(Person.find_Sazmani(Person.dict));
        System.out.println("House");
        print(dic_find_House);

    }
    public static void print (Dictionary<String, Person> dictionary) {
        Enumeration e = dictionary.elements();
        while (e.hasMoreElements()) {
            Person temp = (Person) e.nextElement();
            System.out.println(temp.name + " , " + temp.lastName + " , " + temp.key + " , " + temp.birthDate + " , " + temp.birthPlace);
        }
    }
}
