package StacksAndQueues.Exercises;

import java.util.Stack;

// Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.

public class exercise5 {
    
    public static void sort(Stack<Integer> s) {
        Stack<Integer> n = new Stack<Integer>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!n.isEmpty() && n.peek() > temp) {
                s.push(n.pop());
            }
            n.push(temp);
        }

        while (!n.isEmpty()) {
            s.push(n.pop());
        }
    }

    
}
