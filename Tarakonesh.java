import java.util.*;

public class Tarakonesh extends Yal {
    String number;
    String time;
    String price;
    static Dictionary<String, Tarakonesh> dict = new Hashtable<>();

    Tarakonesh(BankAccount from, BankAccount to, String number, String time, String price) {
        this.from = from;
        this.to = to;
        this.number = number;
        this.time = time;
        this.price = price;
        this.key = number;
    }

    public static void make(String path) {
        BankAccount accountFrom;
        BankAccount accountTo;
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++) {
            accountFrom = BankAccount.dict.get(data.get(i)[0]);
            accountTo = BankAccount.dict.get(data.get(i)[1]);
            dict.put(data.get(i)[2], new Tarakonesh(accountFrom, accountTo, data.get(i)[2], data.get(i)[3], data.get(i)[4]));
        }
    }

}
