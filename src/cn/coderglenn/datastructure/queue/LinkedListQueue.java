package cn.coderglenn.datastructure.queue;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 15:42
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // enQueue from tail
    @Override
    public void enQueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    // deQueue from head
    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        Node result = head;
        head = head.next;
        result.next = null;
        if (head == null) {
            // queue have only one element
            tail = null;
        }
        size --;
        return result.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue: front ");

        Node current = head;
        while (current != null) {
            builder.append(current + "->");
            current = current.next;
        }
        builder.append("NULL tail");
        return builder.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
