package cn.phil.base;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author p
 * @date 2019/10/21 17:17
 */
public class ArraryDateAndPattern {
    public static void main(String[] args) {
        Integer[] ages = new Integer[10];
        for (Integer i : ages) {
            i = new Random().nextInt();
        }
        for(Integer item : ages) {
            System.out.println(item);
        }
        for(int i = 0; i < ages.length; ++ i) {
            ages[i] = new Random().nextInt();
        }
        for(Integer item : ages) {
            System.out.println(item);
        }
        Arrays.sort(ages);
        for(Integer item : ages) {
            System.out.println(item);
        }
        Date[] dates = new Date[10];
        for(Date s : dates) {
            s = new Date();
        }
        for(Date s : dates) {
            System.out.println(s);
        }
    }
}
