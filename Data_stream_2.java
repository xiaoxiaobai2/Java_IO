import java.io.*;

/**
  * @author:  Zhang
  * @description:
  *
  * 将数据以字节流的形式存储   或以字节流的形式读取数据
 **/
public class Data_stream_2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\Test\\data.txt";
        byte[] bytes=save_data();
        System.out.println(bytes.length);
        get_data(bytes);
    }

    /**
      * @author:  Zhang
      * @description:
      *
      * 把数据资源输入到字节流
     **/
    public static byte[] save_data() throws IOException {
        double x=1.0;
        int y=10;
        int z=100;
        String s="Hello,world!";
        byte[] bytes;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(new BufferedOutputStream(bos));

        dataOutputStream.writeInt(y);
        dataOutputStream.writeInt(z);
        dataOutputStream.writeDouble(x);
        dataOutputStream.writeUTF(s);
        dataOutputStream.writeBytes(s);

        dataOutputStream.flush();//注意写完数据一定要先从管道推出去
        bytes=bos.toByteArray();
        dataOutputStream.close();
        bos.close();
        return bytes;
    }


    /**
     * @author:  Zhang
     * @description:
     *
     * 从字节流 读取Data数据文件
     *          注意读取时要按写入时的顺序读取
     **/
    public static void get_data(byte[] bytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        DataInputStream dataInputStream=new DataInputStream(new BufferedInputStream(byteArrayInputStream));
        //注意按顺序读取！！！！
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readUTF());
        System.out.println(new String(dataInputStream.readAllBytes()));
        dataInputStream.close();
    }
}
