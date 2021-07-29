package cn.phil.core.juc.ans1;

import cn.phil.core.juc.Account;
import cn.phil.core.juc.Constant;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author phil
 * @date 2021/7/14 9:15
 */
public class Work1 extends Thread {
    private List<ReentrantLock> locks;
    private List<Account> accounts;
    public Work1(List<ReentrantLock> locks, List<Account> accounts) {
        this.locks = locks;
        this.accounts = accounts;
    }
    @Override
    public void run() {
        int i = 0;
        while(i < Constant.THREAD_COUNT) {
            Random random = new Random();
            int idx1 = random.nextInt(Constant.ACCOUNT_COUNT);
            int idx2 = random.nextInt(Constant.ACCOUNT_COUNT);
            if(idx1 == idx2) {
                i ++;
                continue;
            }

            int val = new Random().nextInt(100);
            ReentrantLock lock2 = locks.get(idx2);
            try {
                lock2.lock();
                if(accounts.get(idx2).getBalance() - val < 0L) {
                    i ++;
                    continue;
                }
                accounts.get(idx2).setBalance(accounts.get(idx2).getBalance() - val);
            } finally {
                lock2.unlock();
            }

            ReentrantLock lock1 = locks.get(idx1);
            try {
                lock1.lock();
                accounts.get(idx1).setBalance(accounts.get(idx1).getBalance() + val);
            } finally {
                lock1.unlock();
            }
            i ++;
        }
    }
}
