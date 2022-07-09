package LinkedLists.Exercises;

import LinkedLists.Implementation.SinglyLinkedList;
import LinkedLists.Implementation.SinglyLinkedList.*;
import java.util.*;

public class exercise6 {
    
// Implement a function to check if a linked list is a palindrome

// First thoughts are to have to pointers, a runner which traverses the list 2x while the lag records each entry into a stack. Once the runner completes, we know the lag is in the middle of the list. From there, the lag can continue moving through the list and it the element matches that in the stack. 

// If it's a doubly linked list, it's easy to start and match from head and tail

// Each strategy would be O(N).

// For the former:

    public static boolean isPalindrome(Node head) {
        Node runner = head;
        Node lag = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (runner != null && runner.next != null) {
            stack.push(lag.data);
            lag = lag.next;
            runner = runner.next.next;
        }

        if (runner != null) {
            lag = lag.next;
        }

        while (lag != null) {
            int top = stack.pop().intValue();
            if (top != lag.data) {
                return false;
            }
            lag = lag.next;
        }
        return true;
    }

    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();
        ll1.addNodeToFront(1);
        ll1.addNodeToFront(2);
        ll1.addNodeToFront(3);
        ll1.addNodeToFront(2);
        ll1.addNodeToFront(1);
        ll1.printLL();

        System.out.println(isPalindrome(ll1.head));

        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.addNodeToFront(1);
        ll2.addNodeToFront(2);
        ll2.addNodeToFront(2);
        ll2.addNodeToFront(1);
        ll2.printLL();

        System.out.println(isPalindrome(ll2.head));

        SinglyLinkedList ll3 = new SinglyLinkedList();
        ll3.addNodeToFront(1);
        ll3.addNodeToFront(2);
        ll3.addNodeToFront(2);
        ll3.addNodeToFront(3);
        ll3.printLL();

        System.out.println(isPalindrome(ll3.head));
    }

}
