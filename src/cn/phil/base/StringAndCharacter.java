package cn.phil.base;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符与字符串相关 Character String StringBuffer StringBuilder
 * @author p
 * @date 2019/10/18 13:40
 */
public class StringAndCharacter {
    public static void main(String[] args) throws Exception {
        String s = "Ab3cD%";
        for(Character character : s.toCharArray()) {
            if(Character.isAlphabetic(character)) {
                System.out.println(Character.toString(character) + " is an alphabet");
            }
        }
        char i = 65;
        int j = 65;
        System.out.println(s + i);
        System.out.println(s + j);
        s = "Hello, this is a string";
        System.out.println(s.length());
        System.out.println(s.charAt(3));
        System.out.println(s.substring(3));
        System.out.println(s.substring(3, 5));
        System.out.println(s.concat("!"));
        byte[] arr = s.getBytes("UTF-8");
        char[] carr = s.toCharArray();
        System.out.println(arr.length);
        System.out.println(String.copyValueOf(carr));
        System.out.println(String.copyValueOf(carr, 3, 3));
        System.out.println(String.format("%s %d", s, 3));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        stringBuffer.append(3);
        System.out.println(stringBuffer);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(2);
        System.out.println(stringBuilder);

        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = new String(s1);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        String[] arrStr = "a,b,c,,".split(",");
        System.out.println(arrStr.length);
        String ws = null;
        System.out.println("ws"+ws);
        ws = "";
        System.out.println("ws"+ws);
        String targetStr = "A=bt=(xxx|yyy)333aa33";
        String regex ="([|,]?)(\\w+)(=bt=)\\(\\w+\\|\\w+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(targetStr);
        if(matcher.find()) {
            System.out.println("find" + matcher.group(0));
        }

        String t0 = "helloworld";
        String t1 = new String("helloworld");
        System.out.println(t0==t1);
        t0 = "a";
        t1 = "b";
        String t2 = t0 + t1;
        String t3 = "ab";
        System.out.println(t2==t3);

    }
}
