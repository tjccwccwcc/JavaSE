package JavaSE_Base;

import java.util.*;
public class CommonDivisorAndMultiple {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个数：");
        int num1 = input.nextInt();
        System.out.print("请输入一个数：");
        int num2 = input.nextInt();
        int min1 = (num1 < num2) ? num1 : num2;
        int max1 = (num1 < num2) ? num2 : num1;
        int max2 = 1;
        int min2 = num1 * num2;
        for (int i = 1; i <= min1; i++){
            if (num1 % i == 0 && num2 % i == 0)
                max2 = i;
        }
        System.out.println("最大公约数：" + max2);
        for (int j = num1 * num2; j >= max1; j--){
            if (j % num1 == 0 && j % num2 == 0)
                min2 = j;
        }
        System.out.println("最小公倍数：" + min2);
        /*
        for (int j = max1; j <= num1 * num2; j++){
            if (j % num1 == 0 && j % num2 == 0){
                System.out.println("最小公倍数：" + j);
                break;
            }
        }
        for (int i = min1; i >= 1; i--){
            if (num1 % i == 0 && num2 % i == 0) {
                System.out.println("最大公约数：" + i);
                break;
            }
        }
         */
    }
}
