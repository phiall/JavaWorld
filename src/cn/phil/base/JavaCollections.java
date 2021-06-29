package cn.phil.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Heping
 * @date 2019/10/28 21:10
 */
public class JavaCollections {
    public static void main(String[] args) {
        List<String> a = Collections.emptyList();
        //a.add("1");
        System.out.println(a);
        List<String> b = Collections.singletonList("1");
        //a.add("2");
        System.out.println(b);
        String[] c = new String[] {"1", "2", "3"};
        List<String> d = Arrays.asList(c);
        // d.add("4");
        System.out.println(d);
        List<String> e = new ArrayList<String>() {{
            add("1");add("2");add("3");
        }};
        List<String> f = e.subList(0, 1);
        e.remove(0);
        //f.add("4");
        Arrays.sort(c, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }
}
