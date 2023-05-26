package JavaSE_Class.Test_Object;

import java.util.Objects;

public class EqualsAndToString {
    private int id;
    private double balance;
    private String name;

    public EqualsAndToString(int id, double balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsAndToString that = (EqualsAndToString) o;
        return id == that.id && Double.compare(that.balance, balance)
                == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, name);
    }

    @Override
    public String toString() {
        return "EqualsAndToString{" +
                "id=" + id +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
