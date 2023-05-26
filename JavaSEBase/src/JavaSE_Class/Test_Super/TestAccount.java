package JavaSE_Class.Test_Super;

public class TestAccount {
    public static void main(String[] args){
        Account client = new Account(1122,20000,0.045);
        client.withdraw(30000);
        client.deposit(30000);
        CheckAccount client1 = new CheckAccount(1122,20000,0.045,5000);
        client1.withdraw(5000);
        client1.withdraw(18000);
        client1.withdraw(3000);
    }
}
