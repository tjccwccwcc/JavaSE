package Arithmetic.Dp;

/**
 * 尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
 */

public class LastStoneWeightII {
    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        int[] stones = new int[]{1,2};
        System.out.println(lastStoneWeightII.lastStoneWeightII(stones));
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++){
            sum += stones[i];
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++){
            for (int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
