package Arithmetic.A1_Array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class A4_MinSubArrayLen {
    public static void main(String[] args) {
        A4_MinSubArrayLen subArrayLen = new A4_MinSubArrayLen();
        int target = 213;
        int[] nums = new int[]{12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(subArrayLen.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}


//    /**
//     *         0  1  2  3  4  5  6  7
//     * nums 2  1  1  1  0  0  0  0  0
//     * nums 3  1  1  1  1  0  2  0  0
//     * nums 1  1  1  1  1  2  2  3  0
//     * nums 2  1  1  1  1  2  2  3  3
//     * nums 4  1  1  1  1  1  2  2  2
//     * nums 3  1  1  1  1  1  2  2  2
//     */
//    //需要连续的子数组，所以错了
//    public int minSubArrayLen(int target, int[] nums) {
//        int[] dp = new int[target + 1];
//        for (int num : nums) {
//            for (int j = dp.length - 1; j >= 0; j--) {
//                if (num >= j) dp[j] = 1;
//                else {
//                    if (dp[j - num] != 0 && dp[j] != 0)
//                        dp[j] = Math.min(dp[j - num] + 1, dp[j]);
//                    else if (dp[j - num] != 0 && dp[j] == 0)
//                        dp[j] = dp[j - num] + 1;
//                }
//            }
//        }
//        return dp[target];
//    }