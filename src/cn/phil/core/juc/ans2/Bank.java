package cn.phil.core.juc.ans2;

import cn.phil.core.juc.Account;

import java.util.List;

/**
 * @author phil
 * @date 2021/7/14 9:21
 */
public class Bank {
    private List<Account> accounts;
    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }
    public synchronized void transfer(int from, int to, long val) {
        if(from == to || accounts.get(from).getBalance() - val < 0L) {
            return;
        }
        accounts.get(from).setBalance(accounts.get(from).getBalance() - val);
        accounts.get(to).setBalance(accounts.get(to).getBalance() + val);
    }

    public synchronized void show() {
        long total = 0L;
        for (Account v : accounts) {
            System.out.println(v.getId() + " " + v.getBalance());
            total += v.getBalance();
        }
        System.out.println("total:" + total);
    }
}
