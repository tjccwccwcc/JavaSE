package CRM.service;

import CRM.bean.Customer;

public class CustomerList {
    private Customer[] customer;
    private int numberOfCustomers;

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public CustomerList(int totalNumber){
        customer = new Customer[totalNumber];
    }
    public Customer[] getCustomer() {
        return customer;
    }
    //增加客户信息
    public void addCustomer(Customer customer){
        if (this.numberOfCustomers >= this.customer.length)
            this.rsert();
        this.customer[this.numberOfCustomers] = customer;
        this.numberOfCustomers++;
    }
    //更改客户信息
    public void changeCustomer(int number, String name,
                               String sex, int age,
                               String phoneNumber, String email){
        if(name != null && name.length() != 0)
            this.customer[number].setName(name);
        if(sex != null && sex.length() != 0)
            this.customer[number].setSex(sex);
        if(age != -1) this.customer[number].setAge(age);
        if(phoneNumber != null && phoneNumber.length() != 0)
            this.customer[number].setPhoneNumber(phoneNumber);
        if(email != null && email.length() != 0)
            this.customer[number].setEmail(email);
    }
    //删除客户信息
    public void deleteCustomer(int number){
        this.customer[number] = null;
        for(int i = number; i < customer.length - 1; i++){
            this.customer[i] = this.customer[i+1];
        }
        this.customer[customer.length-1] = null;
        this.numberOfCustomers--;
    }
    //遍历客户信息
    public void printCustomers(){
        for (int i = 0; i < this.numberOfCustomers; i++) {
            System.out.printf("%-16s", i + 1);
            System.out.printf("%-16s", this.customer[i].getName());
            System.out.printf("%-16s", this.customer[i].getSex());
            System.out.printf("%-16s", this.customer[i].getAge());
            System.out.printf("%-16s", this.customer[i].getPhoneNumber());
            System.out.printf("%-16s", this.customer[i].getEmail());
            System.out.println();
        }
    }
    //重置客户列表
    public void rsert(){
        this.numberOfCustomers = 0;
        for (int i = 0; i < this.customer.length; i++){
            this.customer[i] = null;
        }
    }
}
