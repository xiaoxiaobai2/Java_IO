import java.io.*;

public class Char_IOstream {
    public static void main(String[] args) {
        String s="C:\\Users\\Administrator\\Desktop\\Test\\码农真苦.txt";
        char_write(s);
        char_read(s);
    }


    /**
      * @author:  Zhang
      * @description:
      *
      * 以字符形式读取文件内容
     **/
    public static void char_read(String path){
        File file=new File(path);
//        if (!file.exists()){
//            System.out.println("文件不存在，请查证!");
//        }else if (!file.isFile()){
//            System.out.println("不是文件，请查证!");
//        }else {
        Reader reader=null;
        try {
            reader=new FileReader(file);
            char[] chars=new char[100];
            while(-1!=reader.read(chars,0,100)) {
                String s=new String(chars,0,chars.length);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
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
     * 以字符形式写入文件内容
     **/
    public static void char_write(String path){
        File file=new File(path);
        Writer writer=null;
        try {
            writer=new FileWriter(file);
            String s="锄禾日当午，\r\n码农真辛苦，\r\n一本小破书，\r\n一读一上午。\r\n";
            writer.write(s);
            writer.flush();
        } catch (IOException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("关闭文件失败！");
                e.printStackTrace();
            }
        }
    }
}

