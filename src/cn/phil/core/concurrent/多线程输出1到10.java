package cn.phil.core.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author px
 * @date 2021/4/16 15:49
 */
public class 多线程输出1到10 {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 11) {
                    try {
                        lock.lock();
                        count++;
                        System.out.println("thread 1 do " + count);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 11) {
                    try {
                        lock.lock();
                        count++;
                        System.out.println("thread 2 do " + count);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
