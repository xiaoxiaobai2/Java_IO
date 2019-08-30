import java.io.*;

/**
  * @author:  Zhang
  * @description:
  *
  * 字节流 -- 程序 ---文件
 *  之间的相互转化
 *  通常外部计算机都是以字节流的形式传输数据
 **/
public class File_byte {
    public static void main(String[] args) throws IOException {
        //模拟外部计算机传入的数据
        String s="C:\\Users\\Administrator\\Desktop\\Test\\176.jpg";
        byte[] bytes=fileTobyte(s);

        String path="C:\\Users\\Administrator\\Desktop\\Test\\a.jpg";

//        System.out.println(new String(bytes));
        bytesToFile(bytes,path);
    }


    /**
      * @author:  Zhang
      * @description:
      *
      * 把文件输入到程序，之后输出成字节流
     **/
    public static byte[] fileTobyte(String path) throws IOException {
        InputStream is=new BufferedInputStream(new FileInputStream(path));
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] bytes;
        byte[] car=new byte[1024];
        int len=0;//实际车长
        while (-1!=(len=is.read(car,0,1024))){
            byteArrayOutputStream.write(car,0,len);
        }
        bytes=byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        is.close();
        byteArrayOutputStream.close();
        return bytes;
    }


    /**
      * @author:  Zhang
      * @description:
      *
      * 把字节流输入到程序，再转存到文件
     **/
    public static void bytesToFile(byte[] bytes,String path) throws IOException {
        InputStream is=new BufferedInputStream(new ByteArrayInputStream(bytes));
        OutputStream os=new BufferedOutputStream(new FileOutputStream(path));
        byte[] car=new byte[1024];
        int len=0;
        while (-1!=(len=is.read(car,0,1024))){
            os.write(car,0,len);
        }
        os.flush();
        is.close();
        os.close();
    }
}
