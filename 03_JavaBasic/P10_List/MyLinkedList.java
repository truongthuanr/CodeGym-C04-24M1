package P10_List;

import org.w3c.dom.Node;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;

    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node behindNode;
        for (int i=0; i<index-1 && temp.next != null; i++) {
            temp = temp.next;
        }

        behindNode = temp.next;
        temp.next = new Node(data);
        temp.next.next = behindNode;
        numNodes++;
    }


    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;

    }

    public Node get(int index) {
        Node temp = head;
        for (int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}
