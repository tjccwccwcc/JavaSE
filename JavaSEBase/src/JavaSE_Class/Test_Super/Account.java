package JavaSE_Class.Test_Super;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    public Account (int id, double balance, double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return annualInterestRate / 12;
    }

    public void withdraw (double amount){
        if (balance < amount){
            System.out.println("余额不足");
            System.out.println("账户余额为：" + balance);
        }
        else{
            balance -= amount;
            System.out.println("账户余额为：" + balance);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Double.compare(account.balance, balance)
                == 0 && Double.compare(account.annualInterestRate, annualInterestRate) == 0;
    }

    public void deposit (double amount){
        balance += amount;
        System.out.println("账户余额为：" + balance);
        System.out.println("月利率为：" + getMonthlyInterest());
    }
}
