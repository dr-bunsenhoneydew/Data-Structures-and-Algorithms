package LinkedLists.Implementation;

import java.util.*;

public class LinkedListsJavaUtil {
    
// LinkedLists using Java Utils package creates a doubly linked list
    public static void main(String[] args) {
        LinkedList<Integer> myLL = new LinkedList<Integer>(); // creates a new doubly linked list of type <Integer>
        myLL.add(2); // adds to back
        myLL.addFirst(1); // adds to front
        myLL.addLast(3); // adds to back
        System.out.println(myLL); // can print out the linked list using System.out.println(LinkedListName)
        
        //Can use .addAll to add all elements of a list to your linked list
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        list.add(6);
        myLL.addAll(list);
        System.out.println(myLL);

        
    }
}
