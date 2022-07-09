package LinkedLists.Exercises;

import LinkedLists.Implementation.DoublyLinkedList;
import LinkedLists.Implementation.DoublyLinkedList.*;


public class exercise4 {

// Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x (IMPORTANT: the partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions. The additional spacing in the example below indicates the partition).

// First Thoughts are to traverse the current Linked List and copy elements to two new lists, one that is greater than or equal to the partition value, and one that is less than the partition value. This would run in O(N) time, with O(N) space.

    // parameters are head of current linked list, and value x
    public static Node partition(DoublyLinkedList ll, int x) {

        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        Node n = ll.head;

        while (n != null) {
            if (n.data < x) {
                if (beforeStart == null) {
                    beforeStart = n;
                    beforeEnd = beforeStart;
                }
                else {
                    beforeEnd.next = n;
                    beforeEnd = n;
                }
            }
            else {
                if (afterStart == null) {
                    afterStart = n;
                    afterEnd = afterStart;
                }
                else {
                    afterEnd.next = n;
                    afterEnd = n;
                }
            }
            n = n.next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }
    


    public static void main(String[] args) {
        DoublyLinkedList myLL = new DoublyLinkedList();
        myLL.addNodeToBack(1);
        myLL.addNodeToBack(5);
        myLL.addNodeToBack(2);
        myLL.addNodeToBack(6);
        myLL.addNodeToBack(3);
        myLL.addNodeToBack(7);
        myLL.addNodeToBack(4);
        myLL.printLL();

        partition(myLL, 4);
        myLL.printLL();

    }


}
