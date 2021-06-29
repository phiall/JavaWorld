package cn.phil.core.spi;

/**
 * @author phil
 * @date 2021/6/2 15:01
 */
public interface SmsService {
    /**
     * 发送短信验证码
     * @param phone
     */
    void sendSmsCode(String phone);
}
