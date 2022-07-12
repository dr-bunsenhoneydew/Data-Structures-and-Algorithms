package StacksAndQueues.Exercises;

import java.util.EmptyStackException;

// Describe how you could use a single array to implement three stacks.

// First thoughts would be to simply allocate a third of the array capacity to each "stack"; hence, stack 1 would have [0, n/3), stack 2 would have [n/3, 2n/3), and stack 3 would have [2n/3, n).

public class exercise1 {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public exercise1(int stackSize) {
        this.stackCapacity = stackSize;
        this.values = new int[stackSize * numberOfStacks];
        this.sizes = new int[numberOfStacks];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("Full Stack Exception");
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }



    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
    
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity; // gets the index of the beginning of this stack memorry 
        int size = sizes[stackNum]; // finds how big this stack is
        return offset + size - 1; // returns the "top", aka the end of this stack
    }


    public static void main(String[] args) {
        exercise1 myStacks = new exercise1(3);
        myStacks.push(1,2);
        myStacks.push(1,3);
        myStacks.push(1,4);
        System.out.println(myStacks.values[3]);
    }
}
