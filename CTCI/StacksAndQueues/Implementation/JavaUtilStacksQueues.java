package StacksAndQueues.Implementation;

import java.util.*;

public class JavaUtilStacksQueues {
    
    public static void main(String[] args) {
        Queue<Integer> myQueue = new PriorityQueue<Integer>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        myQueue.remove(); 
        System.out.println(myQueue);
        System.out.println(myQueue.isEmpty());
        myQueue.clear();
        System.out.println(myQueue);
        
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        System.out.println(myStack);
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack);
        System.out.println(myStack.isEmpty());
        myStack.clear();
        System.out.println(myStack);
    }
}
