package cn.phil.core.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author px
 * @date 2021/3/8 15:37
 */
public class UserServiceJdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new UserServiceInvocationHandler(target));
    }

    public static void main(String[] args) {
        UserService userService = (UserService) UserServiceJdkProxyFactory.getProxy(new UserServiceImpl());
        System.out.println(userService.getUser(1L));
    }
}
