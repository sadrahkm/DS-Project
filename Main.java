
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> homes = read.get("src/data/homes.csv");
        ArrayList<String[]> machines = read.get("src/data/homes.csv");
        ArrayList<String[]> phones = read.get("src/data/homes.csv");
        ArrayList<String[]> cars = read.get("src/data/homes.csv");
        ArrayList<String[]> accounts = read.get("src/data/homes.csv");
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
