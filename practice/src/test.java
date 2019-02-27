import org.apache.hadoop.hbase.util.Bytes;

import java.io.UnsupportedEncodingException;

/**
 * @Author ChenXiang
 * @Date 2018/09/26,10:52
 */
public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //bytes[]的转换
        System.out.println(Bytes.toString("\\x00\\x00\\x00\\x00\\x00eu\\xA4".getBytes()));
        System.out.println("1\n2");
    }
}
