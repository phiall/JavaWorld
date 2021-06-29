package cn.phil.core.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * map转实体
 * 实体转map
 * @author px
 * @date 2021/4/16 15:33
 */
public class ReflectTest {
    private static class User {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    private static User map2User(Map<String, Object> map) throws IllegalAccessException {
        User user = new User();
        Class clazz = user.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(user, map.get(field.getName()));
        }
        return user;
    }
    private static Map<String, Object> user2Map(User user) throws IllegalAccessException {
        Map<String, Object> ret = new HashMap<>();
        if(user == null) {
            return null;
        }
        Class clazz = user.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            ret.put(field.getName(), field.get(user));
        }
        return ret;
    }
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setId(1L);
        user.setName("Jack");
        Map map = user2Map(user);
        System.out.println(map);
        System.out.println(map2User(map));
    }
}
