package com.charlotte.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Charlotte Li
 * @Date: 2020/1/1 22:14
 * @Description: Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version: 1.0
 */
public class LeetCode0387 {
    public static void main(String[] args) {

    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!temp.containsKey(s.charAt(i))) {
                temp.put(s.charAt(i), 1);
            } else {
                int count = temp.get(s.charAt(i)) + 1;
                temp.put(s.charAt(i), count);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (temp.get(s.charAt(i)).equals(1)){
                return i;
            }
        }
        return  -1;
    }
}
