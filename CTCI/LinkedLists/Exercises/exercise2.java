package LinkedLists.Exercises;

import LinkedLists.Implementation.SinglyLinkedList;
import LinkedLists.Implementation.SinglyLinkedList.*;

public class exercise2 {
    
// Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list

// First Thoughts: If we implememnt a runner, which is ahead by k nodes, then we can itereate until we reach the end, and use the lagging pointer to return the kth to last element

// This will run in O(N) time complexity with O(1) space complexity

    public static void returnKthToLast(Node head, int k) {
        Node runner = head;
        Node lag = head;

        while (k > 0) {
            runner = runner.next;
            k--;
        }


        while (runner != null) {
            runner = runner.next;
            lag = lag.next;
        }

        System.out.println("Kth to last is: " + lag.data);
    }

    public static void main(String[] args) {
        SinglyLinkedList myLL = new SinglyLinkedList();
        myLL.addNodeToFront(6);
        myLL.addNodeToFront(5);
        myLL.addNodeToFront(4);
        myLL.addNodeToFront(3);
        myLL.addNodeToFront(2);
        myLL.addNodeToFront(1);
        myLL.printLL();
        returnKthToLast(myLL.find(0), 3);



    }
}
