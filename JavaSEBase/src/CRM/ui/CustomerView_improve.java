package CRM.ui;

import CRM.bean.Customer;
import CRM.service.CustomerList;
import CRM.util.CMUtility;

public class CustomerView_improve {
    public static void main(String[] args) {
        CustomerList customers = new CustomerList(10);
        CMUtility control = new CMUtility();
        int break1 = 1;//控制功能1
        Label:while (true) {
            if (break1 == 2) {//功能1
                print2();
                customers.printCustomers();
                System.out.println();
            }
            print1();
            char num = control.readMenuSelection();
            switch(num){
                case '1':
                    add(control, customers);
                    break1 = 1;
                    break;
                case '2':
                    change(control, customers);
                    break1 = 1;
                    break;
                case '3':
                    delete(control, customers);
                    break1 = 1;
                    break;
                case '4':
                    break1 = 2;
                    break;
                case '5':
                    System.out.print("确认是否退出<Y/N>：");
                    char quit = control.readConfirmSelection();
                    if (quit - 'Y' == 0)
                        break Label;
            }
        }
    }
    public static void add(CMUtility control, CustomerList customers){
        System.out.println("-----------添加客户-----------");
        System.out.print("姓名：");
        String name = control.readString(5);
        System.out.print("性别：");
        char sex = control.readChar();
        System.out.print("年龄：");
        int age = control.readInt();
        System.out.print("电话：");
        String phoneNumber = control.readString(11);
        System.out.print("邮箱：");
        String email = control.readString(20);
        Customer customer = new Customer(name,sex + "",age,phoneNumber,email);
        customers.addCustomer(customer);
        System.out.println("-----------添加完成-----------");
    }
    public static void change(CMUtility control, CustomerList customers){
        System.out.println("-----------修改客户-----------");
        System.out.print("请选择修改客户编号（-1退出）：");
        String number1 = control.readString(2);
        int number = Integer.parseInt(number1);
        while (number < -1 || number == 0 ||
                number > customers.getNumberOfCustomers()){
            System.out.print("输入有误，请重新输入：");
            number1 = control.readString(2);
            number = Integer.parseInt(number1);
        }
        if (number == -1) return;
        System.out.print("姓名：");
        String name = control.readString(5,"");
        System.out.print("性别：");
        char sex = control.readChar((char)0);
        System.out.print("年龄：");
        int age = control.readInt(0);
        System.out.print("电话：");
        String phoneNumber = control.readString(11,"");
        System.out.print("邮箱：");
        String email = control.readString(20,"");
        customers.changeCustomer(number-1,name,sex + "",age,phoneNumber,email);
        System.out.println("-----------修改完成-----------");
    }
    public static void delete(CMUtility control, CustomerList customers){
        System.out.println("-----------删除客户-----------");
        System.out.print("请选择要删除的客户编号（-1退出）：");
        String number1 = control.readString(2);
        int number = Integer.parseInt(number1);
        while (number < -1 || number == 0 ||
                number > customers.getNumberOfCustomers()){
            System.out.print("输入有误，请重新输入：");
            number1 = control.readString(2);
            number = Integer.parseInt(number1);
        }
        if (number == -1) return;
        customers.deleteCustomer(number-1);
        System.out.println("-----------修改完成-----------");
    }
    public static void print1(){
        System.out.println("--------客户信息管理软件--------");
        System.out.println("         1 添加客户           ");
        System.out.println("         2 修改客户           ");
        System.out.println("         3 删除客户           ");
        System.out.println("         4 客户列表           ");
        System.out.println("         5 退   出           ");
        System.out.println("        请选择<1-5>：         ");
    }
    public static void print2(){
        System.out.println("-----------------------------当前客户列表-----------------------------");
        System.out.printf("%-15s", "编号");
        System.out.printf("%-15s", "姓名");
        System.out.printf("%-14s", "性别");
        System.out.printf("%-15s", "年龄");
        System.out.printf("%-15s", "电话");
        System.out.printf("%-15s", "邮箱");
        System.out.println();
    }
}
