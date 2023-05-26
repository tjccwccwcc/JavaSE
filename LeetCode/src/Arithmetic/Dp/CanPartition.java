package Arithmetic.Dp;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 0-1 背包
 * 背包容量： sum
 * value[]：nums
 * weight[]：nums
 */

public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        int[] nums = new int[]{14,9,8,4,3,2};
        System.out.println(canPartition.canPartition(nums));
        System.out.println(canPartition.canPartition1(nums));
        System.out.println(canPartition.canPartition2(nums));
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
