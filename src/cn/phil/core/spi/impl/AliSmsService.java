package cn.phil.core.spi.impl;

import cn.phil.core.spi.SmsService;

/**
 * @author phil
 * @date 2021/6/2 15:03
 */
public class AliSmsService implements SmsService {
    public void sendSmsCode(String phone) {
        System.out.println("Ali Sms Service :" + phone);
    }
}
