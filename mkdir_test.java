import java.io.File;
import java.io.FilenameFilter;


/**
  * @author:  Zhang
  * @description:
  *
  * 测试 mkdir    mkdirs     file.list（返回当前目录下的所有文件名）
 *                           file.listFiles  （条件，实现FileNameFilter接口（返回当前目录下所有符合条件的文件）
 **/
public class mkdir_test {
    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\Test";
        File file = new File(path);
        file.mkdir();//创建目录，路径必须存在
        file.mkdirs();//创建路径链
        file.isDirectory();

        //实现 FilenameFilter 接口的accept方法，返回指定的文件名
        File[] subFiles=file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir.getName());
                return new File(dir,name).isFile()&&name.endsWith(".java");
            }
        });

        for (File s:subFiles)
            System.out.println(s.getPath());
    }
}
