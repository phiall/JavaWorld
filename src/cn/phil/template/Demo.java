package cn.phil.template;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author px
 * @date 2021/3/4 17:13
 */
public class Demo implements Cloneable{
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>() {{
            add("abc");
        }};
        ArrayList<Integer> list2 = new ArrayList<Integer>() {{
            add(123);
        }};
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println(list1.getClass().getName());
        System.out.println(list2);
        List list = list1;

    }
    public void newObject() throws Exception {
        Class myClass = Class.forName("cn.phil.template.Demo");
        Demo demo = new Demo();
        Object c = demo.clone();
    }
}
