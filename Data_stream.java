import java.io.*;

public class Data_stream {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\Test\\data.txt";
        save_data(path);
        get_data(path);
    }

    public static void save_data(String path) throws IOException {
        double x=1.0;
        int y=10;
        int z=100;
        String s="Hello,world!";
        DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream(path));
        dataOutputStream.writeInt(y);
        dataOutputStream.writeInt(z);
        dataOutputStream.writeDouble(x);
        dataOutputStream.writeUTF(s);
        dataOutputStream.writeBytes(s);
        dataOutputStream.flush();
        dataOutputStream.close();
    }


    /**
      * @author:  Zhang
      * @description:
      *
      * 读取Data数据文件
     *          注意读取时要按写入时的顺序读取
     **/
    public static void get_data(String path) throws IOException {
        DataInputStream dataInputStream=new DataInputStream(new FileInputStream(path));
        //注意按顺序读取！！！！
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readUTF());
        System.out.println(new String(dataInputStream.readAllBytes()));
        dataInputStream.close();
    }
}
