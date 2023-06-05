package Arithmetic.B4_Dp_Dynamic_Programming;
/**
 * https://leetcode.cn/problems/unique-paths/
 */

/**
 * 1、dp:方法数  m、n:位置
 * 2、dp[m][n] = dp[m-1][n] + dp[m][n-1]
 * 3、dp[0][0] = 0, dp[1][0] = dp[0][1] = 1, m,n > 1
 * 4、正序
 * 5、
 */
public class A4_UniquePaths {
    public static void main(String[] args) {
        int m = 7;
        int n = 3;
        System.out.println(uniquePaths(m,n));
        System.out.println(uniquePaths1(m,n));
    }
    public static int uniquePaths(int m, int n){
        if (m <= 0 && n <= 0)
            throw new NumberFormatException("NumberFormatException");
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i != 0 && j == 0)
                    dp[i][j] = 1;
                if (i == 0 && j!= 0)
                    dp[i][j] = 1;
                if (i != 0 && j!= 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //空间o(n)
    public static int uniquePaths1(int m, int n){
        if (m <= 0 && n <= 0)
            throw new NumberFormatException("NumberFormatException");
        int[] dp = new int[n];
        for(int i = 0; i <n; i++) dp[i] = 1;
        for(int j = 1; j < m; j++){
            for(int i = 1; i < n; i++){
                dp[i] += dp[i-1];
            }
        }
        return dp[n-1];
    }
}
