package cn.phil.core;
/**
 *
 */
// 异常类分两大类型：Error类代表了编译和系统的错误，不允许捕获；
// Exception类代表了标准Java库方法所激发的异常。
// Exception类还包含运行异常类Runtime_Exception
// 和非运行异常类Non_RuntimeException这两个直接的子类
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author Heping
 * @date 2019/11/25 9:26
 */
public class ExceptionTest {
    public static void main(String[] args) {
        String fileName = null;
        //Objects.requireNonNull(fileName);
        try (
            FileInputStream in = new FileInputStream(fileName);
        ) {
            System.out.println(in.read());
        } catch (FileNotFoundException e1) {
            System.out.println("文件不存在");
        } catch (IOException e2) {
            System.out.println("读取出错");
        }
    }
}
