class BankAccount {
    private String name;
    private int balance;
    public BankAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }
}

class TransactionManager {
    public void transfer(BankAccount from, BankAccount to, int amount) {
        System.out.println("Transaction started...");
        if (from.getBalance() >= amount) {
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Transferred " + amount + " from " + from.getName() + " to " + to.getName());
            System.out.println("Transaction committed.");
        } else {
            System.out.println("Transaction failed: Insufficient funds.");
            System.out.println("Transaction rolled back.");
        }
    }
}

public class PartC_Transactions {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Sumit", 5000);
        BankAccount a2 = new BankAccount("Arpit", 2000);
        TransactionManager tm = new TransactionManager();
        tm.transfer(a1, a2, 3000);
        System.out.println(a1.getName() + " balance: " + a1.getBalance());
        System.out.println(a2.getName() + " balance: " + a2.getBalance());
    }
}
