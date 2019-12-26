//package com.company;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Telephone.make("data/phones.csv");
        Person.make("data/people.csv");
        Machine.make("data/cars.csv");
        House.make("data/homes.csv");
        BankAccount.make("data/accounts.csv");

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
