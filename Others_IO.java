import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
  * @author:  Zhang
  * @description:
  *
  * 字节流的输入输出
 **/
public class Others_IO {
    public static void main(String[] args) throws IOException {
        String s="你好啊";
        System.out.println(s.getBytes().length);
        read(s.getBytes("GBK"));
        System.out.println(write(s));
        s=new String(write(s));
        System.out.println(s);
    }


    /**
      * @author:  Zhang
      * @description:
      *
      * 读取节点流
     **/
    public static String read(byte[] bytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        //注意此处字符长度，太短可能导致字符不全，需要统一编码
        byte[] car=new byte[4];
        int len=0;//车实际装货的长度
        String s="";
        while (-1!=(len=byteArrayInputStream.read(car))){
            s+=new String(car,0,len,"gbk");
        }
        System.out.println(s);
        return s;
    }

    public static byte[] write(String s) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes=s.getBytes();
        //写入数据
        byteArrayOutputStream.write(bytes);
        //获取数据
        return byteArrayOutputStream.toByteArray();
    }
}
