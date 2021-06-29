package cn.phil.core;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heping
 * @date 2019/11/25 9:23
 */
public class Demo {
    public static void main(String[] args) {
        String str = "庚子(鼠)年二月十四";
        String arr[] = str.split("年|月|\\(|\\)");
        for(String a : arr) {
            System.out.println(a);
        }
        {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 100; i++) {
                set.add(i);
                set.remove(i - 1);
            }

            System.out.println(set.size());
        }
        {
            Set<Short> set = new HashSet<>();
            for (short i = 0; i < 100; i++) {
                set.add(i);
                set.remove((short)(i-1));
            }
            System.out.println(set.size());
        }
        Object i = 1 == 1 ? new Integer(3) : new Float(1);
        System.out.println(i);
    }
}
