package cn.phil.core.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author px
 * @date 2021/3/8 16:21
 */
public class OrderCglibProxyFactory {
    public static Object getProxy(Class<?> clz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clz.getClassLoader());
        enhancer.setCallback(new OrderMethodInterceptor());
        enhancer.setSuperclass(clz);
        return enhancer.create();
    }

    public static void main(String[] args) {
        OrderService orderService = (OrderService) OrderCglibProxyFactory.getProxy(OrderService.class);
        orderService.save("{id=1, number=123456}");
    }
}
