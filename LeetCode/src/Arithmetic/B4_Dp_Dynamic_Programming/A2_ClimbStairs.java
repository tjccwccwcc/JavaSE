package Arithmetic.B4_Dp_Dynamic_Programming;

import java.util.Scanner;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1 阶 + 1 阶
 * 2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 */

/**
 * 1、dp:方法总数 n:n个台阶
 * 2、dp[n] = dp[n-1] + dp[n-2]
 * 3、dp[0] = 1, dp[1] = 1
 * 4、正序
 * 5、dp[2] = dp[1] + dp[0] = 2
 */
public class A2_ClimbStairs {
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
