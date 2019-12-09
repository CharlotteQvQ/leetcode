package com.charlotte.algorithm;

/**
 * @Author: Charlotte Li
 * @Date: 2019/12/9 15:13
 * @Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version: 1.0
 */
public class LeetCode0189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate_2(nums, 3);
    }

    public static void rotate_2(int[] nums, int k) {
        if (nums != null && nums.length > 1) {
            int stepCount = k % nums.length;
            int[] tempNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i + stepCount < nums.length) {
                    tempNums[i + stepCount] = nums[i];
                } else {
                    tempNums[i+stepCount-nums.length] = nums[i];
                }
            }
            for (int i = 0; i < nums.length; i++){
                nums[i] = tempNums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + ",");
            }
            System.out.println();
        }
    }

    public static void rotate_1(int[] nums, int k) {
        if (nums != null && nums.length > 1) {
            int stepCount = k % nums.length;
            for (int i = 0; i < stepCount; i++) {
                int temp = nums[0];
                for (int j = 0; j < nums.length; j++) {
                    if (j != nums.length - 1) {
                        int prev = nums[j + 1];
                        nums[j + 1] = temp;
                        temp = prev;
                    } else {
                        nums[0] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }
}
