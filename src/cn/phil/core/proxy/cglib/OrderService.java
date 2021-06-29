package cn.phil.core.proxy.cglib;

/**
 * @author px
 * @date 2021/3/8 16:18
 */
public class OrderService {
    public void save(String order) {
        System.out.println("saved " + order);
    }
}
