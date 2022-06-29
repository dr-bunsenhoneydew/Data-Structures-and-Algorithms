public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public void addNodeToFront(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            head.prev = null;
        }
        size++;
        System.out.println("Added " + data + " to front");
    }

    public void addNodeToBack(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.prev = null;
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
        size++;
        System.out.println("Added " + data + " to back");
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Index OOB");
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

        if (index == 0) {
            this.addNodeToFront(data);
            return;
        }

        else if (index == size) {
            this.addNodeToBack(data);
        }

        else {
            Node indexNode = head;
            
            while (index > 0) {
                indexNode = indexNode.next;
                index--;
            }

            Node newNode  = new Node(data);
            newNode.prev = indexNode.prev;
            indexNode.prev = newNode;
            newNode.prev.next = newNode;
            newNode.next = indexNode;
            size++; 
        }

    }

    public void removeByIndex(int index) {
        if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Index OOB");
		}
        if (head == null) {
            System.out.println("Empty List");
        }

        Node indexNode = head;

        if (index == 0) {
            head = head.next;

            if(head != null) {
                head.prev = null;
            }
        }

        else if (index == size - 1 && tail != null) {
            indexNode = find(size - 1);
            tail = tail.prev;
            

            if(tail != null) {
                tail.next = null;
            }
        }

        else {
            indexNode = find(index);
            indexNode.prev.next = indexNode.next;
            indexNode.next.prev = indexNode.prev;
        }

        size--;
        System.out.println("Removed Node " + indexNode.data + " at index " + index);
    }

    public void setByIndex(int index, int newData) {
        if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index OOB");
		}

        Node indexNode = find(index);
        indexNode.data = newData;
        System.out.println("Element at index " + index + " changed to " + indexNode.data);
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
        DoublyLinkedList myLL = new DoublyLinkedList();
        myLL.addNodeToFront(5);
        myLL.printLL();
        myLL.addNodeToBack(10);
        myLL.printLL();
        myLL.get(1);
        myLL.addNodeToIndex(2, 15);
        myLL.printLL();
        myLL.removeByIndex(0);
        myLL.printLL();
        myLL.setByIndex(1, 25);
        myLL.printLL();

    }
}
