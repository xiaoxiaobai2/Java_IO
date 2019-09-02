import java.io.*;
import java.util.Scanner;

public class Sys_demo {
    public static void main(String[] args) throws FileNotFoundException {
//        test01();
//        test02();
//        test03();
        test04();
    }
    /**
      * @author:  Zhang
      * @description:
      *
      * 测试输入流和输出流
     **/
    public static void test01(){
        PrintStream printStream=System.out;
        String s="hello";
        //向输出流中添加内容
        printStream.append(s);
        printStream.append(s);
        printStream.append(s);
        printStream.append(s);
        printStream.println();

        InputStream inputStream=System.in;
        Scanner scanner=new Scanner(inputStream);
        System.out.println(scanner.nextInt());

    }
    /**
      * @author:  Zhang
      * @description:
      *
      * 输出到文件 或者从文件输入
     **/
    public static void test02() throws FileNotFoundException {
        String path="C:\\Users\\Administrator\\Desktop\\Test\\print.txt";
        PrintStream ps=new PrintStream(new BufferedOutputStream(new FileOutputStream(path)),true);
        ps.println("hello.");
        ps.println("i m fine ");
        ps.println("3Q U");
        ps.close();
        InputStream is=System.in;
        is=new BufferedInputStream(new FileInputStream(path));
        Scanner scanner=new Scanner(is);


    }
    /**
      * @author:  Zhang
      * @description:
      *
      * 重定位, 修改默认输出位置和输入位置。
     **/
    public static void test03() throws FileNotFoundException {
        String path="C:\\Users\\Administrator\\Desktop\\Test\\print.txt";
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(path,true)),true));
        System.out.println(123456);
    }
    /**
      * @author:  Zhang
      * @description:
      *
      * 重定位，改变弄人输入为指定文件。
     **/
    public static void test04() throws FileNotFoundException {
        String path="C:\\Users\\Administrator\\Desktop\\Test\\print.txt";
        System.setIn(new BufferedInputStream(new FileInputStream(path)));
        //修改重定位  回去
//        System.setIn(new BufferedInputStream(new FileInputStream(FileDescriptor.in)));
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
