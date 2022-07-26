package Traversals;

import java.util.ArrayList;
import java.util.Stack;

import Implementation.BinarySearchTree.Node;

public class InOrderTraversal {
    private ArrayList<Integer> myList;

    public ArrayList<Integer> inorderTraversalRecursion(Node root) {
        myList = new ArrayList<Integer>();
        inorderTraversalRecursionHelper(root);
        return myList;
    }

    public void inorderTraversalRecursionHelper(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversalRecursion(root.getLeftChild());
        myList.add(root.getData());
        inorderTraversalRecursion(root.getRightChild());
    }

    public ArrayList<Integer> inorderTraversalIterative(Node root) {
        myList = new ArrayList<Integer>();
        Stack<Node> myStack = new Stack<Node>();
        Node curr = root;
        
        while (curr != null || !myStack.isEmpty()) {
            while (curr != null) {
                myStack.push(curr);
                curr = curr.getLeftChild();
            }
            curr = myStack.pop();
            myList.add(curr.getData());
            curr = curr.getRightChild();
            
        }
        return myList;
    }
}
