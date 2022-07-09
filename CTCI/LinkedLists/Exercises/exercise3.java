package LinkedLists.Exercises;

public class exercise3 {
    
// Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, give only access to that node

// Since we only have access to the current node, we could simply copy the next node's data into the current one, and delete the next node. This would run in O(1) time with O(1) space complexity

    public class Node {
        int data;
        Node next;
    }

    public void deleteMiddleNode(Node n) {
        if (n.next == null) {
            System.out.println("Cannot be deleted, from end of list");
        }
        
        n.data = n.next.data;
        n.next = n.next.next;
    }


}
