import java.io.*;

public class Byte_IOstrem {
    /**
      * @author:  Zhang
      * @description:
      *
      * 以字节流的形式读取文件
     *  以字节流的形式输出文件
     **/
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\Test\\hello.txt");
        readFile(file);
        writeFile(file);
        readFile(file);
    }
    /**
      * @author:  Zhang
      * @description:
      *
      * 利用FileInputStream读取文件
     *              需要一个缓存区，类似于搬家的车 byte[] car
     *
     **/
    public static void readFile(File file){
        InputStream inputStream=null;//提升作用域
        try {
            inputStream=new FileInputStream(file);
            byte[] car=new byte[10];  //运输车，缓冲区
            int len=0;//实际长
            while (-1!=(len=inputStream.read(car))){
                String s=new String(car,0,len);
                System.out.println(s);
            }
            //一次性输出所有
//            car=inputStream.readAllBytes();
//            String s=new String(car,0,car.length);
//            System.out.println(s);

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        } finally {
            if (inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("关闭失败！");
                    e.printStackTrace();
                }
        }
    }

    /**
      * @author:  Zhang
      * @description:
      *
      * 利用OutputStream写入文件
      *             需要一个缓存区，类似于搬家的车 byte[] car
     **/
    public static void writeFile(File file){
        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file,true);//append 为追加还是覆盖   true追加，false覆盖
            String s="--java";
            byte[] bytes=s.getBytes();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();//手动刷新
        } catch (FileNotFoundException e) {
            System.out.println("文件打开失败！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件写入失败！");
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            }
        }
    }
}
