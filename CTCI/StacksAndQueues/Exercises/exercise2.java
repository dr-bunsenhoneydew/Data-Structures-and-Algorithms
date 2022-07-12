package StacksAndQueues.Exercises;

import java.util.Stack;

// How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop, and min should all operate in O(1) time.

// First thoughts would be to implement a second stack, which would likely have a low space complexity as minimums may rarely change for large sized stacks. This would be updated as we push onto the stack, and if a mimum is popped from the main stack, it would also be popped from the secondary, minimum stack.

public class exercise2 extends Stack<Integer>{
    Stack<Integer> minStack;

    public exercise2() {
        minStack = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else {
            return minStack.peek();
        }
    }
    
}
