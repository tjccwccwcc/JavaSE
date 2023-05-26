package Arithmetic.Dp;

/**
 * 1、dp:花费 n:第n个台阶
 * 2、dp[n] = min((dp[n-1] + cost[n-1]),(dp[n-2] + cost[n-2]))
 * 3、dp[0] = 0、dp[1] = cost[0]
 * 4、正序
 * 5、dp[2] = min((dp[1]+cost[1]),(dp[0]+cost[0]))
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        System.out.println(Iterator(cost));
    }
    public static int Iterator(int[] cost){
        if (cost.length <= 0)
            throw new NumberFormatException("NumberFormatException");
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
