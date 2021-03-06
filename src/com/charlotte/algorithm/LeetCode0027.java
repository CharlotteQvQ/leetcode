package com.charlotte.algorithm;

/**
 * @Author: Charlotte Li
 * @Date: 2019/11/11 16:11
 * @Description: 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version: 1.0
 */
public class LeetCode0027 {

    public static void main(String[] args) {
        int[] nums = {5};
        int val = removeElement(nums, 5);
        System.out.println("新数组长度为:" + val);
        for (int i = 0; i < 1; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * @return int
     * @Author: Charlotte Li
     * @Description: My solution: 将元素上浮，倒序遍历数组，若该元素等于目标值则位置不动，若不等于目标值则寻找与之最近的目标值调换位置
     * 若找至第一位仍没有目标值则遍历结束
     * @Date: 2019/11/11 16:45
     * @Param [nums, val]
     **/
    public static int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                result += 1;
                continue;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == val) {
                        result += 1;
                        nums[j] = nums[i];
                        break;
                    }
                }
            }
        }
        return nums.length-result;
    }
    public static int removeElement_Office1(int[] nums,int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement_Office2(int[] nums,int val){
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
