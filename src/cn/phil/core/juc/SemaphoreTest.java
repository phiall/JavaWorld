package cn.phil.core.juc;

import java.util.concurrent.Semaphore;

/**
 * @author px
 * @date 2021/3/11 9:07
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
    }
}
