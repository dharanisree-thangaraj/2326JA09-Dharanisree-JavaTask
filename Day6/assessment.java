public class BankingApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        Thread user1 = new Thread(new WithdrawTask(account, 70), "User-1");
        Thread user2 = new Thread(new WithdrawTask(account, 50), "User-2");
        Thread user3 = new Thread(new WithdrawTask(account, 30), "User-3");

        user1.start();
        user2.start();
        user3.start();
    }
}
class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }
    public synchronized void withdraw(int amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to withdraw $" + amount);

        if (balance >= amount) {
            System.out.println(threadName + " approved. Processing...");
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(threadName + " completed withdrawal of $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println(threadName + " denied. Insufficient balance: $" + balance);
        }
    }
}

class WithdrawTask implements Runnable {
    private BankAccount account;
    private int amount;

    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
public class BankingApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100); 
        Thread user1 = new Thread(new WithdrawTask(account, 70), "User-1");
        Thread user2 = new Thread(new WithdrawTask(account, 50), "User-2");
        Thread user3 = new Thread(new WithdrawTask(account, 30), "User-3");
        user1.start();
        user2.start();
        user3.start();
    }
}
class BankAccount {
    private int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }
    public synchronized void withdraw(int amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to withdraw $" + amount);

        if (balance >= amount) {
            System.out.println(threadName + " approved. Processing...");
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(threadName + " completed withdrawal of $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println(threadName + " denied. Insufficient balance: $" + balance);
        }
    }
class WithdrawTask implements Runnable {
    private BankAccount account;
    private int amount;

    public WithdrawTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    @Override
    public void run() {
        account.withdraw(amount);
    }
}
