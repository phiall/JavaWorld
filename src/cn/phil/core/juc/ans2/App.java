package cn.phil.core.juc.ans2;

import cn.phil.core.juc.Account;
import cn.phil.core.juc.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 自建线程
 * @author phil
 * @date 2021/7/14 9:19
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        List<Account> accounts = new ArrayList<>(Constant.ACCOUNT_COUNT);
        for(int i = 0; i < Constant.ACCOUNT_COUNT; ++ i) {
            accounts.add(new Account((long) i, 10000L));
        }
        Bank bank = new Bank(accounts);
        List<Thread> threads = new ArrayList<>(Constant.THREAD_COUNT);
        for(int i = 0; i < Constant.THREAD_COUNT; ++ i) {
            Thread thread = new Thread(() -> {
                for(int j = 0; j < Constant.RUN_COUNT; ++ j) {
                    Random random = new Random();
                    bank.transfer(random.nextInt(Constant.ACCOUNT_COUNT),
                            random.nextInt(Constant.ACCOUNT_COUNT), random.nextInt(100));
                }
            });
            threads.add(thread);
            thread.start();
        }
        for(int i = 0; i < Constant.THREAD_COUNT; ++ i) {
            threads.get(i).join();
        }
        bank.show();
    }
}
