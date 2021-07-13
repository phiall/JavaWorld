package cn.phil.ans1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

//评测题目: 无
// 1。 有二十个账户。每个账户初始余额10000元。
// 2。 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
// 3。 每个线程执行100次转账操作。
// 4。 最后请打印出二十个账户的余额
interface Constant {
    int ACCOUNT_COUNT = 20;
    int THREAD_COUNT = 10;
    int RUN_COUNT = 100;
}
class Account {
    private Long id;
    private Long balance;
    public Account(Long id, Long balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}

/**
 * 一
 */
class Work1 extends Thread {
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
            int idx1 = new Random().nextInt(Constant.ACCOUNT_COUNT);
            int idx2 = new Random().nextInt(Constant.ACCOUNT_COUNT);
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

/**
 * 二
 */
class Work2 extends Thread {
    private List<ReentrantLock> locks;
    private List<Account> accounts;
    public Work2(List<ReentrantLock> locks, List<Account> accounts) {
        this.locks = locks;
        this.accounts = accounts;
    }
    @Override
    public void run() {
        int i = 0;
        while(i < Constant.THREAD_COUNT) {
            int idx1 = new Random().nextInt(Constant.ACCOUNT_COUNT);
            int idx2 = new Random().nextInt(Constant.ACCOUNT_COUNT);
            if(idx1 == idx2) {
                i ++;
                continue;
            }
            if(idx1 > idx2) {
                int tmp = idx1;
                idx1 = idx2;
                idx2 = tmp;
            }
            int val = new Random().nextInt(100);
            //保证加锁顺序，避免死锁产生
            ReentrantLock lock1 = locks.get(idx1);
            ReentrantLock lock2 = locks.get(idx2);
            try {
                lock1.lock();
                lock2.lock();
                if(accounts.get(idx2).getBalance() - val < 0L) {
                    i ++;
                    continue;
                }
                accounts.get(idx1).setBalance(accounts.get(idx1).getBalance() + val);
                accounts.get(idx2).setBalance(accounts.get(idx2).getBalance() - val);
            } finally {
                lock2.unlock();
                lock1.unlock();
            }
            i ++;
        }
    }
}
public class App {
    public static void main(String[] args) throws InterruptedException {
        List<Account> accounts = new ArrayList<>(Constant.ACCOUNT_COUNT);
        for(int i = 0; i < Constant.ACCOUNT_COUNT; ++ i) {
            accounts.add(new Account((long) i, 10000L));
        }
        List<ReentrantLock> locks = new ArrayList<>(Constant.ACCOUNT_COUNT);
        for(int i = 0; i < Constant.ACCOUNT_COUNT; ++ i) {
            locks.add(new ReentrantLock());
        }
        List<Work2> works = new ArrayList<>();
        for(int i = 0; i < Constant.THREAD_COUNT; ++ i) {
            Work2 work = new Work2(locks, accounts);
            work.start();
            works.add(work);
        }
        for(int i = 0; i < Constant.THREAD_COUNT; ++ i) {
            works.get(i).join();
        }
        Long total = 0L;
        for(int i = 0; i < Constant.ACCOUNT_COUNT; ++ i) {
            Long balance = accounts.get(i).getBalance();
            total += balance;
            System.out.println(balance);
        }
        System.out.println(total);
    }
}