package cn.coderglenn.datastructure.linked_list;

/**
 * @author Glenn.Zheng
 * @date 2018/8/15 10:56
 */
public class LinkedList<E> {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size ++;
    }

    // add element at specific position
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Illegal argument.");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i ++) {
                prev = prev.next;
            }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);

            size ++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    // get element by specific index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add failed. Illegal argument.");
        }

        Node current = head;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // update the value for specific node
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.");
        }

        Node current = head;
        for (int i = 0; i < index; i ++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = head;
        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // remove node for specific inde
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed.");
        }
        Node prev = head;
        if (index == 0) {
            head = prev.next;
            prev.next = null;
            size --;
            return prev.e;
        }
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//        Node current = head;
//        while (current != null) {
//            builder.append(current + "->");
//            current = current.next;
//        }
        for (Node current = head; current != null; current = current.next) {
            builder.append(current + "->");
        }
        builder.append("NULL");
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
