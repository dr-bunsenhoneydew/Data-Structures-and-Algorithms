package StacksAndQueues.Exercises;

import java.util.*;

// Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).

// Follow up: implement a funciton popAt(int index) which performs a pop operation on a specific sub-stack.

public class exercise3 {
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    public void push(int v) {
        Stack<Integer> last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(v);
        }
        else {
            Stack<Integer> newStack = new Stack<Integer>();
            newStack.push(v);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack<Integer> last = getLastStack();
        if (last == null) {
            throw new EmptyStackException();
        }
        int v = last.pop();
        if (last.size() == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }



}
