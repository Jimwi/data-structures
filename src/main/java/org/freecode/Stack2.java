package org.freecode;


/**
 * @author JiWen
 * @time 2020/5/20 17:37
 */
public class Stack2<T> {
    private LinkedList<T> list = new LinkedList<T>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void push(T elem){
        list.addFirst(elem);
    }

    public T pop(){
        return list.removeFirst();
    }

    public T peek(){
        return list.peekFirst();
    }
}
