package Arithmetic.B4_Dp_Dynamic_Programming;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *
 *        0  1  2  3  4  5  6
 * num 1  1  1  1  1  1  1  1
 * num 2  1  1  2  3  5  8  13
 * num 3  1  1  2  4  7  13 24
 *
 * 1 1
 * 2
 *
 * 1 1 1                  3
 * 2 1
 * 1 2
 *
 * 1 1 1 1                3 1
 * 2 1 1                  1 3
 * 1 2 1
 * 1 1 2
 * 2 2
 *
 * 1 1 1 1 1               3 1 1
 * 2 1 1 1                 1 3 1
 * 1 2 1 1                 1 1 3
 * 1 1 2 1                 3 2
 * 1 1 1 2                 2 3
 * 2 2 1
 * 2 1 2
 * 1 2 2
 *
 * 进阶：如果给定的数组中含有负数会发生什么？
 * 问题会产生何种变化？
 * 如果允许负数出现，需要向题目中添加哪些限制条件？
 */
public class C3_CombinationSum4 {
    public static void main(String[] args) {
        C3_CombinationSum4 c3_combinationSum4 = new C3_CombinationSum4();
        int target = 5;
        int[] nums = new int[]{1,2,3};
        System.out.println(c3_combinationSum4.combinationSum4(nums, target));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) dp[i] += dp[i - num];
            }
        }
        for (int j : dp) {
            System.out.print(j + " ");
        }
        System.out.println();
        return dp[target];
    }
}
