package cn.phil.core.volatiled;

import java.util.concurrent.*;

/**
 * @author px
 * @date 2021/3/10 10:56
 */
public class VolatileTest {
    int i = 0;
    boolean flag = false;
    public void write() {
        i = 2;
        flag = true;
    }
    public void read() {
        if(flag) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        ExecutorService executorService = new ThreadPoolExecutor(5, 100, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }
}
