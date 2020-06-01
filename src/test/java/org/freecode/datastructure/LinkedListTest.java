package org.freecode.datastructure;


import org.freecode.LinkedList;
import org.junit.Test;

import java.util.Random;

/**
 * @author JiWen
 * @time 2020/5/20 16:55
 */
public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        System.out.println(list.size());

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(100));
            System.out.println(list.size() + " " + list);
        }

        list.removeLast();
        System.out.println(list.size() + " " + list);
        list.removeLast();
        System.out.println(list.size() + " " + list);
        list.remove(40);
        System.out.println(list.size() + " " + list);
        list.removeAt(0);
        System.out.println(list.size() + " " + list);
        list.removeAt(list.size()-1);
        System.out.println(list.size() + " " + list);

        list.insert(100,10);
        System.out.println(list.size() + " " + list);

        list.insert(100,0);
        System.out.println(list.size() + " " + list);

        list.insert(100,list.size()-1);
        System.out.println(list.size() + " " + list);
    }
}
