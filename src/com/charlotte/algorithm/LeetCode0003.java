package com.charlotte.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:Charlotte Li
 * @Date:2019-08-16 13:37
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version:1.0
 */
public class LeetCode0003 {
    public static void main(String[] args) {
        int result = officialLengthOfLongestSubString("pwwkew");
        System.out.println("result￿:" + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Character> charMap = new HashMap<>();
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            if ((s.length() - j) > maxLength) {
                String subString = s.substring(j);
                for (int i = 0; i < subString.length(); i++) {
                    if (!charMap.containsValue(subString.charAt(i))) {
                        charMap.put(i, subString.charAt(i));
                        if (subString.length() - 1 == i) {
                            if (i + 1 > maxLength) {
                                maxLength = i + 1;
                            }
                            charMap.clear();
                        }
                    } else {
                        if (i > maxLength) {
                            maxLength = i;
                        }
                        charMap.clear();
                        break;
                    }
                }
            }
        }
        return maxLength;
    }

    //官方题解1--滑动窗口法
    public static int officialLengthOfLongestSubString(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
