package Arithmetic.Dp;

import java.util.Scanner;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： F(0) = 0，F(1) = 1 F(n) = F(n - 1) + F(n - 2)，其中 n > 1 给你n ，请计算 F(n) 。
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 提示：
 *
 * 0 <= n <= 30
 */
public class A1_FibonacciNumber {
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
