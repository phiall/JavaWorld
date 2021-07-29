package cn.phil.core.juc.ans2;

import cn.phil.core.juc.Account;
import cn.phil.core.juc.Constant;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用线程池
 * @author phil
 * @date 2021/7/14 9:19
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {
        List<Account> accounts = new ArrayList<>(Constant.ACCOUNT_COUNT);
        for(int i = 0; i < Constant.ACCOUNT_COUNT; ++ i) {
            accounts.add(new Account((long) i, 10000L));
        }
        Bank bank = new Bank(accounts);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("work").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10), namedThreadFactory);
        for(int i = 0; i < Constant.THREAD_COUNT; ++ i) {
            executor.execute(() -> {
                Random random = new Random();
                bank.transfer(random.nextInt(Constant.ACCOUNT_COUNT),
                        random.nextInt(Constant.ACCOUNT_COUNT), random.nextInt(100));
            });
        }
        executor.shutdown();
        bank.show();
    }
}
