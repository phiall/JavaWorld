package cn.phil.core.juc.ans1;

import cn.phil.core.juc.Account;
import cn.phil.core.juc.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * //评测题目: 无
 * // 1。 有二十个账户。每个账户初始余额10000元。
 * // 2。 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
 * // 3。 每个线程执行100次转账操作。
 * // 4。 最后请打印出二十个账户的余额
 * @author phil
 * @date 2021/7/14 9:15
 */
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