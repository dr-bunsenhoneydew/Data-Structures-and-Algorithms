package Traversals;

import java.util.ArrayList;
import java.util.Stack;

import Implementation.BinarySearchTree.Node;

public class PreOrderTraversal {
    private ArrayList<Integer> myList;
    
    public ArrayList<Integer> preorderTraversalRecursion(Node root) {
        myList = new ArrayList<Integer>();
        preorderTraversalRecursionHelper(root);
        return myList;
    }
    public void preorderTraversalRecursionHelper(Node root) {
        if (root ==  null) {
            return;
        }
        myList.add(root.getData());
        preorderTraversalRecursionHelper(root.getLeftChild());
        preorderTraversalRecursionHelper(root.getRightChild());
    }

    public ArrayList<Integer> preorderTraversalIterative(Node root) {
        myList = new ArrayList<Integer>();
        Stack<Node> myStack = new Stack<Node>();

        if (root != null) {
            myStack.push(root);
        }

        while (!myStack.isEmpty()) {
            root = myStack.pop();
            myList.add(root.getData());
            if (root.getRightChild() != null) {
                myStack.push(root.getRightChild());
            }
            if (root.getLeftChild() != null) {
                myStack.push(root.getLeftChild());
            }
        }
        return myList;
    }
}
