package cn.phil.core.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author px
 * @date 2021/3/8 18:44
 */
class Person {
    Long id;
    String name;
    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
public class ListDemo {
    public ListDemo() {

    }

    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person(1L, "abc"));
        System.out.println(list1.get(0).hashCode());
        List clone = (List)((ArrayList<Person>) list1).clone();
        System.out.println(clone.get(0).hashCode());
    }
}
