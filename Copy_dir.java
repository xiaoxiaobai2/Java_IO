import java.io.File;
import java.io.IOException;

/**
  * @author:  Zhang
  * @description:
  *
  * 拷贝 文件夹   即拷贝文件夹下所有的文件
 **/
public class Copy_dir {
    public static void main(String[] args) {
        String s1="C:\\Users\\Administrator\\Desktop\\Test";
        String s2="C:\\Users\\Administrator\\Desktop\\new";

        File file1=new File(s1);
        copy_dir(file1,s2);
    }
    public static void copy_dir(File file1,String s2){
        File file2=new File(s2,file1.getName());
        file2.mkdirs();
        if (file1.isFile()){
            try {
                Copy_File.copy_file(file1.getAbsolutePath(),s2+"\\"+file1.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            File[] files=file1.listFiles();
            for (File file:files){
                copy_dir(file,s2+"\\"+file1.getName());
            }
        }
    }
}
