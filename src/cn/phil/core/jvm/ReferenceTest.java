package cn.phil.core.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author px
 * @date 2021/3/12 18:26
 */
public class ReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        Map<Object, Object> map = new HashMap<>();
        for(int i = 0; i < 10000000; ++ i) {
            byte[] cache = new byte[1024*1024*1024 * 1000];
            WeakReference<byte[]> key = new WeakReference<>(cache, queue);
            map.put(key, 1);
        }

        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<byte[]> k;
                while((k = (WeakReference) queue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch(InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();
        thread.join();
    }
}
