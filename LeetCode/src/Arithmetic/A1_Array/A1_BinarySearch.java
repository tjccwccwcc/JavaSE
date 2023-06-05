package Arithmetic.A1_Array;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */

public class A1_BinarySearch {
    public static void main(String[] args) {
        A1_BinarySearch search = new A1_BinarySearch();
        int[] nums = new int[]{2,5};
        int target = 2;
        System.out.println(search.search(nums, target));
        System.out.println(search.search1(nums, target));
/*        for (int i = 0; i < 20; i++) {
            int a = (int) (Math.random() * 10);
            int b = (int) (Math.random() * 10) + 10;
            System.out.println(((a+b)>>1) == (a+((b-a)>>1)));
        }*/
    }
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int count = nums.length >> 1;
        int left = 0;
        int right = nums.length - 1;
        while (nums[count] != target){
            if (nums[count] > target) right = count;
            else left = count;
            count = (right + left) >> 1;
            if (right - left <= 1) {//[2,5] 2
                if (nums[left] == target) return left;
                if (nums[right] == target) return right;
                return -1;
            }
        }
        return count;
    }

    public int search1(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }
}
