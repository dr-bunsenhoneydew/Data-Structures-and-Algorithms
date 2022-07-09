package LinkedLists.Exercises;

import LinkedLists.Implementation.SinglyLinkedList;
import LinkedLists.Implementation.SinglyLinkedList.*;

public class exercise5 {
    
// You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list

// Ex: (7 -> 1 -> 6) + (5 -> 9 -> 2) = 617 + 295


    public static Node addLists(Node l1, Node l2) {
        return addLists(l1, l2, 0);
    }

    public static Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        SinglyLinkedList newResult = new SinglyLinkedList();
        Node result = new Node();
        newResult.head = result;

        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);

            result.setNext(more);
        }
        
        newResult.printLL();
        return result;

    }

    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();
        ll1.addNodeToFront(6);
        ll1.addNodeToFront(1);
        ll1.addNodeToFront(7);
        ll1.printLL();

        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.addNodeToFront(2);
        ll2.addNodeToFront(9);
        ll2.addNodeToFront(5);
        ll2.printLL();

        addLists(ll1.head, ll2.head);
    }

}
