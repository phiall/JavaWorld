package cn.phil.base;

/**
 * @author Heping
 * @date 2019/10/29 17:08
 */
public class ControlTest {
    public static void main(String[] args) {
        String s = "";
        switch (s) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("other");
                break;
        }
        System.out.println(tryCatchFinallyTest());
        Boolean flag = new Boolean("true");
    }
    private static void need2Fix() {
        // FIXME: He ping, 2019/10/29, 2019/11/01
    }
    private static void need2Do() {
        // TODO: He ping, 2019/10/29, 2019/11/01

    }
    private static int tryCatchFinallyTest() {
        int ret = 0;
        try {
            ret = 2;
            return ret;
        } catch (Exception e) {
            ret = 1;
            return ret;
        } finally {
            ret = 3;
            return ret;
        }
    }
}
