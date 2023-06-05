package Arithmetic.A1_Array;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1： 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 * 示例 2： 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class A3_SortedSquares {
    public static void main(String[] args) {
        A3_SortedSquares sortedSquares = new A3_SortedSquares();
        int[] nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
        nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares1(nums)));
        nums = new int[]{-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares2(nums)));
    }
    //冒泡排序
    public int[] sortedSquares(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (Math.abs(nums[j]) < Math.abs(nums[j - 1])){
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }
    //快速排序
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        nums = quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public int[] quickSort(int[] array,int s,int t){
        int i = 0;
        if (s < t){
            i = Partition(array,s,t);
            quickSort(array,s,i-1);
            quickSort(array,i+1,t);
        }
        return array;
    }
    public int Partition(int[] array,int low,int high){
        int temp = array[low];
        while (low < high){
            while (low < high && array[high] >= temp) high--;
            if (low < high) {
                array[low] = array[high];
                low++;
            }
            while (low < high && array[low] < temp) low++;
            if (low < high) {
                array[high] = array[low];
                high--;
            }
        }
        array[low] = temp;
        return low;
    }
    //双指针法
    /**
     * 数组其实是有序的， 只不过负数平方之后可能成为最大数了。
     * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
     * 可以考虑双指针法
     */
    public int[] sortedSquares2(int[] nums) {
        int[] nums1 = new int[nums.length];
        int rightIndex = nums.length - 1;
        int leftIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[rightIndex]) >= Math.abs(nums[leftIndex])){
                nums1[i] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }else {
                nums1[i] = nums[leftIndex] * nums[leftIndex];
                leftIndex ++;
            }
        }
        return nums1;
    }
}
