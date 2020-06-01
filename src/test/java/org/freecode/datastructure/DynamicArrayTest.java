package org.freecode.datastructure;


import org.freecode.DynamicArray;
import org.junit.Test;

import java.util.Random;

/**
 * @author JiWen
 * @time 2020/5/19 20:07
 */
public class DynamicArrayTest {
    @Test
    public void Test1() {
        DynamicArray<Integer> array = new DynamicArray<Integer>(2);
        array.add(1);
        array.add(2);
        System.out.println(array);
        array.add(3);
        System.out.println(array);

        array.removeAt(1);
        System.out.println(array);

        array.remove(1);
        System.out.println(array);
        System.out.println(array.get(0));

        System.out.println(array.indexOf(5));
        System.out.println(array.indexOf(3));
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            array.add(random.nextInt(100));
            System.out.println(array);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(array.contains(80));
    }
}
