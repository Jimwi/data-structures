package org.freecode;


/**
 * @author JiWen
 * @time 2020/5/20 17:26
 */
public class Stack<T> {

    private int size = 0;
    private Node<T> top = null;

    public void push(T elem) {
        if (isEmpty()) {
            top = new Node<T>(elem, null);
        } else {
            top = new Node<T>(elem, top);
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");
        T data = top.data;
        if (size() == 1) {
            top = null;
        } else {
            Node<T> next = top.next;
            top.next = null;
            top.data = null;
            top = next;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty.");
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
