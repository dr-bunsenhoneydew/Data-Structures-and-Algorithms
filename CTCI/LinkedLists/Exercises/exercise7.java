package LinkedLists.Exercises;

import LinkedLists.Implementation.SinglyLinkedList;
import LinkedLists.Implementation.SinglyLinkedList.*;


public class exercise7 {
    
// Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.

// First thoughts are to traverse the first list and create a set of memory locations. Then traverse the second and if a location matches, return true. This would run in O(N), with O(N) space complexity

// Another method would be to run through the two linked lists, find both tails. If both tails match, we know they're intersecting. Otherwise, we can immediately return false. Then, we can take the length differences and "chop off" the first x nodes of the longer list. From there, we traverse until we reach the first "intersecting" node. This would still be O(M + N), but would have O(1) space complexity.

    public static int getLength(Node n) {
        int count  = 1;
        Node current = n;
        while (current.next != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static Node getTail(Node n) {
        Node current = n;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public static Node findIntersection(Node list1head, Node list2head) {
        if (list1head == null || list2head == null) {return null;}

        int len1 = getLength(list1head);
        int len2 = getLength(list2head);
        Node tail1 = getTail(list1head);
        Node tail2 = getTail(list2head);

        if (tail1 != tail2) {
            return null;
        }

        int sizeDiff = Math.abs(len1 - len2);

        if (len1 > len2) {
            while (sizeDiff > 0) {
                list1head = list1head.next;
            }
        }
        else {
            while (sizeDiff > 0) {
                list2head = list2head.next;
            }
        }

        while (list1head != list2head) {
            list1head = list1head.next;
            list2head = list2head.next;
        }
        return list1head;

    }

}
