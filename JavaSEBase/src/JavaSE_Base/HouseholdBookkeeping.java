package JavaSE_Base;

import java.util.*;
public class HouseholdBookkeeping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int break1 = 1;//控制功能1
        int record = 0;//控制数组
        int initialAmount = 10000;//初始金额
        //原代码段一
        List<String> income1 = new LinkedList<String>();
        List<String> Amount1 = new LinkedList<String>();
        List<String> explain1 = new LinkedList<String>();
        while (true) {
            if (break1 == 2) {//功能1
                System.out.println("---------当前收支明细---------");
                System.out.printf("%-14s", "收支");
                System.out.printf("%-14s", "账户金额");
                System.out.printf("%-14s", "收支金额");
                System.out.printf("%-16s", "说明");
                System.out.println();
                for (int i = 0; i < record; i++) {
                    //原代码段二
                    System.out.printf("%-14s",(Double.parseDouble(income1.get(i)) > 0) ? "收入" : "支出");
                    System.out.printf("%-17s", "" + Double.parseDouble(Amount1.get(i)));
                    System.out.printf("%-16s", "" + Math.abs(Double.parseDouble(income1.get(i))));
                    System.out.printf("%-16s", explain1.get(i));
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println("--------家庭收支记账软件--------");
            System.out.println("         1 收支明细           ");
            System.out.println("         2 登记收入           ");
            System.out.println("         3 登记支出           ");
            System.out.println("         4 退   出           ");
            System.out.println("        请选择<1-4>：         ");
            int num = input.nextInt();
            if (num < 0 || num > 4) {
                System.out.println("输入有误，请重新输入");
                continue;
            }
            if (num == 1) {
                break1 = 2;
            }
            if (num == 2) {
                //原代码段三
                System.out.print("本次收入金额：");
                String income2 = input.next();
                while (!income2.matches("[0-9]+")){//判断字符串是否为数字
                    System.out.print("输入类型错误，请重新输入：");
                    income2 = input.next();
                }
                income1.add(income2);
                System.out.print("本次收入说明：");
                explain1.add(input.next());
                System.out.println("-----------登记完成-----------");
                initialAmount += Double.parseDouble(income2);
                Amount1.add("" + initialAmount);
                break1 = 1;
                record++;
            }
            if (num == 3) {
                //原代码段四
                System.out.print("本次支出金额：");
                String income2 = "-" + input.next();
                while (!income2.matches("-[0-9]+")){//判断字符串是否为（负数）数字
                    System.out.print("输入类型错误，请重新输入：");
                    income2 = "-" + input.next();
                }
                //添加余额功能，如果余额不足无法支出
                while (initialAmount + Double.parseDouble(income2) < 0){
                    System.out.print("您的账户余额不足，请重新输入：");
                    income2 = "-" + input.next();
                    while (!income2.matches("-[0-9]+")){//判断字符串是否为（负数）数字
                        System.out.print("输入类型错误，请重新输入：");
                        income2 = "-" + input.next();
                    }
                }
                income1.add(income2);
                System.out.print("本次支出说明：");
                explain1.add(input.next());
                System.out.println("-----------登记完成-----------");
                initialAmount += Double.parseDouble(income2);
                Amount1.add("" + initialAmount);
                break1 = 1;
                record++;
            }
            if (num == 4) {
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

//用于有限账本记账
        //原代码段一
        /*
        String[] income = new String[10];//收入支出
        String[] Amount = new String[10];//账户
        String[] explain = new String[10];//说明
         */


                        //原代码段二
                        /*
                        System.out.printf("%-14s",(Double.parseDouble(income[i]) > 0) ? "收入" : "支出");
                        System.out.printf("%-17s", "" + Amount[i]);
                        System.out.printf("%-16s", "" + Math.abs(Double.parseDouble(income[i])));
                        System.out.printf("%-16s", explain[i]);
                         */


                //原代码段三
                /*
                if (record >= 10) {//防止数组溢出
                    //必须放在这，否则功能1可能不显示收支
                    record = 0;
                    for (int i = 0; i < 2; i++) {
                        Amount[i] = "";
                        income[i] = "";
                        explain[i] = "";
                    }
                }
                System.out.print("本次收入金额：");
                income[record] = input.next();//!Character.isDigit字符是否为数字
                while (!income[record].matches("[0-9]+")){//判断字符串是否为数字
                    System.out.print("输入类型错误，请重新输入：");
                    income[record] = input.next();
                }
                System.out.print("本次收入说明：");
                explain[record] = input.next();
                System.out.println("-----------登记完成-----------");
                initialAmount += Double.parseDouble(income[record]);
                Amount[record] = "" + initialAmount;
                 */


                //原代码段四
                /*
                if (record >= 10) {
                    record = 0;
                    for (int i = 0; i < 2; i++) {
                        Amount[i] = "";
                        income[i] = "";
                        explain[i] = "";
                    }
                }
                System.out.print("本次支出金额：");
                income[record] = "-" + input.next();
                while (!income[record].matches("-[0-9]+")){//判断字符串是否为（负数）数字
                    System.out.print("输入类型错误，请重新输入：");
                    income[record] = "-" + input.next();
                }
                 */
                /*
                //添加余额功能，如果余额不足无法支出
                while (initialAmount + Double.parseDouble(income[record]) < 0){
                    System.out.print("您的账户余额不足，请重新输入：");
                    income[record] = "-" + input.next();
                    while (!income[record].matches("-[0-9]+")){//判断字符串是否为（负数）数字
                        System.out.print("输入类型错误，请重新输入：");
                        income[record] = "-" + input.next();
                    }
                }
                */
                /*
                System.out.print("本次支出说明：");
                explain[record] = input.next();
                System.out.println("-----------登记完成-----------");
                initialAmount += Double.parseDouble(income[record]);
                Amount[record] = "" + initialAmount;
                 */