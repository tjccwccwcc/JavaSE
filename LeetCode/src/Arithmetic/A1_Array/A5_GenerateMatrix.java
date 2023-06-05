package Arithmetic.A1_Array;

import java.util.Arrays;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3
 * 输出:
 * 1, 2, 3
 * 8, 9, 4
 * 7, 6, 5
 */
public class A5_GenerateMatrix {
    public static void main(String[] args) {
        int n = 4;
        A5_GenerateMatrix matrix = new A5_GenerateMatrix();
        System.out.println(Arrays.deepToString(matrix.generateMatrix(n)));
    }
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int count = 1;
        for (int i = n; i >= 1; i--) {
            for (int j = n - i; j < i; j++) {
                nums[n - i][j] = count;
                count++;
            }
            for (int j = n - i + 1; j < i; j++) {
                nums[j][i - 1] = count;
                count++;
            }
            for (int j = i - 2; j >= n - i; j--) {
                nums[i - 1][j] = count;
                count++;
            }
            for (int j = i - 2; j >= n - i + 1; j--) {
                nums[j][n - i] = count;
                count++;
            }
        }
        return nums;
    }
}
