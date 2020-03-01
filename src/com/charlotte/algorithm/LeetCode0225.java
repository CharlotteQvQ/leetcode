package com.charlotte.algorithm;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @Author: Charlotte Li
 * @Date: 2020/3/1 14:14
 * @Description: 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version: 1.0
 */
public class LeetCode0225 {

    // default queue
    private Queue<Integer> stack;
    // temp stack
    private Queue<Integer> tempStack;
    // top element
    private int topElement;

    /** Initialize your data structure here. */
    public LeetCode0225() {
        stack = new LinkedList<>();
        tempStack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
        topElement = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (stack.size() == 0)
            throw new NullPointerException();
        while(stack.size() > 1){
            topElement = stack.remove();
            tempStack.add(topElement);
        }
        int popElement = stack.remove();
        Queue<Integer> temp = stack;
        stack = tempStack;
        tempStack = temp;
        return popElement;
    }

    /** Get the top element. */
    public int top() {
        if (stack.size() == 0)
            throw new NullPointerException();
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.size() == 0;
    }
}
