package StacksAndQueues.Implementation;

import java.util.EmptyStackException;

// A stack data structure is precisely what it sounds like: a stack of data. In certain types of problems, it can be favorable to store data in a stack rather than in an array. 
// A stack uses LIFO (last in, first out) ordering. That is, as in a stack of dinner plates, the most recent item added to the stack is the first item to be removed.

// Stacks use the below methods:
// 1) .pop() - Remove the top item from the stack
// 2) .push(item) - Add an item to the top of the stack
// 3) .peek() - Return the top of the stack
// 4) .isEmpty() - Return true if and only if the stack is empty

public class Stacks {
    public Node top;
    
    public class Node {
        public int data;
        public Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int newData) {
            this.data = newData;
            this.next = null;
        }
    }

    public Stacks() {
        this.top = null;
    }

    public int pop() {
        // if stack is empty, throw exception
        if (top == null) {
            throw new EmptyStackException();
        }

        // store top data into new variable
        int topData = top.data;

        // set current top to the next Node
        top = top.next;

        // return data
        return topData;
    }

    public void push(int data) {
        // create new node
        Node newNode = new Node(data);
        // if top/stack is empty, set top to new node
        if (top == null) {
            top = newNode;
        }
        // else, set new node's next to previous top. Reset top to new node
        else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
