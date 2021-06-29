package cn.phil.core.set;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author phil
 * @date 2021/6/3 10:55
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new TreeSet<>();
        Set<Integer> set3 = new LinkedHashSet<>();
        Set<Integer> set4 = new CopyOnWriteArraySet<>();
        int count = 100000;
        long start = System.currentTimeMillis();
        for(int i = 0; i < count; i ++) {
            set1.add(i);
        }
        System.out.println("Hash Set Add: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for(int i = 0; i < count; i ++) {
            set2.add(i);
        }
        System.out.println("Tree Set Add: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for(int i = 0; i < count; i ++) {
            set3.add(i);
        }
        System.out.println("Linked Hash Set Add: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for(int i = 0; i < count; i ++) {
            set4.add(i);
        }

    }
}
