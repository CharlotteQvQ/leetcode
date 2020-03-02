package com.charlotte.algorithm;

import com.charlotte.common.ListNode;

/**
 * @Author: Charlotte Li
 * @Date: 2020/3/2 20:46
 * @Description: 206. Reverse Linked List
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version: 1.0
 */
public class LeetCode0206 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);

    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseListIteratively(ListNode head) {
        ListNode result = null;
        ListNode temp = head;
        while(temp != null){
            ListNode nextNode = temp.next;
            temp.next = result;
            result = temp;
            temp = nextNode;
        }
        return result;
    }


}

