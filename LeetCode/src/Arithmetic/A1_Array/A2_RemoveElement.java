package Arithmetic.A1_Array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1: 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5,
 * 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class A2_RemoveElement {
    public static void main(String[] args) {
        A2_RemoveElement removeElement = new A2_RemoveElement();
        int[] nums = new int[]{0,4,4,0,4,4,4,0,2};
        int val = 4;
        System.out.println(removeElement.removeElement(nums, val));
        nums = new int[]{0,4,4,0,4,4,4,0,2};
        System.out.println(removeElement.removeElement1(nums, val));
        nums = new int[]{0,4,4,0,4,4,4,0,2};
        System.out.println(removeElement.removeElement2(nums, val));
    }
    //暴力解法
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val){
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return size;
    }
    //双指针法(快慢指针)
    public int removeElement1(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        for (int i = 0; i < slowIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return slowIndex;
    }
    //相向双指针法
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        for (int i = 0; i < left; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return left;
    }
}
