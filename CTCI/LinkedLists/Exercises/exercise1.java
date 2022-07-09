package LinkedLists.Exercises;

import java.util.*;

import LinkedLists.Implementation.SinglyLinkedList;
import LinkedLists.Implementation.SinglyLinkedList.*;


public class exercise1 {

// Write code to remove duplicates from an unsorted linked list
// FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?

// First thoughts are to implement a set to check if an element has already been used. If this is not allowed, then you would have to n^2 check the entire list. 

// Let's use a hashset for the former. This will run in O(N) time complexity, and has space complexity of O(N).
    public static void removeDups(SinglyLinkedList ll) {
        Node n = ll.head;
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;

        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
                ll.size--;
            }
            else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

// Otherwise, we could use a runner and iterate through the entire list O(N^2)

    public static void removeDupsRunners(SinglyLinkedList ll) {
        Node current = ll.head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList myLL = new SinglyLinkedList();
        myLL.addNodeToFront(1);
        myLL.addNodeToFront(2);
        myLL.addNodeToFront(2);
        myLL.addNodeToFront(4);
        myLL.addNodeToFront(3);
        myLL.addNodeToFront(4);
        removeDups(myLL);
        myLL.printLL();


    }
   

}
