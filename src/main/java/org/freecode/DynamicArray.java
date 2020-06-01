package org.freecode;


/**
 * @author JiWen
 * @time 2020/5/19 18:22
 */
public class DynamicArray<T> {
    private int size;
    private int capacity;
    private Object[] array;

    public DynamicArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity should be greater than 0.");
        this.size = 0;
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public DynamicArray() {
        this(16);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T elem) {
        if (elem == null) throw new NullPointerException("Element should not be null.");
        if (size < capacity) {
            array[size++] = elem;
        } else {
            capacity *= 2;
            if (capacity < 0) capacity = Integer.MAX_VALUE;
            Object[] newArray = new Object[capacity];

            System.arraycopy(array, 0, newArray, 0, size);

            newArray[size++] = elem;
            array = newArray;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index should be less than size.");
        }
        return (T) array[index];
    }

    public void set(T elem, int index) {
        if (elem == null) {
            throw new NullPointerException("Element should not be null.");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index should be less than size.");
        }
        array[index] = elem;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index should be less than size.");
        }
        Object result = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - (index + 1));
        }
        array[size - 1] = null;
        size--;
        return (T) result;
    }

    public boolean remove(T elem) {
        int index = indexOf(elem);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(T elem) {
        if (elem == null) return -1;
        for (int i = 0; i < size; i++) {
            if (elem.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }


    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb.toString();
    }
}
