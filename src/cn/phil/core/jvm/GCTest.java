package cn.phil.core.jvm;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;

/**
 * @author px
 * @date 2021/3/12 14:00
 */
public class GCTest {
    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("20210312150708000001834881");
        System.out.println(value);
        Reference<BigDecimal> ref = new SoftReference<>(value);
        System.out.println(ref.get());
    }
}
