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
        Person.findSazmani(Person.dict);
        Telephone.showData();
        System.out.println("---------------------");
        Person.showData();
        System.out.println("---------------------");
        Machine.showData();
        System.out.println("---------------------");
        House.showData();
        System.out.println("---------------------");
        BankAccount.showData();
    }
}
