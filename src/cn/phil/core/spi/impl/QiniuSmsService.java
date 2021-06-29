package cn.phil.core.spi.impl;

import cn.phil.core.spi.SmsService;

/**
 * @author phil
 * @date 2021/6/2 15:04
 */
public class QiniuSmsService implements SmsService {
    public void sendSmsCode(String phone) {
        System.out.println("Qiniu Sms Service :" + phone);
    }
}
