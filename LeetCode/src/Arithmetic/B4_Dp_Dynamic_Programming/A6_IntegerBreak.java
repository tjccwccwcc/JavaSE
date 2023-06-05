package Arithmetic.B4_Dp_Dynamic_Programming;
/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */

/**
 * 1 dp为拆分后最大乘数，n为整数
 * 2 dp[n] = max{dp[i],z*max{n-z,dp[n-z]}}
 * 3 dp[1] = 1, dp[2] = 1;
 * 4 正序
 */
public class A6_IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    public static int integerBreak(int n){
        int[] dp = new int[n+1];
//        int court = 0;
//        int mul;
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
//                mul = Math.max(j,dp[j]) * Math.max(i-j,dp[i-j]);
//                mul = j * Math.max(i-j,dp[i-j]);
//                court = Math.max(mul, court);
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
//            dp[i] = court;
        }
        return dp[n];
    }

    //贪心
    public static int integerBreak1(int n){
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        result *= n;
        return result;
    }
}
