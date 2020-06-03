package org.freecode;

public class Queue<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }


    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty.");
        return head.data;
    }

    public void enqueue(T data) {
        if (isEmpty()) {
            head = tail = new Node<T>(data, null, null);
        } else {
            tail.next = new Node<T>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is Empty.");
        T data = head.data;
        if (size == 1) {
            head.data = tail.data = null;
            head = tail = null;
        } else {
            Node<T> next = head.next;
            head.data = null;
            head.next = null;
            head = next;
        }
        size--;
        return data;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<T> p = head;
        while (p.next != null) {
            sb.append(p.data).append(", ");
            p = p.next;
        }
        sb.append(p.data).append("]");
        return sb.toString();
    }

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

}
