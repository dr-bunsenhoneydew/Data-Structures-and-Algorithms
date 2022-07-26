package Implementation;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(int data) {
        this.root = new Node(data);
    }

    public BinarySearchTree(Node key) {
        this.root = key;
    }

    public Node populate(int[] arr) {
        Node root = this.root;
        for (int a : arr) {
            root = insert(root, a);
        }
        return root;
    }

    public static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;
        private Node parent;

        public Node() {
            this.setData(0);
            this.setLeftChild(null);
            this.setRightChild(null);
            this.parent = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node(int nodeData) {
            this.setData(nodeData);
            this.setLeftChild(null);
            this.setRightChild(null);
            this.parent = null;
        }
    }


    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.getData()) {
            root.setLeftChild(insert(root.getLeftChild(), data));
        }
        else {
            root.setRightChild(insert(root.getRightChild(), data));
        }
        return root;
    }

    public int minValue(Node root) {
        int minval = root.getData();
        while (root.getLeftChild() != null) {
            minval = root.getLeftChild().getData();
            root = root.getLeftChild();
        }
        return minval;
    }
    public Node delete(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.getData()) {
            root.setLeftChild(delete(root.getLeftChild(), data));
        }
        else if (data > root.getData()) {
            root.setRightChild(delete(root.getRightChild(), data));
        }
        else {
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            }
            else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }

            root.setData(minValue(root.getRightChild()));
            root.setRightChild(delete(root.getRightChild(), root.getData()));
        }
        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root ==  null) {return;}

        inOrderTraversal(root.getLeftChild());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRightChild());
    }

    public void preOrderTraversal(Node root) {
        if (root == null) {return;}

        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    public void postOrderTraversal(Node root) {
        if (root == null) {return;}

        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());
        System.out.print(root.getData() + " ");
    }

    Queue<Node> myQueue = new LinkedList<Node>();
    public void breadthFirstTraversal(Node root) {
        if (root == null) {return;}
        myQueue.clear();
        myQueue.add(root);
        while (!myQueue.isEmpty()) {
            Node node = myQueue.remove();
            System.out.print(node.getData() + " ");
            if (node.getLeftChild() != null) {
                myQueue.add(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                myQueue.add(node.getRightChild());
            }
        }

    }


    public int searchForElement(int element) {
        root = searchHelper(root, element);
        if (root != null) {
            return root.getData();
        }
        else {
            return -1;
        }
    }
    public Node searchHelper(Node root, int element) {
        if (root == null || root.getData() == element) {
            return root;
        }
        if (root.getData() > element) {
            return searchHelper(root.getLeftChild(), element);
        }
        else {
            return searchHelper(root.getRightChild(), element);
        }  
        
    }



    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node newNode = new Node(50);
        bst.root = newNode;
        int[] dataArr = {1,2,3,10,11,12,51,52,53,70,71,72,40,44,45};
        bst.populate(dataArr);
        bst.delete(bst.root, 53);
        bst.preOrderTraversal(bst.root);
        System.out.println();
        bst.inOrderTraversal(bst.root);
        System.out.println();
        bst.postOrderTraversal(bst.root);
        System.out.println();
        bst.breadthFirstTraversal(bst.root);
        System.out.println();
        System.out.println(bst.searchForElement(71));
    }

}
