package cn.phil.base;

/**
 * @author px
 * @date 2021/3/17 13:49
 */
interface MyInterface {
    static void doSomething() {
        System.out.println("static do");
    }
}
public class InterfaceTest {
    public static void main(String[] args) {
        MyInterface.doSomething();
    }
}
