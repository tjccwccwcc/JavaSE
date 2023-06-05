package Arithmetic.B4_Dp_Dynamic_Programming;

/**
 * https://leetcode.cn/problems/unique-paths-ii/
 */
public class A5_UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println(uniquePathsWithObstacles1(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        int n = 0;
        int m = 0;
        int control = 1;
        try {
            n = obstacleGrid[0].length;
            m = obstacleGrid.length;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (m == 0 || n == 0)
            throw new NumberFormatException("NumberFormatException");
        if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1)
            return 0;
        int[] dp = new int[n];
        //初始状态应该为[1,1,1,0,0,0,0]
        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 1)
                control = 0;
            dp[i] = control;
        }
        for (int j = 1; j < m; j++){
            for (int i = 0; i < n; i++){
                dp[i] = (obstacleGrid[j][i] != 1) ?
                        ((i != 0) ? dp[i] + dp[i-1] : dp[i]) : 0;
            }
        }
        return dp[n-1];
    }

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid){
        int n = 0;
        int m = 0;
        try {
            n = obstacleGrid[0].length;
            m = obstacleGrid.length;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (m == 0 || n == 0)
            throw new NumberFormatException("NumberFormatException");
        int[][] dp = new int[m][n];
        dp[0][0] = 1 - obstacleGrid[0][0];
        int control = dp[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (obstacleGrid[i][j] != 1){
                    if (i != 0 && j == 0)
                        dp[i][j] = dp[i-1][j];
                    if (i == 0 && j!= 0)
                        dp[i][j] = control;
                    if (i != 0 && j!= 0)
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else {
                    dp[i][j] = 0;
                    control = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
