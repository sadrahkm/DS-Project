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
        Telephone.showData();
        System.out.println("--------------------------------------------------------------------------------------------");
        Person.showData();
        System.out.println("--------------------------------------------------------------------------------------------");
        Machine.showData();
        System.out.println("--------------------------------------------------------------------------------------------");
        House.showData();
        System.out.println("---------------------");
        BankAccount.showData();
        System.out.println("--------------------------------------------------------------------------------------------");
        Relation.showData();
        System.out.println("___________________________________________________________________________________________________________________________________");
        System.out.println("Sazmani");
        print(Person.find_Sazmani(Person.dict));
        System.out.println("___________________________________________________________________________________________________________________________________");
        Dictionary<String, Person> dic_find_House_orMachine = Person.find_Machine_or_House(Person.find_Sazmani((Person.dict)));
        System.out.println("********* Sazmani people who have house and machine ***************");
        print(dic_find_House_orMachine);
        System.out.println("___________________________________________________________________________________________________________________________________");
        System.out.println("********* relation Sazmani people who have house and machine ***************");
        Dictionary<String, Person> dic_find_House_orMachine_rel = Person.find_Machine_or_House(Person.find_relationship(Person.find_Sazmani((Person.dict))));
        print(dic_find_House_orMachine_rel);
        System.out.println("___________________________________________________________________________________________________________________________________");
        System.out.println("sazmani and relation sazmani who have machine and house and smug gave them money");
        print(Person.find_Machine_or_House(Person.find_Sazmani(Person.personsRelGhachaghchi(Person.find_smug()))));
        print(Person.find_Machine_or_House(Person.find_relationship(Person.find_Sazmani(Person.personsRelGhachaghchi(Person.find_smug())))));
        System.out.println("___________________________________________________________________________________________________________________________________");
        System.out.println("Person who called with smuggler or smuggler called them and they or their family have machine or house and smuggler gave them money");
       // print(Person.person_called());
        print(Person.find_Machine_or_House(Person.find_Sazmani(Person.personsRelGhachaghchi(Person.person_called()))));
        print(Person.find_Machine_or_House(Person.find_relationship(Person.find_Sazmani(Person.personsRelGhachaghchi(Person.person_called())))));
    }

    public static void print(Dictionary<String, Person> dictionary) {
        Enumeration e = dictionary.elements();
        while (e.hasMoreElements()) {
            Person temp = (Person) e.nextElement();
            System.out.println(temp.name + "  " + temp.lastName);
        }
    }
}
