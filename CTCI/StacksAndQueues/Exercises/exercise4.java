package StacksAndQueues.Exercises;

import java.util.Stack;

// Implement a MyQueue class which implements a queue using two stacks

// First thoughts are that this can be done by having an initial entry stack, and once full enough, we can transfer these over to a secondary stack. Given the nature of LIFO, this will reverse the order of entries into the second stack, allowing for FIFO ordering. These stacks should be transfered when the reversed stack, "oldest entries", is empty.

public class exercise4 {
    public class MyQueue<T> {
        Stack<T> stackNewest;
        Stack<T> stackOldest;

        public MyQueue() {
            stackNewest = new Stack<T>();
            stackOldest = new Stack<T>();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            stackNewest.push(value);
        }

        public void transferStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            transferStacks();
            return stackOldest.peek();
        }

        public T remove() {
            transferStacks();
            return stackOldest.pop();
        }

    }
}
