package Traversals;

import java.util.ArrayList;
import java.util.Stack;

import Implementation.BinarySearchTree.Node;

public class PostOrderTraversal {
    private ArrayList<Integer> myList;

    public ArrayList<Integer> postorderTraversalRecursion(Node root) {
        myList = new ArrayList<Integer>();
        postorderTraversalRecursionHelper(root);
        return myList;
    }

    public void postorderTraversalRecursionHelper(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversalRecursionHelper(root.getLeftChild());
        postorderTraversalRecursionHelper(root.getRightChild());
        myList.add(root.getData());
    }


    public ArrayList<Integer> postorderTraversalIterativeTwoStack(Node root) {
        myList = new ArrayList<Integer>();
        Stack<Node> myStack1 = new Stack<Node>();
        Stack<Node> myStack2 = new Stack<Node>();
        Node curr = root;

        if (curr != null) {myStack1.push(curr);}

        while (!myStack1.isEmpty()) {
            curr = myStack1.pop();
            myStack2.push(curr);
            if (curr.getLeftChild() != null) {
                myStack1.push(curr.getLeftChild());
            }
            if (curr.getRightChild() != null) {
                myStack2.push(curr.getRightChild());
            }
        }

        while (!myStack2.isEmpty()) {
            curr = myStack1.pop();
            myList.add(curr.getData());
        }
        return myList;

    }

    public ArrayList<Integer> postorderTraversaliterativeOneStack(Node root) {
        myList = new ArrayList<Integer>();
        Stack<Node> myStack = new Stack<Node>();
        Node curr = root;
        Node prev = null;

        while (curr != null || !myStack.isEmpty()) {
            if (curr != null) {
                myStack.push(curr);
                curr = curr.getLeftChild();
            }
            else {
                curr = myStack.peek();
                if (curr.getRightChild() == null || curr.getRightChild() == prev) {
                    myList.add(curr.getData());
                    curr = myStack.pop();
                    prev = curr;
                    curr = null;
                }
                else {
                    curr = curr.getRightChild();
                }
            }
        }
        return myList;
    }
}
