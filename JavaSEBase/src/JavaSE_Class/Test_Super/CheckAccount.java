package JavaSE_Class.Test_Super;

public class CheckAccount extends Account{
    private double overdraft;
    public CheckAccount(int id, double balance, double annualInterestRate,int overdraft){
        super(id,balance,annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

//    public void withdraw (double amount){
//        if (getBalance() >= amount){
//            setBalance(getBalance()-amount);
//            System.out.println("账户余额为："
//                    + getBalance() + "，可透支限额为：" + overdraft);
//        }
//        else{
//            if (getBalance() + overdraft >= amount){
//                overdraft = overdraft - amount + getBalance();
//                setBalance(0);
//                System.out.println("账户余额为："
//                        + getBalance() + "，可透支限额为：" + overdraft);
//            }
//            else{
//                System.out.println("超过透支限额");
//                System.out.println("账户余额为："
//                        + getBalance() + "，可透支限额为：" + overdraft);
//            }
//        }
//    }

    public void withdraw (double amount){
        if (getBalance() >= amount){
            super.withdraw(amount);
            System.out.println("可透支限额为：" + overdraft);
        }
        else{
            if (getBalance() + overdraft >= amount){
                overdraft = overdraft - amount + getBalance();
                super.withdraw(getBalance());
                System.out.println("可透支限额为：" + overdraft);
            }
            else{
                System.out.println("超过透支限额");
                System.out.println("账户余额为：" + getBalance());
                System.out.println("可透支限额为：" + overdraft);
            }
        }
    }
}
