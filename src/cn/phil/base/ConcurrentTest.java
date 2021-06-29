package cn.phil.base;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " quiting");
    }
}

/**
 * @author Heping
 * @date 2019/10/29 16:05
 */
public class ConcurrentTest {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new MyThread("1"));
        pool.execute(new MyThread("a"));
        pool.execute(new MyThread("2"));
        pool.execute(new MyThread("b"));
        pool.shutdown();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        pool = new ThreadPoolExecutor(5, 200, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(256), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        System.out.println(df.get().format(new Date()));
    }
}
