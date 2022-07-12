package StacksAndQueues.Implementation;

import java.util.NoSuchElementException;

// A queue implements FIFO (first-in first-out) ordering. As in a line or queue at a ticket stand, items are removed from the data structure in the same order that they are added.

// Queues use the below methods:
// 1) .add(item) - Add an item to the end of the queue
// 2) .remove() - Remove the first item in the queue
// 3) .peek() - Return the top of the queue
// 4) .isEmpty() - Return true if and only if the queue is empty

// One place where queues are often used is in breadth-first search or inimplementing a cache


public class Queues {
    public Node first;
    public Node last;

    public Queues() {
        this.first = null;
        this.last = null;
    }
    
    public class Node {
        public int data;
        public Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);

        // if there already exists a last Node, set the new one to be its next
        if (last != null) {
            last.next = newNode;
        }

        // set last Node pointer to the new node, as it is now the back of the queue
        last = newNode;

        // if queue was empty, also set first to the new Node
        if (first == null) {
            first = newNode;
        }
    }

    public int remove() {
        // checks if empty list
        if (first == null) {
            throw new NoSuchElementException();
        }
        // returns removed data
        int removedData = first.data;
        // sets new first to the second Node
        first = first.next;
        // if new first node is null, then list is empty and last needs to be set to null
        if (first == null) {
            last = null;
        }
        return removedData;
    }

    public int peek() {
        if (first == null) { throw new NoSuchElementException();}
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }


}
