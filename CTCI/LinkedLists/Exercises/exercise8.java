package LinkedLists.Exercises;

import LinkedLists.Implementation.SinglyLinkedList;
import LinkedLists.Implementation.SinglyLinkedList.*;

public class exercise8 {
    
// Given a linked list which might contain a loop, implement an algorithm that returns the node at the beginning of the loop (if one exists).

// First thoughts are to iterate through the list and add addresses into a set. If the same address occurs, there is a loop in the list. This will create O(N) space complexity so let's try and do it in O(1).

// Create two pointers, runner and lag
// Move runner at 2x of lag
// When they collide, move lag back to head while keeping runner where it is. 
// Move both at a rate of one step, when they collide, you will have found the collision point.

// This runs at O(N) time complexity with O(1) space complexity

    public static Node findBeginning(Node nHead) {
        Node runner = nHead;
        Node lag = nHead;

        while (runner != null && runner.next != null) {
            lag = lag.next;
            runner = runner.next.next;
            if (lag == runner) {
                break;
            }
        }

        if (runner == null || runner.next == null) {
            return null;
        }

        lag = nHead;
        while (lag != runner) {
            lag = lag.next;
            runner = runner.next;
        }

        return runner;
    }

}
