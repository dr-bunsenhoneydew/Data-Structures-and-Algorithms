package LinkedLists.Implementation;

public class SinglyLinkedList {
    public Node head;
    public int size;

    public static class Node {
        public int data;
        public Node next;

        public Node() {
            this.data = 0;
            this.next = null;
        }

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }

        public void setNext(Node x) {
            this.next = x;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void addNodeToFront(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = null;
        }

        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        System.out.println("Added " + data + " to front");
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index OOB");
        }
        if (head == null) {
            System.out.println("Empty List");
        }

        Node currNode = head;

        while (index > 0) {
            currNode = currNode.next;
            index--;
        }
        System.out.println("Got data: " + currNode.data);
        return currNode.data;
    }

    public Node find(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index OOB");
        }
        if (head == null) {
            System.out.println("Empty List");
        }

        Node currNode = head;

        while (index > 0) {
            currNode = currNode.next;
            index--;
        }
        return currNode;
    }

    

    public void addNodeToIndex(int index, int data) {
        if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index OOB");
		}
        if (head == null) {
            System.out.println("Empty List");
        }

        int ind = index;

        if (index == 0) {
            this.addNodeToFront(data);
            return;
        }

        else {
            Node prevIndexNode = head;

            while (index - 1 > 0) {
                prevIndexNode = prevIndexNode.next;
                index--;
            }

            Node newNode = new Node(data);
            newNode.next = prevIndexNode.next;
            prevIndexNode.next = newNode;
        }
        size++;
        System.out.println("Added new node " + data + " to index " + ind);
    }

    public void removeByIndex(int index) {
        if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Index OOB");
		}
        if (head == null) {
            System.out.println("Empty List");
        }

        if (index == 0) {
            head = head.next;
        }

        else {
            Node prevIndexNode = head;

            while (index - 1 > 0) {
                prevIndexNode = prevIndexNode.next;
                index--;
            }

            prevIndexNode.next = prevIndexNode.next.next;
        }
        size++;
        System.out.println("Removed node at index: " + index);
    }

    public void setByIndex(int index, int newData) {
        if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index OOB");
		}
        if (head == null) {
            System.out.println("Empty List");
        }

        Node indexNode = find(index);
        indexNode.data = newData;
        System.out.println("Element at index " + index + "changed to " + indexNode.data);
    }

    public void printLL() {
        Node currNode = head;
        
        System.out.println("Size: " + this.size);

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList myLL = new SinglyLinkedList();
        myLL.addNodeToFront(5);
        myLL.printLL();
        myLL.addNodeToFront(4);
        myLL.printLL();
        myLL.get(1);
        myLL.addNodeToIndex(2,6);
        myLL.printLL();
        myLL.removeByIndex(1);
        myLL.printLL();
        myLL.setByIndex(1,14);
        myLL.printLL();
    }

}
