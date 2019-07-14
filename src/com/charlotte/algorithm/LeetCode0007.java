package com.charlotte.algorithm;

/**
 * @Author:Charlotte Li
 * @Date:2019-07-01 20:07
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version:1.0
 */
public class LeetCode0007 {

    public static void main(String[] args) {
        reverse(1234567889);
    }

    /**
     * @Author: Charlotte Li
     * @Description:我的题解
     * @Date: 2019-07-01 20:39
     * @Param [x]
     * @return int
     **/
    public static int reverse(int x) {
        char[] intArray = String.valueOf(x).toCharArray();
        char[] resultArray = new char[intArray.length];

        if (intArray[0] == '-') {
            resultArray[0] = '-';
            for (int i = intArray.length - 1; i > 0; i--) {
                resultArray[intArray.length - i] = intArray[i];
            }


        } else {
            for (int i = intArray.length - 1; i >= 0; i--) {
                resultArray[intArray.length - 1 - i] = intArray[i];
            }
        }
        try {
            int result = Integer.parseInt(String.valueOf(resultArray));
            return result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * @Author: Charlotte Li
     * @Description:官方题解
     * @Date: 2019-07-01 20:39
     * @Param [x]
     * @return int
     **/
    public static int reverseOffical(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
