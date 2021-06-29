package cn.phil.core.spi;

import java.util.ServiceLoader;

/**
 * @author phil
 * @date 2021/6/2 15:06
 */
public class SpiTest {
    public static void main(String[] args) {
        ServiceLoader<SmsService> smsServices = ServiceLoader.load(SmsService.class);
        for (SmsService smsService : smsServices) {
            smsService.sendSmsCode("132****2212");
        }
    }

}
