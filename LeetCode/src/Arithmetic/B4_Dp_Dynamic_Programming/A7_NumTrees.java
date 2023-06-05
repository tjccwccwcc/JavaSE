package Arithmetic.B4_Dp_Dynamic_Programming;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees/
 */

/**
 * 1 dp:n节点二叉搜索树数量  n:二叉搜索树节点数
 * 2 dp[n] = dp[n-1]*dp[0] + dp[n-2]*dp[1] +...+ dp[0]*dp[n-1]
 * 3 dp[0] = 1, dp[1] = 1
 * 4 正序
 */
public class A7_NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(4));
        System.out.println(numTrees1(4));
    }
    public static int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = i-1; j >= 0; j--) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static int numTrees1(int n) {
        long C = 1;//防止溢出
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
