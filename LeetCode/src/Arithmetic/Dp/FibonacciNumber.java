package Arithmetic.Dp;

import java.util.Scanner;

public class FibonacciNumber {
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
        if (n < 0)
            throw new NumberFormatException("NumberFormatException");
        int[] dp = new int[n+1];
        dp[0] = 0;
        if (n >= 1)
            dp[1] = 1;
        if (n == 0 || n == 1)
            return dp[n];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int Iterator1(int n){
        if (n < 0)
            throw new NumberFormatException("NumberFormatException");
        if (n == 0 || n == 1)
            return n;
        return Iterator1(n-2) + Iterator1(n-1);
    }
}
