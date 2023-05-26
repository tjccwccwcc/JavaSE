package Arithmetic.Dp;

import java.util.Scanner;

/**
 * 1、dp:方法总数 n:n个台阶
 * 2、dp[n] = dp[n-1] + dp[n-2]
 * 3、dp[0] = 1, dp[1] = 1
 * 4、正序
 * 5、dp[2] = dp[1] + dp[0] = 2
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("请输入一个自然数：");
            int n = input.nextInt();
            if (n == -1)
                break;
            double t1 = System.nanoTime();
            System.out.println("结果：" + Iterator(n));
            double t2 = System.nanoTime();
            System.out.println("time:" + (t2 - t1));

            double t3 = System.nanoTime();
            System.out.println("结果：" + Iterator1(n));
            double t4 = System.nanoTime();
            System.out.println("time:" + (t4 - t3));
        }
    }
    public static int Iterator(int n){
        if (n <= 0)
            throw new NumberFormatException("NumberFormatException");
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static int Iterator1(int n){
        if (n <= 0)
            throw new NumberFormatException("NumberFormatException");
        if (n == 1 || n == 2)
            return n;
        return Iterator1(n-2) + Iterator1(n-1);
    }
}
