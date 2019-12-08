package com.charlotte.algorithm;

/**
 * @Author: Charlotte Li
 * @Date: 2019/12/6 21:52
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version: 1.0
 */
public class LeetCode0035 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int i = solution2(nums, 5);
        System.out.println(i);
    }

    //二分法--需要根据题意去判断是需要返回left还是返回right
    public static int solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums[nums.length - 1] < target)
            return nums.length;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (target < nums[0])
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
