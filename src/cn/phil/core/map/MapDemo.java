package cn.phil.core.map;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author px
 * @date 2021/5/12 18:34
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new LinkedHashMap<>();
        Map<String, Object> map3 = new TreeMap<>();
        Map<String, Object> map4 = new WeakHashMap<>();
        Map<Integer, Object> map5 = new ConcurrentHashMap<>();
        map5.put(1, 1);
        map5.put(2, 2);
        Iterator iterator = map5.entrySet().iterator();
        while (map5.entrySet().iterator().hasNext()) {

        }
    }
}
