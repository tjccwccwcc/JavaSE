package JavaSE_Base;

import java.util.*;
public class ThreeNumberSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] x = new int[3];
        System.out.print("请输入第一个数：");
        x[0] = input.nextInt();
        System.out.print("请输入第二个数：");
        x[1] = input.nextInt();
        System.out.print("请输入第三个数：");
        x[2] = input.nextInt();
        for (int j = x.length - 1; j >= 1; j--){
            for (int i = 0; i < j; i++){
                if(x[i+1] < x[i]){
                    int temp = x[i+1];
                    x[i+1] = x[i];
                    x[i] = temp;
                }
            }
        }
        System.out.println(x[0] + "," + x[1] + "," + x[2]);
        System.out.print("请输入性别");
        String sex = input.next();
        //int y = (int)(Math.random() * 100);
        int y = (int)(Math.random() * 90 + 10);//两位数
        if (sex.equals("男"))System.out.println(y);
    }
}
