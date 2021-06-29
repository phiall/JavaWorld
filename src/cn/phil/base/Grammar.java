package cn.phil.base;

/**
 * Java 基本语法
 * @author p
 * @date 2019/10/18 10:03
 */
public class Grammar extends AbstractGrammar implements GrammarInterface {
    /**
     * Java基本类型与访问控制
     */
    private int a;
    protected float b;
    public double c;
    byte d;
    private byte e;
    private short f;
    private long g;
    protected char h;
    public boolean i;
    public Grammar() {
        super();
    }

    public Grammar(int a, byte d, byte e, short f, long g) {
        this.a = a;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }

    public static void main(String[] args) {
        Grammar grammar = new Grammar(1, (byte)2, (byte)3, (short)4, 5L);
        grammar.b = 0.3f;
        grammar.c = 0.5;
        grammar.h = 'c';
        grammar.i = false;
        assert grammar.i;
        // try catch finally
        try {
            grammar.a /= 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            grammar.a = 10;
        }
        System.out.println(grammar);
        // 控制语句
        if(grammar.i) {
            System.out.println("grammar.i=" + grammar.i);
        } else {
            System.out.println("grammar.i=" + grammar.i);
        }
        switch (grammar.h) {
            case 'a':
                System.out.println('a');
                break;
            case 'c':
                System.out.println('b');
                break;
            default:
                break;
        }
        for(int i = 0; i < 10; ++ i) {
            grammar.h += i;
            System.out.println(grammar.h);
        }
        // 运算符
        if(grammar instanceof AbstractGrammar) {
            System.out.println("grammar is a instance of AbstractGrammar");
        }
        grammar.a = 18 + 3 - 15 / 3 % 2 + grammar.a ++ + ++ grammar.a;
        // grammar.a = 42
        System.out.println(grammar.a);
        grammar.i = grammar.a > 40 && grammar.a >= 42 && grammar.a < 52
                || grammar.a <= 52 && grammar.a != 3;
        // grammar.i = true
        System.out.println(grammar.i);
        grammar.a = -15;
        System.out.println(Integer.toBinaryString(grammar.a));
        // 在补码的基础上做位置操作
        grammar.a = grammar.a & 4 | 3;
        System.out.println(grammar.a);
        grammar.a = -15;
        // -4
        System.out.println(grammar.a >> 2);
        // 0b00111111111111111111111111111100
        System.out.println(grammar.a >>> 2);
        // -60
        System.out.println(grammar.a << 2);
    }

    @Override
    void doNothing() {
        System.out.println("do nothing");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public String toString() {
        return "Grammar{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                ", i=" + i +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public byte getE() {
        return e;
    }

    public void setE(byte e) {
        this.e = e;
    }

    public short getF() {
        return f;
    }

    public void setF(short f) {
        this.f = f;
    }
}

/**
 * 抽象类定义
 */
abstract class AbstractGrammar {
    void doSomething() {
        System.out.println("abstract do something");
    }

    /**
     * 抽象方法
     */
    abstract void doNothing();
}
/**
 * 接口定义
 */
interface GrammarInterface {
    /**
     * 接口方法
     */
    void sayHello();
}
