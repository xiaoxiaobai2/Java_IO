import java.io.UnsupportedEncodingException;


/**
  * @author:  Zhang
  * @description:
  *
  * 编码和解码时字符集一定要统一，否则可能出现乱码
 **/
public class Code_decode {
    public static void main(String[] args) {
        String s="中国";
        byte[] chars=null;
        try {
            chars=s.getBytes("gbk");//添加编码方式
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(new String(chars,"gbk"));//添加解码方式，两者不统一则可能出现乱码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
