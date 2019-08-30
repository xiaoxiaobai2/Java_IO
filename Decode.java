import java.io.*;


/**
  * @author:  Zhang
  * @description:
  *
 * BufferReader
  * 只能处理纯文本
 **/
public class Decode {
    public static void main(String[] args) {
        String path="C:\\Users\\Administrator\\Desktop\\Test\\码农真苦.txt";
        String path2="C:\\Users\\Administrator\\Desktop\\Test\\new.txt";

        File file=new File(path);
        File file2=new File(path2);
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            br=new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file),"unicode"
                    )
            );
            //编码解码一致就不会出现乱码，此处以正确读取内容，再用在其他的方式编码，不会出现乱码，
            // 但下次解码时要和此次编码字符集一致
            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2),"utf-8"));
            String s="";
            //readline按行读取，读完时返回空，每调用一次就读一行
            while ((s=br.readLine())!=null){
                System.out.println(s);
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            }
        }
    }
}
