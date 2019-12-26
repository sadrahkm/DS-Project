import java.util.*;

public class BankAccount extends Node {
    String ownerAccount;
    String bank;
    String shebaNum;
    String accountNum;
    String key;
    static Dictionary<String, BankAccount> dict = new Hashtable<>();

    BankAccount(String ownerAccount, String bank, String shebaNum, String accountNum) {
        this.ownerAccount = ownerAccount;
        this.bank = bank;
        this.shebaNum = shebaNum;
        this.accountNum = accountNum;
        this.key = shebaNum;
    }

    public static void make(String path) {
        CSVReader read = new CSVReader();
        ArrayList<String[]> data = read.get(path);
        for (int i = 0; i < data.size(); i++)
            dict.put(data.get(i)[0], new BankAccount(data.get(i)[0], data.get(i)[1], data.get(i)[2], data.get(i)[3]));
    }

    public static void showData() {
        Enumeration e = dict.elements();
        while (e.hasMoreElements()) {
            BankAccount temp = (BankAccount) e.nextElement();
            System.out.println(temp.ownerAccount +" , "+temp.bank +" , "+temp.shebaNum +" , "+temp.accountNum );
        }
    }
}
