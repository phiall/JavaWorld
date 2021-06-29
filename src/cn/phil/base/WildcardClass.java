package cn.phil.base;

/**
 * @author Heping
 * @date 2019/10/29 9:24
 */
class Wildcard<T> {
    private T v;

    public T getV() {
        return v;
    }

    public void setV(T v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Wildcard{" +
                "v=" + v +
                '}';
    }
}
public class WildcardClass {
    public static void main(String[] args) {
        Wildcard<String> a = new Wildcard<>();
        a.setV("ABC");
        Wildcard<Object> b = new Wildcard<Object>();
        //b.setV("abc");
        //print(a);
        print(b);
    }
//    private static void print(Wildcard w) {
//        System.out.println(w);
//    }
//    private static void print(Wildcard<?> w) {
//        System.out.println(w);
//    }
//    private static void print(Wildcard<Object> w) {
//        System.out.println(w);
//    }
//    private static void print(Wildcard<String> w) {
//        System.out.println(w);
//    }

    /**
     * 上限
     * @param w 只能是Number类型或其子类
     */
//    private static void print(Wildcard<? extends Number> w) {
//        System.out.println(w);
//    }

    /**
     * 下限
     * @param w 只能是Integer类型或其父类Number或Number的父类Object
     */
    private static void print(Wildcard<? super Integer> w) {
        System.out.println(w);
    }
}
