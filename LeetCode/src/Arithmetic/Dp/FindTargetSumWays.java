package Arithmetic.Dp;
/**
 * nums: [1, 1, 1, 1, 1], S: 3
 * 5
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 正数子数组和 x 和负数子数组和 y
 * x + y = sum
 * x - y = target
 * x = (sum + target) / 2
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        FindTargetSumWays find = new FindTargetSumWays();
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(find.findTargetSumWays(nums,target));
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ( target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int new_target = (sum + target) >> 1;
        int[] dp = new int[new_target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = new_target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[new_target];
    }
}
