package Arithmetic.Dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 示例 1：
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 示例 2：
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 *
 * 示例 3：
 * 输入：amount = 10, coins = [10]
 * 输出：1
 *
 * 提示：
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 *
 *          0  1  2  3  4  5  6
 * coin 1   1  1  1  1  1  1  1
 * coin 2   1  1  2  2  3  3  4
 * coin 5   1  1  2  2  3  4  5
 *
 *          0  1  2  3
 * coin 2   1  1  1  0
 *
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
 * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 */
public class C2_ChangeExchangeII {
    public static void main(String[] args) {
        C2_ChangeExchangeII c2_changeExchangeII = new C2_ChangeExchangeII();
        int amount = 6;
        int[] coins = new int[]{1,2,5};
        System.out.println(c2_changeExchangeII.change(amount, coins));
        System.out.println(c2_changeExchangeII.change1(amount, coins));
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (coins[0] == 1 || i % coins[0] == 0) ? 1 : 0;//替换一
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[j][i] = (j == 0) ?
                        1 : (j < coins[i]) ?
                        dp[j][i - 1] : dp[j - coins[i]][i] + dp[j][i - 1];//替换二
            }
        }
        //三
        return dp[amount][coins.length - 1];
    }
    public int change1(int amount, int[] coins) {
        //递推表达式
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
//一
//            if (coins[0] == 1){
//                dp[i][0] = 1;
//            }else if (coins[0] % i == 0){
//                dp[i][0] = 1;
//            }

//二
//                if (j == 0){
//                    dp[j][i] = 1;
//                }else if (j < coins[i]){
//                    dp[j][i] = dp[j][i - 1];
//                }else {
//                    dp[j][i] = dp[j - coins[i]][i] + dp[j][i - 1];
//                }

//三
//        for (int i = 0; i < dp[0].length; i++) {
//            for (int[] ints : dp) {
//                System.out.print(ints[i] + " ");
//            }
//            System.out.println();
//        }