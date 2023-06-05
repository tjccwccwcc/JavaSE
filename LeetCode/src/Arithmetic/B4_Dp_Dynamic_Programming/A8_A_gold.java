package Arithmetic.B4_Dp_Dynamic_Programming;

import java.util.*;
/**
 * 小招在玩一款游戏：在一个N层高的金字塔上，以金字塔顶为第一层，第i层有i个落点，每个落点有若干枚金币，
 * 在落点可以跳向左斜向下或向右斜向下的落点。若知道金字塔的层数N及每层的金币数量分布，请计算小招在本次
 * 游戏中可以获得的最多金币数量。
 *
 * 输入描述:
 * 输入共有N + 1行(N ≤ 1024)，第一行为高度N，第二行至N + 1行 ，为该金字塔的金币数量分布。
 *
 * 输出描述:
 * 输出金币数量。
 *
 * 示例1
 * 输入
 * 5
 * 8
 * 3 8
 * 8 1 0
 * 4 7 5 4
 * 3 5 2 6 5
 *
 * 输出
 * 31
 *
 * 1、dp[i][j]:第i行第j列获得的金币数量
 * 2、dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1]
 * 3、dp[0][0] = nums[0][0]
 * 4、正序
 *
 * 8 3 8 8 1 0 4 7 5 4 3 5 2 6 5
 */
public class A8_A_gold {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("输入行数：");
//        int len = input.nextInt();
//        int[][] nums = new int[len][len];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                nums[i][j] = -1;
//            }
//        }
//        int i = 0;
//        while(i < len){
//            for (int j = 0; j <= i; j++) {
//                nums[i][j] = input.nextInt();
//            }
//            i++;
//        }
//        for (int j = 0; j < len; j++) {
//            for (int k = 0; k <= j; k++) {
//                System.out.print(nums[j][k] + " ");
//            }
//            System.out.println();
//        }
//        A8_A_gold a_gold = new A8_A_gold();
//        System.out.println(a_gold.maxPoint(nums));
//    }
//    public int maxPoint(int[][] nums){
//        int[][] dp = new int[nums.length][nums.length];
//        dp[0][0] = nums[0][0];
//        int max = 0;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 && nums[i - 1][j + 1] != -1)
//                    dp[i][j] = dp[i - 1][j + 1] + nums[i][j];
//                if (j != 0 && (j == i || j == i - 1))
//                    dp[i][j] = dp[i - 1][j - 1] + nums[i][j];
//                if (j != 0 && j != i && j != i - 1)
//                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1]) + nums[i][j];
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, dp[nums.length - 1][i]);
//        }
//        return max;
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[1024][1024];//可以通过题目限制条件，如N<=1024来设定数组大小
        //将金字塔存入二维数组
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                a[i][j] = in.nextInt();
            }
        }
        //从低向上计算，通过下面一层计算当前层的最大和
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                a[i][j] += Math.max(a[i + 1][j], a[i + 1][j + 1]);
            }
        }
        System.out.println(a[1][0]);
    }
}
