package cn.phil.core.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author px
 * @date 2021/3/8 15:35
 */
public class UserServiceInvocationHandler implements InvocationHandler {
    private final Object target;
    public UserServiceInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
