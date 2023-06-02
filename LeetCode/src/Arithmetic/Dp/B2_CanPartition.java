package Arithmetic.Dp;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * 题目难易：中等
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意: 每个数组中的元素不会超过 100 数组的大小不会超过 200
 *
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */

/**
 * 0-1 背包
 * 背包容量： sum
 * value[]：nums
 * weight[]：nums
 */

public class B2_CanPartition {
    public static void main(String[] args) {
        B2_CanPartition b2CanPartition = new B2_CanPartition();
        int[] nums = new int[]{14,9,8,4,3,2};
        System.out.println(b2CanPartition.canPartition(nums));
        System.out.println(b2CanPartition.canPartition1(nums));
        System.out.println(b2CanPartition.canPartition2(nums));
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        ArrayList arrayList = new ArrayList();
        for (Object obj : nums){
            sum += (Integer) obj;
            arrayList.add(obj);
        }
        if (sum % 2 != 0) return false;
        arrayList.sort(Comparator.naturalOrder());
        int[][] dp = new int[nums.length][sum + 1];
        for (int i = (int)arrayList.get(0); i <= sum; i++) {
            dp[0][i] = (int)arrayList.get(0);
        }
        for (int i = 1; i < nums.length; i++) {
            int m = (int)arrayList.get(i);
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = (j >= m) ? Math.max(dp[i - 1][j],
                        dp[i - 1][j - m] + m) : dp[i - 1][j];
                if (dp[i][j] == sum / 2) return true;
            }
        }
        return false;
    }
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (Object obj : nums){
            sum += (Integer) obj;
        }
        if (sum % 2 != 0) return false;
        int[] dp = new int[sum + 1];
        for (int i = 0; i < nums.length; i++) {
            int m = nums[i];
            for (int j = sum; j >= m; j--){
                dp[j] = Math.max(dp[j], dp[j - m] + m);
                if (dp[j] == sum / 2) return true;
            }
        }
        return false;
    }
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (Object obj : nums){
            sum += (Integer) obj;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //0-1背包问题哎
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){//遍历的背包
                if(dp[j - nums[i]]) dp[j] = true;
            }
        }
        return dp[target];
    }
}
