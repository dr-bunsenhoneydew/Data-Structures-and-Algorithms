package Implementation;

import java.util.*;

// Implementation of a basic tree

public class BasicTree {
    private Node root;

    public class Node {
        public int data;
        private ArrayList<Node> children;
        private Node parent;

        public Node() {
            this.data = 0;
            this.children = null;
            this.parent = null;
        }

        public Node(int nodeData) {
            this.data = nodeData;
            this.children = new ArrayList<Node>();
            this.parent = null;
        }

        public Node(int nodeData, Node nodeParent) {
            this.data = nodeData;
            this.children = new ArrayList<Node>();
            this.parent = nodeParent;
        }

        public Node(int nodeData, Node nodeParent, ArrayList<Node> nodeChildren) {
            this.data = nodeData;
            this.children = new ArrayList<Node>();
            this.parent = nodeParent;
        }
    
        public void addChild(int nodeData) {
            Node newNode = new Node(nodeData, this);
            this.children.add(newNode);
        }

        public int getData() {
            return this.data;
        }
    }

    public static void main(String[]  args) {
        BasicTree myTree = new BasicTree();
        Node newNode = myTree.new Node(1);
        myTree.root = newNode;
        myTree.root.addChild(2);
        myTree.root.addChild(3);
        myTree.root.addChild(4);
        System.out.println("Root: " + myTree.root.data);
        for (int i = 0; i < myTree.root.children.size(); i++) {
            System.out.println(myTree.root.children.get(i).data);
        }
    }

}
