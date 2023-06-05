package Arithmetic.B4_Dp_Dynamic_Programming;
/**
 * 难度：中等
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */

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
public class B4_FindTargetSumWays {
    public static void main(String[] args) {
        B4_FindTargetSumWays find = new B4_FindTargetSumWays();
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
