package CRM.ui;
import CRM.bean.Customer;
import CRM.service.CustomerList;

import java.util.Scanner;
public class CustomerView {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CustomerList customers = new CustomerList(10);
        int break1 = 1;//控制功能1
        while (true) {
            if (break1 == 2) {//功能1
                System.out.println("-----------------------------当前客户列表-----------------------------");
                System.out.printf("%-15s", "编号");
                System.out.printf("%-15s", "姓名");
                System.out.printf("%-14s", "性别");
                System.out.printf("%-15s", "年龄");
                System.out.printf("%-15s", "电话");
                System.out.printf("%-15s", "邮箱");
                System.out.println();
                customers.printCustomers();
                System.out.println();
            }
            System.out.println("--------客户信息管理软件--------");
            System.out.println("         1 添加客户           ");
            System.out.println("         2 修改客户           ");
            System.out.println("         3 删除客户           ");
            System.out.println("         4 客户列表           ");
            System.out.println("         5 退   出           ");
            System.out.println("        请选择<1-5>：         ");
            int num = input.nextInt();
            if (num < 0 || num > 5) {
                System.out.println("输入有误，请重新输入");
                continue;
            }
            if (num == 1) {
                System.out.println("-----------添加客户-----------");
                System.out.print("姓名：");
                String name = input.next();
                System.out.print("性别：");
                String sex = input.next();
                System.out.print("年龄：");
                String age1 = input.next();
                while (!(age1.matches("[0-9]+"))){//判断字符串是否为数字
                    System.out.print("输入类型错误（或者输入了负数），请重新输入：");
                    age1 = input.next();
                }
                int age = Integer.parseInt(age1);
                System.out.print("电话：");
                String phoneNumber = input.next();
                System.out.print("邮箱：");
                String email = input.next();
                Customer customer = new Customer(name,sex,age,phoneNumber,email);
                customers.addCustomer(customer);
                System.out.println("-----------添加完成-----------");
                break1 = 1;
            }
            if (num == 2) {
                System.out.println("-----------修改客户-----------");
                System.out.print("请选择修改客户编号（-1退出）：");
                int number = input.nextInt();
                while (number < -1 || number == 0 ||
                        number > customers.getNumberOfCustomers()){
                    System.out.print("输入有误，请重新输入：");
                    number = input.nextInt();
                }
                if (number == -1) continue;
                System.out.print("姓名：");
                String name = input.next();
                System.out.print("性别：");
                String sex = input.next();
                System.out.print("年龄：");
                String age = input.next();
                while (!(age.matches("[0-9]+")
                        || age == null || age.length() == 0)){//判断字符串是否为数字或为空
                    System.out.print("输入类型错误（或者输入了负数），请重新输入：");
                    age = input.next();
                }
                int age1 = 0;
                if (age == null || age.length() == 0) age1 = -1;
                else age1 = Integer.parseInt(age);
                System.out.print("电话：");
                String phoneNumber = input.next();
                System.out.print("邮箱：");
                String email = input.next();
                customers.changeCustomer(number-1,name,sex,age1,phoneNumber,email);
                System.out.println("-----------修改完成-----------");
                break1 = 1;
            }
            if (num == 3) {
                System.out.println("-----------删除客户-----------");
                System.out.print("请选择要删除的客户编号（-1退出）：");
                int number = input.nextInt();
                while (number < -1 || number == 0 ||
                        number > customers.getNumberOfCustomers()){
                    System.out.print("输入有误，请重新输入：");
                    number = input.nextInt();
                }
                if (number == -1) continue;
                customers.deleteCustomer(number-1);
                System.out.println("-----------修改完成-----------");
                break1 = 1;
            }
            if (num == 4) {
                break1 = 2;
            }
            if (num == 5) {
                System.out.print("确认是否退出<Y/N>：");
                String char1 = input.next().toUpperCase();//识别大小写
                while (!char1.equals("Y")&&!char1.equals("N")){
                    System.out.print("输入错误，请重新输入：");
                    char1 = input.next().toUpperCase();
                }
                if (char1.equals("Y")) break;//注意String比较得用equals
            }
        }
    }
}
