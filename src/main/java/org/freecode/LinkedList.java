package org.freecode;


/**
 * @author JiWen
 * @time 2020/5/20 14:37
 */
public class LinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addFirst(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            head.prev = new Node<T>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list.");
        T data = head.data;
        if (size() == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public void addLast(T elem) {
        if (isEmpty()) {
            head = tail = new Node<T>(elem, null, null);
        } else {
            tail.next = new Node<T>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty list.");
        T data = tail.data;
        if (size() == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }


    public void add(T elem) {
        addLast(elem);
    }

    public boolean remove(T elem) {
        if (isEmpty()) return false;
        Node<T> p = head;
        while (p != null) {
            if (p.data.equals(elem)) {
                remove(p);
                return true;
            }
            p = p.next;
        }
        return false;
    }

    private T remove(Node<T> node) {
        if (node == head) {
            return  removeFirst();
        }
        if (node == tail) {
            return removeLast();
        }
        T data = node.data;
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = node.next = null;
        size--;
        return data;
    }

    public void clear() {
        Node<T> p = head;
        Node<T> next;
        while (p != null) {
            next = p.next;
            p.data = null;
            p.prev = p.next = null;
            p = next;
        }
        size = 0;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty list.");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty list.");
        return tail.data;
    }

    public void insert(T elem, int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Index should be 0 <= index <= size");
        if (index == 0){
            addFirst(elem);
            return;
        }
        if (index == size){
            addLast(elem);
            return;
        }

        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node<T> prev = p.prev;

        Node<T> node = new Node<T>(elem, prev, p);
        prev.next = node;
        p.prev = node;
        size++;
    }

    public T removeAt(int index) {
        if (isEmpty()) throw new RuntimeException("Empty list.");
        if (index < 0 || index >= size) throw new IllegalArgumentException("Index should be 0 <= index < size.");

        Node<T> p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return remove(p);
    }

    public int indexOf(T elem) {
        if (isEmpty()) return -1;
        Node<T> p = head;
        int i = 0;
        while (p != null) {
            if (p.data.equals(elem)) {
                return i;
            }
            i++;
            p = p.next;
        }
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> p = head;
        while (p.next != null) {
            sb.append(p.data).append(", ");
            p = p.next;
        }
        sb.append(p.data).append("]");
        return sb.toString();
    }
}
