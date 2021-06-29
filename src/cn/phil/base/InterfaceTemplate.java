package cn.phil.base;


/**
 * @author Heping
 * @date 2019/11/8 16:13
 */
interface IRequestParser<T> {
    public T parser(String input);
}
class IntegerRequestParser implements IRequestParser<Integer> {
    @Override
    public Integer parser(String input) {
        return Integer.parseInt(input);
    }
}
class DoubleRequestParser implements IRequestParser<Double> {
    @Override
    public Double parser(String input) {
        return Double.parseDouble(input);
    }
}
public class InterfaceTemplate {
    public static void main(String[] args) {
        IRequestParser<Integer> parser = new IntegerRequestParser();
        System.out.println(parser.parser("123"));
        IRequestParser<Double> parser1 = new DoubleRequestParser();
        System.out.println(parser1.parser("100.01"));
        String arr[] = "a|b".split("\\|");
        for(String i : arr) {
            System.out.println(i);
        }
    }
}
